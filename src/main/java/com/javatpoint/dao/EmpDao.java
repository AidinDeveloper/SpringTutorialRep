package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.javatpoint.beans.Emp;

public class EmpDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Emp> getEmployeesByPage(int pageid, int total) {
		String sql =
		"select * from ( select a.*, ROWNUM rnum from   ( SELECT * FROM   emp e order by  e.ID ) a   where ROWNUM < "+(pageid+total)+" ) where rnum  >= "+(pageid);
		
		
		return template.query(sql, new RowMapper<Emp>() {
			public Emp mapRow(ResultSet rs, int row) throws SQLException {
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				return e;
			}
		});
	}
}