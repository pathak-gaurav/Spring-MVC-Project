package com.spring.gaurav.service;

import java.util.List;

import com.spring.gaurav.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
