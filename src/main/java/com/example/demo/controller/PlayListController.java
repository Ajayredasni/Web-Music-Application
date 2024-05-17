package com.example.demo.controller;

import java.util.List;        
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entitiy.PlayListEntitiyCustomer;
import com.example.demo.entitiy.PlayListEntity;
import com.example.demo.entitiy.SongsEntity;
import com.example.demo.entitiy.UserEntity;
import com.example.demo.services.PlayListCustomerServies;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongsService;
import com.example.demo.services.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class PlayListController {
	@Autowired
	PlayListService playListService;
	@Autowired
	PlayListCustomerServies playListCustomerServies;
	@Autowired
	SongsService songsService;
	@Autowired
	UserService userService;
//	======================= Admin ============================== //
//	Show The Songs to Choose Songs to create PlayList.
	@GetMapping("createPlayListAdminHomePage")
	public String createPlayListCusto(Model model)
	{
		List<SongsEntity> songsEntity= songsService.fetchSongs();
		model.addAttribute("songsList",songsEntity);
		return "createPlayListAdmin";
	}
	
//	Create Admin PlayList
	@PostMapping("addPlayListAdmin")
	public String addPlayList(@ModelAttribute PlayListEntity playListEntity)
	{
//		adding play list
		playListService.addPlayList(playListEntity);
//		updating song
		List<SongsEntity> songlist=playListEntity.getSongsEntity();
		for(SongsEntity songsEntity:songlist)
		{
			songsEntity.getPlayListEntity().add(playListEntity);
			songsService.updatesong(songsEntity);
		}
		return "playListSuccess";
	}
	
//	Display The Admin PlayList.
	@GetMapping("viewPlayListAdmin")
	public String viewPlayListAdmin(Model model,HttpSession session)
	{
//		Retrieve logged-in user information from the session.
		String userEmail=(String) session.getAttribute("email");
//		Fetch the user from the database using email.
		UserEntity userEntity=userService.getUser(userEmail);
		boolean userStatus=userEntity.isPremiumCustomer();
		String role=userEntity.getRole();
		if(userStatus==true || role.equals("Admin"))
		{
			List<PlayListEntity> playListEntities =playListService.fetchPlayList();
			model.addAttribute("playListEntities",playListEntities);
			return "viewPlayListAdmin";
		}else {
				return "samplepayment";
		}
		
	}
	
//	================================================================================= //
	
//	=============================== Customer ======================================== //
	
	@GetMapping("createPlayListCustomerHomePage")
	public String createPlayListCustomer(Model model,HttpSession session)
	{
//		Retrieve logged-in user information from the session.
		String userEmail=(String) session.getAttribute("email");
//		Fetch the user from the database using email.
		UserEntity userEntity=userService.getUser(userEmail);
		boolean userStatus=userEntity.isPremiumCustomer();
		if(userStatus==true)
		{
			List<SongsEntity> songsEntity= songsService.fetchSongs();
			model.addAttribute("songsList",songsEntity);
			return "createPlayListCustomer";
		}else {
			return "samplepayment";
		}
		
	}
//	
	@PostMapping("addPlayListCustomer")
	public String addPlayListCustomer(@ModelAttribute PlayListEntitiyCustomer playEntitiyCustomer,HttpSession session,Model model)
	{
//		Retrieve logged-in user information from the session.
		String userEmail=(String) session.getAttribute("email");
//		Fetch the user from the database using email.
		UserEntity userEntity=userService.getUser(userEmail);
//		Set the user as the creator of the playList.
		playEntitiyCustomer.setUserEntity(userEntity);
//		Save the PlayList
		playListCustomerServies.addPlayList(playEntitiyCustomer);
//		Add The Song to playListName In SongsEntity one by one 
		List<SongsEntity> songsEntities=playEntitiyCustomer.getSongsEntity();
		for(SongsEntity songsEntity:songsEntities)
		{
			songsEntity.getPlayListEntityCustomer().add(playEntitiyCustomer);
			songsService.updatesong(songsEntity);
		}
		
//		Add the PlayList to the user's list of PlayLists
		List<PlayListEntitiyCustomer>playListEntitiesCustomer=userEntity.getUseEntitiyCustomers();
		playListEntitiesCustomer.add(playEntitiyCustomer);
		userEntity.setUseEntitiyCustomers(playListEntitiesCustomer);
		userService.updateUser(userEntity);
		return "playListSuccess";		
	}
	
	@GetMapping("viewPlayListCustomer")
	public String viewPlayListCustomer(Model model,HttpSession session) {
//		Retrieve logged-in user information from the session.
		String userEmail=(String) session.getAttribute("email");
//		Fetch the user from the database using email.
		UserEntity userEntity=userService.getUser(userEmail);
		boolean userStatus=userEntity.isPremiumCustomer();
		if(userStatus==true)
		{
			List<PlayListEntitiyCustomer>playListEntitiyCustomers=userEntity.getUseEntitiyCustomers();
			model.addAttribute("playListEntities",playListEntitiyCustomers);
			return "viewPlayListCustomer";
		}else {
			return "samplepayment";
		}
	}
	
//	Show the playlist in particular customer in Admin.
	@GetMapping("viewPlayListParticularCustomer")
	public String viewPlayListParticularCustomer(@RequestParam String email,Model model ) {
//		Fetch the user from the database using email.
		UserEntity userEntity=userService.getUser(email);
		List<PlayListEntitiyCustomer>playListEntitiyCustomers=userEntity.getUseEntitiyCustomers();
		model.addAttribute("playListEntities",playListEntitiyCustomers);
		return "viewPlayListCustomer";
	}
	
		
}
