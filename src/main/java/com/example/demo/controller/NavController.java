package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class NavController {
	@GetMapping("map-register")
	public String registerMap()
	{
		return "register";
	}
	
	@GetMapping("index")
	public String loginMap()
	{
		return "index";
	}
	@GetMapping("map-songs")
	public String mapSongs()
	{
		return "addSongs";
	}
	@GetMapping("makepayment")
	public String ordermapping()
	{
		return "samplepayment";
	}
	
	@GetMapping("particularCustomerplayListViewr")
	public String particularCustomerplayListViewr()
	{
		return "searchCustomerPlayList";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
}
