package com.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java.bean.Student;

public class StreamTerminalOperation {

	public static void main(String[] args) {

		/*
		 * 1. allMatch()operation - This is a short-circuiting terminal operation
		 * because the operation stops immediately if any unmatched element is found
		 * (just like short-circuit behavior of the AND operator
		 */
		List<String> allMatchLst = Arrays.asList("Selva", "Selva", "P", "Selva", "selva");
		boolean allMatchBoolean = allMatchLst.stream().allMatch(p -> p.equalsIgnoreCase("Selva"));
		System.out.println("allMatch-Terminal return boolean : : " + allMatchBoolean);

		List<String> allMaLst = Arrays.asList("Selva", "Pandy", "Yazhini", "Murugan");

		List<Student> studentLst = new ArrayList<Student>();

		studentLst.add(new Student(79, "Selva", "M"));
		studentLst.add(new Student(69, "Pandy", "M"));
		studentLst.add(new Student(89, "Yazhini", "F"));
		studentLst.add(new Student(99, "Kumar", "M"));
		studentLst.add(new Student(59, "Nanacy", "F"));
		studentLst.add(new Student(99, "Cate", "M"));
		studentLst.add(new Student(95, "Asai", "F"));
		studentLst.add(new Student(97, "kmk", "M"));

		//filter with student gender
		List<Student> maleStudentList = studentLst.stream().filter(s -> s.getStudentGender().equals("M"))
										.collect(Collectors.toList());
		System.out.println("Male student list : : " + maleStudentList);

		Long maxScore = studentLst.stream().filter(student -> student.getStudentScore() > 90).count();
		System.out.println("student maxScore : : " + maxScore);

		List<String> nameLst = studentLst.stream().filter(student -> student.getStudentGender().equalsIgnoreCase("M"))
							  .map(student -> student.getStudentName()).collect(Collectors.toList());
		System.out.println("Male nameLst" + nameLst);
		
		
		
		List<Student> sortedLst=studentLst.stream().sorted((s1,s2)-> s1.getStudentName().compareTo(s2.getStudentName())).collect(Collectors.toList());
		System.out.println("sortedLst with name asc order : : "+ sortedLst);
		
		//sortedLst.stream().for
		
		
		//studentLst.stream().filter(empl->empl.getEmployeeAge>30).collect(Collectors.groupingBy(empl->empl.getName(),Collectors.counting()));

		Map hashMap= new HashMap();
		//hashMap.fo
		
		// List(Map<String, List>)

		// boolean allMatchBoolean=allMatchLst.stream().allMatch(p->
		// p.equalsIgnoreCase("Selva"));
		// System.out.println("allMatch-Terminal return boolean : : "+allMatchBoolean);

		// Filter and Sort - String
		List<String> strLst = Arrays.asList("Selva", "Pandy", "Abc", "Bbc");
		strLst = strLst.stream().filter(s -> !s.equals("Selva")).sorted().collect(Collectors.toList());
		System.out.println(strLst);

	}

}
