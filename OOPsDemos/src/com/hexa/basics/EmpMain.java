package com.hexa.basics;

public class EmpMain {

	public static void main(String[] args) {
		Employee employee1= new Employee("Ram",2000);
		String result= employee1.greet();
		employee1.printDetails();
		employee1.calBonus(1000);
		
		System.out.println();
		
		Employee employee2= new Employee("Priya", 3000);
		result= employee2.greet();
		employee2.printDetails();
		employee2.calBonus(3000);
	}

}
