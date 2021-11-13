package com.springmaster.springbegin.controller;


import com.springmaster.springbegin.model.User;
import com.springmaster.springbegin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.xml.stream.Location;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/createUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User userData = service.addUser(user);
        System.out.println("user##" + user.getFirstName());
        return new ResponseEntity<User>(userData, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public EntityModel<User> getUserById(@PathVariable long userId){
        System.out.println("userId##" + userId);
        User userData = service.getUserById(userId);
        System.out.println("userId##" + userData);
        EntityModel<User> model = EntityModel.of(userData);
        WebMvcLinkBuilder linkToUser  = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());//hateos implimentation
        model.add(linkToUser.withRel("all-users"));
        return model;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = service.getAllUsers();
        System.out.println("userList##" + userList);
        return new ResponseEntity<List<User>>(userList, HttpStatus.FOUND);
    }

}


