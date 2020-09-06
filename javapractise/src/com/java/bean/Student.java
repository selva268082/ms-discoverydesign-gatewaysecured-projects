package com.java.bean;

public class Student implements Comparable<Student> {
	private int studentScore;
	private String studentName;
	private String studentGender;

	public Student(int studentScore, String studentName, String studentGender) {
		super();
		this.studentScore = studentScore;
		this.studentName = studentName;
		this.studentGender = studentGender;
	}

	public int getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(int studentScore) {
		this.studentScore = studentScore;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	@Override
	public int compareTo(Student anotherStudent) {
		return anotherStudent.getStudentScore()-this.getStudentScore();
	}

	@Override
	public String toString() {
		return "Student [studentScore=" + studentScore + ", studentName=" + studentName + ", studentGender="
				+ studentGender + "]";
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
