package com.volthread;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerJdbcTemplate implements CustomerDto{
	 	private DataSource dataSource;
	 	private JdbcTemplate jdbcTemplateObject;
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, String job, int age) {
		String SQL = "insert into customer (name, job, age) values (?, ?, ?)";
	      jdbcTemplateObject.update( SQL, name, job, age);
	      System.out.println("Created Record Name = " + name + " Job = " + job + "And age is:"+ age);
	      return;		
	}

	@Override
	public Customer getCustomer(Integer id) {
		String SQL = "select * from customer where id = ?";
	      Customer customer = jdbcTemplateObject.queryForObject(SQL,new Object[]{id}, new CustomerMapper());
	      return  customer;
	}

	@Override
	public List<Customer> listCustomers() {
		String SQL = "select * from customer";
		List <Customer> customers = jdbcTemplateObject.query(SQL, new CustomerMapper());
		return customers;
	}

	@Override
	public void delete(Integer id) {
		 String SQL = "delete from customer where id = ?";
	      jdbcTemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;		
	}

	@Override
	public void update(Integer id, Integer age) {
		  String SQL = "update customer set age = ? where id = ?";
	      jdbcTemplateObject.update(SQL, age, id);
	      System.out.println("Updated Record with ID = " + id );
	      return;		
	}

}
