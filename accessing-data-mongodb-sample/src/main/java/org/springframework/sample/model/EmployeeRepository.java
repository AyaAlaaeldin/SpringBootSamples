package org.springframework.sample.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {

	Employee findById(long id);
	
}
