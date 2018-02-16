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
    public Employee findByPhone(String phone) {
        return dao.findEmployeeByPhone(phone);
    }

    @Override
    public Employee findByEmail(String email) {
        return dao.findEmployeeByEmail(email);
    }

    @Override
    public void saveEmployee(Employee employee) {
       dao.saveEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee em=dao.findEmployeeById(employee.getId());
        if (em!=null){
            em.setFirstName(employee.getFirstName());
            em.setLastName(employee.getLastName());
            em.setEmail(employee.getEmail());
            em.setPhoneNumber(employee.getPhoneNumber());
            em.setJoiningDate(employee.getJoiningDate());
            em.setSalary(employee.getSalary());
            em.setCommissionPrc(employee.getCommissionPrc());
        }
    }

    @Override
    public void deleteEmployeeById(int id) {
        dao.deleteEmployeeById(id);
    }

    @Override
    public boolean isEmployeeEmailUnique(Integer id, String email) {
        Employee employee=findByEmail(email);
        return (employee == null ||(id!=null&&employee.getId()==id));
    }

    @Override
    public boolean isEmployeePhoneUnique(Integer id, String phone) {
        Employee employee=findByPhone(phone);
        return (employee == null ||(id!=null&&employee.getId()==id));
    }


}
