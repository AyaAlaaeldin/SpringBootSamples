package org.springframework.sample.model;


import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	void getAllEmployees();
	Employee getEmployeeById(long empid);
}