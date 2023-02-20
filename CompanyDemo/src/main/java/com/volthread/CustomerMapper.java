package com.volthread;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer=new Customer();
		customer.setId(rs.getInt("id"));
		customer.setName(rs.getString("name"));
		customer.setJob(rs.getString("job"));
		customer.setAge(rs.getInt("age"));
		
		return customer;
	}

}
