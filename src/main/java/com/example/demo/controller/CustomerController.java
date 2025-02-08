package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Apiresponse;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	@Operation(summary = "Getting All customers GET ")
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getAllCustomersController() {
	    return ResponseEntity.ok(customerService.getAllCustomers1());
	}

	@Operation(summary = "Getting Single customers GET ")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        
        // If customer is not found (null), return 404 or empty response
        if (customerDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customerDTO);
    }
	
	@Operation(summary = "Post customers GET ")
	@PostMapping("/")
	public ResponseEntity<String> createCustomerController(@RequestBody Customer customer){
		return ResponseEntity.ok(customerService.createCustomer(customer));
	}
	
	@Operation(summary = "Update getting ")
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCustomerController(@PathVariable Long id, @RequestBody Customer customer){
		return ResponseEntity.ok(customerService.updateCustomer(id, customer));
	}
	
	@Operation(summary = "Delete  customers ")
	@Hidden
	@DeleteMapping("/{id}")
	public ResponseEntity<Apiresponse> deleteCustomerController(@PathVariable Long id){
		              customerService.deleteCustomer(id);
		              return new ResponseEntity<>(new Apiresponse("Customer not found", false, "200 ok"),HttpStatus.OK);
	}
	
		
}
