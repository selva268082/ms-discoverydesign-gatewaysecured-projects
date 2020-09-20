package com.employee.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Department {
	
  @Id
 // @GeneratedValue
  private int dept_Id;	 
  private int dept_no;
  private String dept_name;
  
	/*
	 * @ManyToOne private Employee employee;
	 */
  @OneToMany(mappedBy="department")
  private Set<Employee> employees;
  
  
  
  
  
public Set<Employee> getEmployees() {
	return employees;
}

public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
}

public int getDept_Id() {
	return dept_Id;
}

public void setDept_Id(int dept_Id) {
	this.dept_Id = dept_Id;
}

public int getDept_no() {
	return dept_no;
}

public void setDept_no(int dept_no) {
	this.dept_no = dept_no;
}

public String getDept_name() {
	return dept_name;
}

public void setDept_name(String dept_name) {
	this.dept_name = dept_name;
}

/*
 * public Employee getEmployee() { return employee; }
 * 
 * public void setEmployee(Employee employee) { this.employee = employee; }
 */

}
