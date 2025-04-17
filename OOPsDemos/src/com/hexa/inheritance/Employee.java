package com.hexa.inheritance;

public class Employee {
	String employeeName;
	double salary;
	
	public Employee(String employeeName, double salary) {
		super();
		this.employeeName=employeeName;
		this.salary=salary;
	}
	void printDetails() {
		System.out.println(employeeName);
		System.out.println(salary);
	}

}
