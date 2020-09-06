package com.java.coding.interview;

import java.util.Arrays;
import java.util.List;


class Person{
	
	private String fname;
	private String lname;
	private int Age;
	private String Address;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public Person(String fname, String lname, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		Age = age;
	}
	
	
	
	
	
}


public class LambaListChecking {
	
	public static void main(String[] args) {
		
		List<Person> listPerson= Arrays.asList(new Person("Selva","Pandy",25),new Person("Kumar","Senthil",27),new Person("Bala","Murugan",27));
		
		listPerson.stream();
		
	}

}
