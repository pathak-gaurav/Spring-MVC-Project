package com.spring.gaurav.dao;

import java.util.List;

import com.spring.gaurav.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
