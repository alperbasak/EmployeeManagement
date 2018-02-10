package com.alperbasak.employeemanagement.dao;

import com.alperbasak.employeemanagement.model.User;

import java.util.List;

public interface UserDao {

    User findByUsername(String username);

    List<User> findAllUsers();
}
