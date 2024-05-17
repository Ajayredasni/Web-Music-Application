package com.example.demo.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entitiy.SongsEntity;
import com.example.demo.services.SongsService;

@Controller
public class SongController {
	@Autowired
	SongsService songsService;

	@PostMapping("addSongs")
	public String addSongs(@ModelAttribute SongsEntity songsEntity) {
		if (songsService.songExists(songsEntity.getSongName()) == false) {
			songsService.addSongs(songsEntity);
			return "songAddSuccessfully";
		} else {
			return "songAddedUnsuccessfully";
		}
	}
	@GetMapping("viewSongsAdminPage")
	public String fetchSongs(Model model)
	{
		List<SongsEntity> songsEntity= songsService.fetchSongs();
		model.addAttribute("songsList",songsEntity);
		return "AdminViewSongs";
	}
	
//	@GetMapping("viewSongsCustomerHomePage")
//	public String viewSongs(Model model)
//	{
//		boolean primeStatus=true;
//		if(primeStatus==true)
//		{
//			List<SongsEntity> songsEntity= songsService.fetchSongs();
//			model.addAttribute("songsList",songsEntity);
//			return "ViewSongs";
//		}else {
//			return "makePayment";
//		}
//	}

}
