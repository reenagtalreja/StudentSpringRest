package com.spring.maven.bean;
public class Student {
  private String studentId;
  private String firstName;
  private String lastName;
  private String college;
public String getStudentId() {
	return studentId;
}
public void setStudentId(String studentId) {
	this.studentId = studentId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}
@Override
public String toString() {
	return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", college="
			+ college + "]";
}
public Student(String studentId, String firstName, String lastName, String college) {
	super();
	this.studentId = studentId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.college = college;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
  
}
