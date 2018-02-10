package com.alperbasak.employeemanagement.dao;

import com.alperbasak.employeemanagement.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao{
    @Override
    public User findByUsername(String username) {
        CriteriaQuery<User> query=createEntityCriteriaQuery();
        Root<User> root=query.from(User.class);
        query.select(root).where(createCriteriaBuilder().equal(root.get("username"),username));
        return getSession().createQuery(query).uniqueResult();
    }

    @Override
    public List<User> findAllUsers() {
        CriteriaQuery<User> query = createEntityCriteriaQuery();
        query.select(query.from(User.class));
        return getSession().createQuery(query).list();
    }
}
