package com.example.demo.services;

import java.util.List; 

import com.example.demo.entitiy.PlayListEntity;
public interface PlayListService {
	public void addPlayList(PlayListEntity playListEntity);
	public List<PlayListEntity> fetchPlayList();
}
