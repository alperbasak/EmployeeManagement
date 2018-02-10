package com.alperbasak.employeemanagement.service;

import com.alperbasak.employeemanagement.dao.UserDao;
import com.alperbasak.employeemanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User findByUsername(String username) {
       return userDao.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
}
