package com.springmaster.springbegin.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

//@JsonIgnoreProperties(value={"createdDate"})
//@JsonFilter("testFilter")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long userId;

    @Column
    public String firstName;
    @Column
    public String lastName;
    @Column
    public String brachId;
    @Column
    public String status;

    @Column
    @CreationTimestamp
    public Date createdDate;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBrachId() {
        return brachId;
    }

    public void setBrachId(String brachId) {
        this.brachId = brachId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User(long userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }
}


