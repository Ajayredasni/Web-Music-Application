package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.example.demo.entitiy.SongsEntity;
import com.example.demo.repositories.SongsRepository;

@Service
public class SongsServiceImplementation implements SongsService{
	@Autowired
	SongsRepository songsRepository;

	@Override
	public String addSongs(SongsEntity songsEntity) {
		songsRepository.save(songsEntity);
		return "Songs Added Successfully";
	}

	@Override
	public boolean songExists(String songName) {
		if (songsRepository.findBysongName(songName) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<SongsEntity> fetchSongs() {
		return songsRepository.findAll();
	}

	@Override
	public void updatesong(SongsEntity songsEntity) {
		songsRepository.save(songsEntity);
	}

	}
