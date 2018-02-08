package com.alperbasak.employeemanagement.service;

import com.alperbasak.employeemanagement.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();

    Employee findById(int id);

    Employee findBySsn(String ssn);

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeBySsn(String ssn);

    boolean isEmployeeSsnUnique(Integer id, String ssn);

}
