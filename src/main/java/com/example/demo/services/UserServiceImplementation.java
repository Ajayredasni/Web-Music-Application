package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitiy.UserEntity;
import com.example.demo.repositories.UserRepository;
@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	UserRepository userRepository;
	
	@Override
	public String addUser(UserEntity userEntity) {
		userRepository.save(userEntity);
		return "User is created and saved !";
	}

	@Override
	public boolean emailExists(String email) {
		if(userRepository.findByEmail(email)==null)
		{
			return false;
		}else {
			return true;
		}
		
	}
	
//	check email exist in database or not
	public boolean userExist(String email)
	{
		if(userRepository.findByEmail(email)==null)
		{
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		UserEntity userEntity=userRepository.findByEmail(email);
		String db_password=userEntity.getPassword();
		if(db_password.equals(password))
		{
			return true;
		}else {	
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		return (userRepository.findByEmail(email).getRole());
	}

	@Override
	public UserEntity getUser(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void updateUser(UserEntity userEntity) {
		userRepository.save(userEntity);
	}

}
