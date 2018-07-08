# SpringBootSamples

A spring boot application that searches oracle database for a specific employee and insert the matched employee in mongo DB.

Assuming you have oracle relational database as described in below link and mongo database installed on your machine
https://apexplained.wordpress.com/2013/04/20/the-emp-and-dept-tables-in-oracle/


- Change Datasource of oracle database in application.properties file, to a defined datasource on your machine as below:
spring.datasource.url={database_url} 
spring.datasource.username={username}
spring.datasource.password={password}

- Add peoperties for mongo db in application.properties :
spring.data.mongodb.host={hostname}
spring.data.mongodb.port={port_number}
spring.data.mongodb.database={database_name}

- Change server port in application.properties (if needed) : 
server.port = 8088

- Compile and package application using mvn command : 
mvn package

- Run application using mvn command : 
mvn spring-boot:run


Test sample
- To retrieve a specific employee in oracle db & insert in mongo : 
http://localhost:8088/employees/{employee_id}

- To display all employees in mongo db : 
http://localhost:8088/employees/all

- To insert new employee in mongo database : 
POST http://localhost:8088/employees
{"id":1001,"empName":"Test Employee","empJob":"Accountant","empMgr":"8088", "empDept":"10"}
