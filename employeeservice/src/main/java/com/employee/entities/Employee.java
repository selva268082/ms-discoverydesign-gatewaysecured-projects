package com.employee.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity

public class Employee {
    @Id
    private int emp_Id;
    private String emp_first_name;
    private String emp_last_name;
    private String emp_email;
    private String emp_ip_address;
    private String emp_gender;
    @Embedded
    private EmployeeAddress emp_address;
    
	/*
	 * @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	 * 
	 * @JoinTable (name = "relationalTable" , joinColumns = @JoinColumn(name =
	 * "emp_Id"),inverseJoinColumns=@JoinColumn(name = "dept_Id")) private
	 * Collection<Department> department =new ArrayList<Department>();
	 */

    @ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="dept_Id")
	private Department department; 
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	/*
	 * public Collection<Department> getDepartment() { return department; }
	 * 
	 * public void setDepartment(Collection<Department> department) {
	 * this.department = department; }
	 */
	public int getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getEmp_first_name() {
		return emp_first_name;
	}

	public void setEmp_first_name(String emp_first_name) {
		this.emp_first_name = emp_first_name;
	}

	public String getEmp_last_name() {
		return emp_last_name;
	}

	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEmp_ip_address() {
		return emp_ip_address;
	}

	public void setEmp_ip_address(String emp_ip_address) {
		this.emp_ip_address = emp_ip_address;
	}

	public String getEmp_gender() {
		return emp_gender;
	}

	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}

	public EmployeeAddress getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(EmployeeAddress emp_address) {
		this.emp_address = emp_address;
	}


   
	
}
