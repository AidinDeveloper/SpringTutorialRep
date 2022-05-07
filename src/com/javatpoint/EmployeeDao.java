package com.javatpoint;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;  
public class EmployeeDao {
	SimpleJdbcTemplate template;

	public EmployeeDao(SimpleJdbcTemplate template) {  
	        this.template = template;  
	}

	public int update(Employee e) {
		/*
		 * String query = "update employee set name=? where id=?"; return
		 * template.update(query, e.getName(), e.getId());
		 */

		//String query = "insert into employee values (?,?,?)";
		//return template.update(query, e.getId(),e.getName(),e.getSalary());
		
		String query = "Delete from  employee where id=?";
		return template.update(query, e.getId());
	}
}