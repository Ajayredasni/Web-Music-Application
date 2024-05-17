package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;  

import com.example.demo.entitiy.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	public UserEntity findByEmail(String email);
}
