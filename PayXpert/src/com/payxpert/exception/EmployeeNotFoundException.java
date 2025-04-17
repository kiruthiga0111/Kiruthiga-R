package com.payxpert.exception;


public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(int employeeId) {
        super("Employee with ID " + employeeId + " not found.");
    }
}