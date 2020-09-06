package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@PostMapping(path = "/create")
	public String createEmployee(@RequestBody List<Employee> employeeLst)
	{
		empService.saveEmployee(employeeLst);
		return "";
	}
}
