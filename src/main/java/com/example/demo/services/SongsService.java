package com.example.demo.services;

import java.util.List;

import com.example.demo.entitiy.SongsEntity;

public interface SongsService{
	public String addSongs(SongsEntity songsEntity);
	public boolean songExists(String songName); 
	List<SongsEntity> fetchSongs();
	public void updatesong(SongsEntity songsEntity);
}
