package com.springmaster.springbegin.service;

import com.springmaster.springbegin.model.User;

import java.util.List;

public interface UserService {

    public User addUser(User user);
    public User getUserById(long userId);
    public List<User> getAllUsers();

}
