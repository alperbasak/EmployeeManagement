package com.alperbasak.employeemanagement.service;

import com.alperbasak.employeemanagement.model.User;

import java.util.List;

public interface UserService {

    User findByUsername(String username);

    List<User> findAllUsers();

}
