package com.alperbasak.employeemanagement.service;

import com.alperbasak.employeemanagement.dao.EmployeeDao;
import com.alperbasak.employeemanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;

    @Override
    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }

    @Override
    public Employee findById(int id) {
        return dao.findEmployeeById(id);
    }

    @Override
    public Employee findBySsn(String ssn) {
        return dao.findEmployeeBySsn(ssn);
    }

    @Override
    public void saveEmployee(Employee employee) {
       dao.saveEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee em=dao.findEmployeeById(employee.getId());
        if (em!=null){
            em.setName(employee.getName());
            em.setJoiningDate(employee.getJoiningDate());
            em.setSalary(employee.getSalary());
            em.setSsn(employee.getSsn());
        }
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {
        dao.deleteEmployeeBySsn(ssn);
    }

    @Override
    public boolean isEmployeeSsnUnique(Integer id, String ssn) {
        Employee employee=findBySsn(ssn);
        return (employee == null ||(id!=null&&employee.getId()==id));
    }
}
