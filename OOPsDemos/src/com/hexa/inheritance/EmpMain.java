package com.hexa.inheritance;

public class EmpMain {
	public static void main(String[] args) {
		Employee employee= new Employee("A",9000);
		employee.printDetails();
		System.out.println("in manager");
		Manager manager=new Manager("B",1000);
		manager.printDetails();
		
		
	}

}
