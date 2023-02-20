package com.volthread;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompanyDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

	      CustomerJdbcTemplate customerJdbcTemplate = 
	         (CustomerJdbcTemplate)context.getBean("customerJdbcTemplate");
	      
	      System.out.println("------Create--------" );
	      customerJdbcTemplate.create("Veysel","Engineer", 26);
	      customerJdbcTemplate.create("Resul","Enginer", 27);
	      customerJdbcTemplate.create("Ali","Architect" , 35);
	      customerJdbcTemplate.create("Ömer","Seller" , 30);


	      System.out.println("------Listing All Customer--------" );
	      List<Customer> customers = customerJdbcTemplate.listCustomers();
	      
	      for (Customer record : customers) {
	         System.out.print("ID : " + record.getId() );
	         System.out.print(", Name : " + record.getName() );
	         System.out.print(", Job : " + record.getJob() );
	         System.out.println(", Age : " + record.getAge());
	      }

	      System.out.println("----Updating Customer with ID = 4 -----" );
	      customerJdbcTemplate.update(4, 20);

	      System.out.println("----Listing Customer with ID = 1 -----" );
	      Customer customer = customerJdbcTemplate.getCustomer(1);
	      System.out.print("ID : " + customer.getId() );
	      System.out.print(", Name : " + customer.getName() );
	      System.out.println(", Age : " + customer.getAge());
	   }	}


