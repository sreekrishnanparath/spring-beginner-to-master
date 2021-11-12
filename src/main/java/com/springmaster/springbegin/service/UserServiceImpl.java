package com.springmaster.springbegin.service;

import com.springmaster.springbegin.dao.userDao;
import com.springmaster.springbegin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    userDao userDAO;


    @Override
    public User addUser(User user) {
        return userDAO.createUser(user);
    }

    @Override
    public User getUsers(long userId) {
        return userDAO.getUserById(userId);
    }
}
