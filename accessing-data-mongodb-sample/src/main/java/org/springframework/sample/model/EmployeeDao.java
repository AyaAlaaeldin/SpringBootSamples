package org.springframework.sample.model;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeDao {
	void insertEmployee(Employee cus);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long empId);
}