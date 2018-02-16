package com.alperbasak.employeemanagement.dao;

import com.alperbasak.employeemanagement.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee findEmployeeById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeById(int id);

    List<Employee> findAllEmployees();

    Employee findEmployeeByPhone(String phone);

    Employee findEmployeeByEmail(String email);
}
