package com.springmaster.springbegin.controller;


import com.springmaster.springbegin.model.User;
import com.springmaster.springbegin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/createUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        System.out.println("user##"+user.getFirstName());
            User userData = service.addUser(user);
            if(userData==null){
                throw new RuntimeException("No UserData Found");
            }
            return new ResponseEntity<User>(userData, HttpStatus.CREATED);
        }
}


