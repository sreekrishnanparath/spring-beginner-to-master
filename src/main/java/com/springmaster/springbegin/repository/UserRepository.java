package com.springmaster.springbegin.repository;

import com.springmaster.springbegin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    public User findById(long id);


    public  User save(User user);

}
