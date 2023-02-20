package com.volthread;

import java.util.List;

import javax.sql.DataSource;

public interface CustomerDto {
	public void setDataSource(DataSource ds);

	   public void create(String name, String job, int age);

	   public Customer getCustomer(Integer id);
	
	   public List<Customer> listCustomers();
	  
	   public void delete(Integer id);
	   
	   public void update(Integer id, Integer age);
	}
