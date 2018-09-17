package com.spring.gaurav.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.gaurav.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> list = session.createQuery("from Customer", Customer.class).getResultList();
		if (list.isEmpty()) {
			session.save(new Customer("Zack", "Anderson", "zack@anderson.com"));
			session.save(new Customer("Zoella", "Sugg", "zoella@sugg.com"));
			session.save(new Customer("Alfie", "Dyes", "alfie@dyes.com"));
			session.save(new Customer("Theresa", "May", "theresa@may.com"));
		}
		return list;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(theCustomer);
	}

}
