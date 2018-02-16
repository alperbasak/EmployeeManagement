package com.alperbasak.employeemanagement.dao;

import com.alperbasak.employeemanagement.model.Employee;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer,Employee> implements EmployeeDao {

    @Override
    public Employee findEmployeeById(int id) {
        return getByKey(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        delete(getByKey(id));
    }

    @Override
    public List<Employee> findAllEmployees() {
        CriteriaQuery<Employee> query=createEntityCriteriaQuery();
        query.select(query.from(Employee.class));
        return getSession().createQuery(query).list();
    }

    @Override
    public Employee findEmployeeByPhone(String phone) {
        CriteriaQuery<Employee> query=createEntityCriteriaQuery();
        Root<Employee> root=query.from(Employee.class);
        query.select(root).where(createCriteriaBuilder().equal(root.get("phoneNumber"),phone));
        return getSession().createQuery(query).uniqueResult();
    }

    @Override
    public Employee findEmployeeByEmail(String email) {
        CriteriaQuery<Employee> query=createEntityCriteriaQuery();
        Root<Employee> root=query.from(Employee.class);
        query.select(root).where(createCriteriaBuilder().equal(root.get("email"),email));
        return getSession().createQuery(query).uniqueResult();
    }

}
