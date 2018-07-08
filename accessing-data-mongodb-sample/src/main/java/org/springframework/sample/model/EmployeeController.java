package org.springframework.sample.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController{
	 @Autowired
	  private EmployeeRepository employeeRepository;
	 
	 @Autowired
	 private EmployeeService employeeService;
	 
	
	
    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        List<Employee> employees = this.employeeRepository.findAll();

        return employees;
    }

    @PutMapping
    public void insert(@RequestBody Employee employee){
        this.employeeRepository.insert(employee);
    }

    @PostMapping
    public void update(@RequestBody Employee employee){
        this.employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") long id){
    	
    	  Employee employee = this.employeeService.getEmployeeById(id);
    	  this.employeeRepository.save(employee);
    	//Employee employee = this.employeeRepository.findById(id);

        return employee;
    }

}