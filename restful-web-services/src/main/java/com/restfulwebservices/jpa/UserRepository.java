package com.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfulwebservices.users.User;

public interface UserRepository extends JpaRepository<User	, Integer>{

}
