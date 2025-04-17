package com.payxpert.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.payxpert.exception.EmployeeNotFoundException;
import com.payxpert.model.Employee;
import com.payxpert.util.DbConnectionUtil; // Corrected class reference

public class EmployeeDaoImpl implements IEmployeeDao {
    static Connection connection;

    @Override
    public void addEmployee(Employee employee) {
        connection = DbConnectionUtil.getConnection();
        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, employee.getEmployeeID());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setDate(4, Date.valueOf(employee.getDateOfBirth()));
            statement.setString(5, employee.getGender());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getPhoneNumber());
            statement.setString(8, employee.getAddress());
            statement.setString(9, employee.getPosition());
            statement.setDate(10, Date.valueOf(employee.getJoiningDate()));
            if (employee.getTerminationDate() != null) {
                statement.setDate(11, Date.valueOf(employee.getTerminationDate()));
            } else {
                statement.setNull(11, Types.DATE);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, statement, connection);
        }
    }

    @Override
    public void updateEmployee(int employeeId, String email) {
        connection = DbConnectionUtil.getConnection();
        String sql = "UPDATE employee SET Email = ? WHERE Employee_ID = ?";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setInt(2, employeeId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found for update.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, statement, connection);
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        connection = DbConnectionUtil.getConnection();
        String sql = "DELETE FROM employee WHERE employee_ID = ?";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, employeeId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found for deletion.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, statement, connection);
        }
    }

    @Override
    public Employee getById(int employeeId) {
        connection = DbConnectionUtil.getConnection();
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        Employee employee = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, employeeId);
            rs = statement.executeQuery();

            if (rs.next()) {
                employee = mapResultSetToEmployee(rs);
            } else {
                throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, statement, connection);
        }

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        connection = DbConnectionUtil.getConnection();
        String sql = "SELECT * FROM employee";
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Employee> employeeList = new ArrayList<>();

        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                Employee employee = mapResultSetToEmployee(rs);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, statement, connection);
        }

        return employeeList;
    }

    // Utility method to convert ResultSet into Employee object
    private Employee mapResultSetToEmployee(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getInt("employee_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("date_of_birth").toLocalDate(),
                rs.getString("gender"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getString("address"),
                rs.getString("position"),
                rs.getDate("joining_date").toLocalDate(),
                rs.getDate("termination_date") != null ? rs.getDate("termination_date").toLocalDate() : null
        );
    }

    // Utility method to close resources
    private void closeResources(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) { e.printStackTrace(); }

        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) { e.printStackTrace(); }

        try {
            if (conn != null) conn.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
