package com.employee.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {
	
	@NotNull(message = "Name should not be Null !")
	@Size(min = 2,max = 5,message = "name should be 5 characters")	
	private String fName;
	
	@NotNull
	//@NotEmpty(message = "email should not be empty!")
	//@NotBlank(message = "should not blank")
	@Size(min = 1, max = 100)
	@Pattern(regexp="^(.+)@(.+)$",message = "Invalid email Id!")
	private String email;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
