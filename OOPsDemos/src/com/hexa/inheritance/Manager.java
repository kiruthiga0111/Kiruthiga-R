package com.hexa.inheritance;

public class Manager extends Employee {
	String city;
	public Manager(String employeeName, double salary) {
		super(employeeName,salary);
		this.city=city;
	}
	
}
