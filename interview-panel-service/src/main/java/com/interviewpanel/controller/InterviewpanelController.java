package com.interviewpanel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interviewpanel.bean.Employee;
import com.interviewpanel.bean.InterviewQARequest;
//import com.interviewpanelsecurity.bean.User;
import com.interviewpanel.service.InterviewpanelService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
 
public class InterviewpanelController {
	
	@Autowired
	InterviewpanelService interviewpanelService;
	
	
//	@GetMapping(produces = "application/json")
//	@RequestMapping({ "/validateLogin" })
//	public User validateLogin() {
//		return new User("User successfully authenticated");
//	}

	//private List<Employee> employees = createList();
	private List<InterviewQARequest> interviewQARequestList = createInterviewQAList();

	//@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	@GetMapping("v1/qalist")
	public List<InterviewQARequest> firstPage() {
		System.out.println("--------get list interviewQA------>");
		return interviewpanelService.retrieveAllQAs();
	}

	@DeleteMapping(path = { "/{id}" })
	public InterviewQARequest delete(@PathVariable("id") String id) {
		InterviewQARequest deletedEmp = null;
		for (InterviewQARequest interviewQARequest : interviewQARequestList) {
			/*
			 * if (interviewQARequest.getQId().equals(id)) {
			 * interviewQARequestList.remove(interviewQARequest); deletedEmp =
			 * interviewQARequest; break; }
			 */
		}
		return deletedEmp;
	}

	@PostMapping("v1/addQA")
	public InterviewQARequest create(@RequestBody InterviewQARequest interviewQARequest) {
		System.out.println("------>Adding IQA");
		//interviewQARequestList.add(interviewQARequest);
		interviewpanelService.addInterviewQA(interviewQARequest);
		System.out.println(interviewQARequestList);
		return interviewQARequest;
	}

	/*
	 * private static List<Employee> createList() { List<Employee> tempEmployees =
	 * new ArrayList<>(); Employee emp1 = new Employee(); emp1.setName("emp1");
	 * emp1.setDesignation("manager"); emp1.setEmpId("1"); emp1.setSalary(3000);
	 * 
	 * Employee emp2 = new Employee(); emp2.setName("emp2");
	 * emp2.setDesignation("developer"); emp2.setEmpId("2"); emp2.setSalary(3000);
	 * tempEmployees.add(emp1); tempEmployees.add(emp2); return tempEmployees; }
	 */
	private static List<InterviewQARequest> createInterviewQAList() {
		List<InterviewQARequest> interviewQARequestList = new ArrayList<>();
		InterviewQARequest interviewQA = new InterviewQARequest();
	//	interviewQA.setQId("1");
		interviewQA.setEmployerName("TCS");
//		interviewQA.setInterviewDate("04/19/2020");
//		interviewQA.setQuestionAsked("What is Microservice?");
//		interviewQA.setGivenAnswer("Decoupling of monolithic application in to granular service.");
//		interviewQA.setTechnology("Microservice");

		InterviewQARequest interviewQA1 = new InterviewQARequest();
	//	interviewQA1.setQId("2");
		interviewQA1.setEmployerName("TCS");
		interviewQA1.setInterviewDate("04/19/2020");
//		interviewQA1.setQuestionAsked("What is Microservice?");
//		interviewQA1.setGivenAnswer("Decoupling of monolithic application in to granular service.");
//		interviewQA1.setTechnology("Microservice");
		
		interviewQARequestList.add(interviewQA);
		interviewQARequestList.add(interviewQA1);
		
		return interviewQARequestList;
	}
}
