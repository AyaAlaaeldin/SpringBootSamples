package org.springframework.sample;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.sample.model.Employee;
import org.springframework.sample.model.EmployeeRepository;
import org.springframework.sample.model.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    @Bean
    CommandLineRunner init(EmployeeRepository employeeRepository, EmployeeService employeeService) {

        return args -> {
            
        	System.out.println("Display All List in Mongo Before Insertion");
    		for (Employee emp : employeeRepository.findAll()) {
    			System.out.println(emp);
    		}
    		System.out.println();
        	
        	System.out.println("Enter Employee Number: ");
    		Scanner sc = new Scanner(System.in);
    		long i = sc.nextLong();
    		
    		
    		System.out.println("new object details: "+employeeService.getEmployeeById(i).toString());
        	
    		System.out.println("Insert New");
    		employeeRepository.save(employeeService.getEmployeeById(i));
        	
        	
    		System.out.println("Display All List in Mongo After Insertion");
    		for (Employee emp : employeeRepository.findAll()) {
    			System.out.println(emp);
    		}
    		System.out.println();
           
        };

    }

  */
}
