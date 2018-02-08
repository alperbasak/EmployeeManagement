package com.alperbasak.employeemanagement.dao;

import com.alperbasak.employeemanagement.model.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee findEmployeeById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeBySsn(String ssn);

    List<Employee> findAllEmployees();

    Employee findEmployeeBySsn(String ssn);
}
