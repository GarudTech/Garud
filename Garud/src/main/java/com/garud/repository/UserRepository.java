package com.garud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garud.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String email);
}
