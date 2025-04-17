package com.payxpert.main;

import com.payxpert.dao.EmployeeDaoImpl;
import com.payxpert.dao.IEmployeeDao;
import com.payxpert.model.Employee;
import java.time.LocalDate;

public class Client {
	public static void main(String[] args) {
		// Create an employee with null terminationDate
		Employee employee1 = new Employee(1, "John", "Doe", LocalDate.of(1985, 5, 20), "Male", "john.doe@example.com",
				"1234567890", "123 TElm St", "Developer", LocalDate.of(2010, 1, 15));
		Employee employee2 = new Employee(2, "Ram", "roe", LocalDate.of(2013, 5, 20), "Male", "ram.roe@example.com",
				"6284767890", "33 Elmy St", "tester", LocalDate.of(2023, 1, 15));
		Employee employee3 = new Employee(3, "priya", "R", LocalDate.of(2000, 5, 20), "female", "priya@example.com",
				"985320890", "3 KElm St", "Developer", LocalDate.of(2014, 1, 15));

		IEmployeeDao nEmployee = new EmployeeDaoImpl();
		nEmployee.addEmployee(employee1);
		nEmployee.addEmployee(employee2);
		nEmployee.addEmployee(employee3);

		nEmployee.updateEmployee(3, "kiru@example");
		
		nEmployee.deleteEmployee(2);
		
		employee1=nEmployee.getById(1);
		
		if(employee1 !=null) {
			System.out.println("details");
			System.out.println("ID "+ employee1.getEmployeeID());
			System.out.println("First Name "+ employee1.getFirstName());
			System.out.println("Last name "+ employee1.getLastName());
			System.out.println("IDEmail "+ employee1.getEmail());
			
			
		}else {
			System.out.println("no Employee exists");
		}
	}
}
