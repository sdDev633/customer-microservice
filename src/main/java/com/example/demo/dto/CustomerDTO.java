package com.example.demo.dto;


import java.util.List;

import com.example.demo.entity.Customer;
import com.example.demo.external.Product;

public class CustomerDTO {
	private Customer customer;
	    private List<Product> products;  // Use List<Product>

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    public List<Product> getProducts() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;  // Accept a List of Products
    }
}
	

