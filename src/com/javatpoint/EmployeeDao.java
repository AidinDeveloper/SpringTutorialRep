package com.javatpoint;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
	private JdbcTemplate template;

	public void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Employee> getAllEmployees() {
		return template.query("select * from employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {
				Employee e=new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setSalary(rs.getInt("salary"));
				return e;
			}
		});
	}
}