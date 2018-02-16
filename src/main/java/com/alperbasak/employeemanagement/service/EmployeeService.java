package com.alperbasak.employeemanagement.service;

import com.alperbasak.employeemanagement.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();

    Employee findById(int id);

    Employee findByPhone(String phone);

    Employee findByEmail(String email);

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(int id);

    boolean isEmployeeEmailUnique(Integer id, String email);

    boolean isEmployeePhoneUnique(Integer id, String phone);

}
