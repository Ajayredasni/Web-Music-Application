package com.example.demo.services;

import java.util.List;

import com.example.demo.entitiy.PlayListEntitiyCustomer;
public interface PlayListCustomerServies {
	public void addPlayList(PlayListEntitiyCustomer playListEntitiyCustomer);
	public List<PlayListEntitiyCustomer> fetchPlayList();
}
