package com.spring.gaurav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.gaurav.entity.Customer;
import com.spring.gaurav.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/")
	public String listCustomers(Model model) {
		model.addAttribute("customer", customerService.getCustomers());
		return "customer-list";
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("customer") Customer theCustomer ) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/";
	}
}
