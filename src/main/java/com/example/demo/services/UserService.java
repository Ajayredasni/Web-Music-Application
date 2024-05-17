package com.example.demo.services;

import com.example.demo.entitiy.UserEntity;

public interface UserService {
	public String addUser(UserEntity userEntity);
	public boolean emailExists(String email);
	public boolean validateUser(String email ,String password);
	public String getRole(String email);
	public UserEntity getUser(String email);
	public void updateUser(UserEntity userEntity);
}
