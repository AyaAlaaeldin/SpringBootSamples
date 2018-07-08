package org.springframework.sample.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertEmployee(Employee emp) {
		String sql = "INSERT INTO EMP " +
				"(EMPNO, ENAME) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				emp.getId(), emp.getEmpName()
		});
	}
	
	@Override
	public void insertEmployees(List<Employee> employees) {
		String sql = "INSERT INTO EMP " + "(EMPNO, ENAME) VALUES (?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Employee employee = employees.get(i);
				ps.setLong(1, employee.getId());
				ps.setString(2, employee.getEmpName());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});

	}
	@Override
	public List<Employee> getAllEmployees(){
		String sql = "SELECT * FROM EMP";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row:rows){
			Employee emp = new Employee();
			emp.setId((Long)row.get("EMPNO"));
			emp.setEmpName((String)row.get("ENAME"));
			result.add(emp);
		}
		
		return result;
	}

	@Override
	public Employee getEmployeeById(long empId) {
		String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
		return (Employee)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new RowMapper<Employee>(){
			@Override
			public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getLong("EMPNO"));
				emp.setEmpName(rs.getString("ENAME"));
				emp.setEmpJob(rs.getString("JOB"));
				emp.setEmpMgr(rs.getString("MGR"));
				emp.setEmpDept(rs.getString("DEPTNO"));
				return emp;
			}
		});
	}
}