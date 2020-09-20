package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.entities.Consumer;
import com.employee.entities.Employee;
import com.employee.repo.ConsumerRepo;
import com.employee.repo.EmployeeRepo;
import com.employee.response.ValidateResponse;

@Service
public class EmployeeService {

	
	@Autowired
	EmployeeRepo employeeRepo;
	
    @Autowired
	RestTemplate restTemplate;
	
	public void saveEmployee(List<Employee> employeeLst) {
		employeeRepo.saveAll(employeeLst);
	}
	
	public void validateEmployee(Employee employee) {
		
		String url="http://localhost:8090/org/emp/validate/{empId}";
		
		restTemplate.getForObject(url, ValidateResponse.class);
		
		
	}
	

}
