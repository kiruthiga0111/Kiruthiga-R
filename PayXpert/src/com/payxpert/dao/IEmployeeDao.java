package com.payxpert.dao;

import com.payxpert.model.Employee;
import java.util.List;

public interface IEmployeeDao {
    void addEmployee(Employee employee);
    void updateEmployee(int employeeId, String email);
    void deleteEmployee(int employeeId);
    Employee getById(int employeeId);
    List<Employee> getAllEmployees();
}
