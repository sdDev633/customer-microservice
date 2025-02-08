package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.external.Product;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String createCustomer(Customer customer) {
		customerRepository.save(customer);
		return "Customer has been created";
	}
	

	   // Method to get customer by ID
	 public CustomerDTO getCustomerById(Long id) {
	        // Fetch the customer from the repository
	        Optional<Customer> customerOptional = customerRepository.findById(id);

	        // If the customer exists, proceed
	        if (customerOptional.isPresent()) {
	            Customer customer = customerOptional.get();

	            // Create CustomerDTO object to return
	            CustomerDTO customerDTO = new CustomerDTO();
	            customerDTO.setCustomer(customer);

	            // Ensure productId is not null before making the request
	            if (customer.getProductId() != null) {
	                // Fetch product details using RestTemplate
	                RestTemplate restTemplate = new RestTemplate();
	                Product product = restTemplate.getForObject("http://localhost:8081/api/products/" + customer.getProductId(), Product.class);

	                // If the product exists, wrap it in a list and set it in the DTO
	                if (product != null) {
	                    List<Product> productList = new ArrayList<>();
	                    productList.add(product);
	                    customerDTO.setProduct(productList);  // Assuming setProduct accepts a List<Product>
	                }
	            }

	            // Return the populated CustomerDTO
	            return customerDTO;
	        }

	        // If customer is not found, return an empty CustomerDTO (or null)
	        return null;  // Or you can return a new CustomerDTO() if you prefer
	    } 
    
//    public List<CustomerDTO> getAllCustomers1() {
//        // Fetch all customers from the repository
//        List<Customer> customers = customerRepository.findAll();
//        
//        // Create a list to store CustomerDTOs
//        List<CustomerDTO> customerDTOs = new ArrayList<>();
//        
//        // Iterate over each customer to populate CustomerDTO with product details
////        RestTemplate restTemplate = new RestTemplate();
//        
//        for (Customer customer : customers) {
//            // Create CustomerDTO and set customer details
//            CustomerDTO customerDTO = new CustomerDTO();
//            customerDTO.setCustomer(customer);
//            
//            // Ensure productId is not null before making the request
//            if (customer.getProductId() != null) {
//                // Fetch product details using RestTemplate
//                Product product = restTemplate.getForObject("http://localhost:8081/api/products/" + customer.getProductId(), Product.class);
//                
//                // If the product exists, wrap it in a list and set it in the DTO
//                if (product != null) {
//                    List<Product> productList = new ArrayList<>();
//                    productList.add(product);
//                    customerDTO.setProduct(productList);  // Assuming setProduct accepts a List<Product>
//                }
//            }
//            
//            // Add the populated CustomerDTO to the list
//            customerDTOs.add(customerDTO);
//        }
//
//        // Return the list of populated CustomerDTOs
//        return customerDTOs;
//    }

	
	public List<Customer> getAllCustomers1() {
		return customerRepository.findAll();
	}
	
	
	
	public String updateCustomer(Long id, Customer customer) {
		if(customerRepository.existsById(id)) {
			customerRepository.save(customer);
			
			return "Customer updated successfully";
		}
		return "Could not find customer";
	}


	
	public void deleteCustomer(Long id) {
		
		    customerRepository.deleteById(id);
		
	}
	
}
