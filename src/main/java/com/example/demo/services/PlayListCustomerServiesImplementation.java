package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entitiy.PlayListEntitiyCustomer;
import com.example.demo.repositories.PlayListCustomerRepository;

@Service
public class PlayListCustomerServiesImplementation implements PlayListCustomerServies {
	@Autowired
	PlayListCustomerRepository playListCustomerRepository;
		
	@Override
	public void addPlayList(PlayListEntitiyCustomer playListEntitiyCustomer) {
		playListCustomerRepository.save(playListEntitiyCustomer);
	}

	@Override
	public List<PlayListEntitiyCustomer> fetchPlayList() {
		return playListCustomerRepository.findAll();
	}

}
