package com.springmaster.springbegin.controller;


import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.springmaster.springbegin.model.User;
import com.springmaster.springbegin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import javax.xml.stream.Location;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    MessageSource messageSource;

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



    @GetMapping("/dynamic-filter-user/{userId}")
    public MappingJacksonValue getDynamicfilterUser(@PathVariable long userId){
        User userData = service.getUserById(userId);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userId","firstName");
        FilterProvider filters = new SimpleFilterProvider().addFilter("testFilter",filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userData);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping("/getMultiLan")// internalization concept
    public String sayGoodMorning() {
        return messageSource.
                getMessage("good.morning",null,"default good morning",LocaleContextHolder.getLocale());
    }

    @GetMapping("/v1/users")
    public ResponseEntity<User> getV1User() {
        User user = new User(1,"sree","krishnan");
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("/v2/users")
    public ResponseEntity<User> getV2User() {
        User user = new User(2,"sree","krishnan");
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping(value="/versioning/param",params = "version=1")
    public ResponseEntity<User> getV1paramsUser() {
        User user = new User(1,"sree","krishnan");
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping(value="/versioning/param",params = "version=2")
    public ResponseEntity<User> getV2paramsUser() {
        User user = new User(2,"sree","krishnan");
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping(value="/versioning/header",headers = "X-API-VERSION=1")
    public ResponseEntity<User> getV1HeadersUser() {
        User user = new User(1,"sree","krishnan");
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping(value="/versioning/header",headers = "X-API-VERSION=2")
    public ResponseEntity<User> getV2HeaderUser() {
        User user = new User(2,"sree","krishnan");
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping(value="/versioning/produces",headers = "application/vnd.company.app-v1+json")
    public ResponseEntity<User> getV1producesUser() {
        User user = new User(1,"sree","krishnan");
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping(value="/versioning/produces",produces = "application/vnd.company.app-v2+json")
    public ResponseEntity<User> getV2producesUser() {
        User user = new User(2,"sree","krishnan");
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
}


