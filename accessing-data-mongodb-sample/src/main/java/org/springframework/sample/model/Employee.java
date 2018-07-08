package org.springframework.sample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {

	//@Indexed (unique = true)
    @Id
    private long id;
    private String empName;
    private String empJob;
    private String empMgr;
    private String empDept;
    
    public Employee() {
    }

    public Employee(long id, String empName, String empJob, String empMgr, String empDept) {
        this.id = id;
        this.empName = empName;
        this.empJob = empJob;
        this.empMgr = empMgr;
        this.empDept = empDept;
    }

    
    //Id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    //Name
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
    //Job
    public String getEmpJob() {
        return empJob;
    }
    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }
    
   //Manager
    public String getEmpMgr() {
        return empMgr;
    }
    public void setEmpMgr(String empMgr) {
        this.empMgr = empMgr;
    }
    
    
  //Department
    public String getEmpDept() {
        return empDept;
    }
    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }


}