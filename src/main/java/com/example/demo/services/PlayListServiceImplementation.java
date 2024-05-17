package com.example.demo.services;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitiy.PlayListEntity;
import com.example.demo.repositories.PlayListRepositories;

@Service
public class PlayListServiceImplementation implements PlayListService {
	@Autowired
	PlayListRepositories playListRepositories;
	
	@Override
	public void addPlayList(PlayListEntity playListEntity) {
		playListRepositories.save(playListEntity);
	}

	@Override
	public List<PlayListEntity> fetchPlayList() {
		
		return playListRepositories.findAll();
	}

	
}
