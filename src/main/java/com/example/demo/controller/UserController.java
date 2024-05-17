package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entitiy.PlayListEntity;
import com.example.demo.entitiy.SongsEntity;
import com.example.demo.entitiy.UserEntity;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongsService;
import com.example.demo.services.UserService;
import com.example.demo.services.UserServiceImplementation;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	SongsService songsService;
	@Autowired
	UserServiceImplementation userServiceImplementation;
	@Autowired
	PlayListService playListService;

	@PostMapping("register")
	public String addUser(@ModelAttribute UserEntity userEntity) {

		boolean userstatus = userService.emailExists(userEntity.getEmail());
		if (userstatus == false) {
			userService.addUser(userEntity);
			return "registerSuccess";
		} else {
			return "registerFail";
		}
	}

	@PostMapping("index")
	public String validdateUser(@RequestParam String email, @RequestParam String password,HttpSession session) {
		if(userServiceImplementation.userExist(email))
		{
			return "loginFail";
		}else {
		if (userService.validateUser(email, password)) {
			session.setAttribute("email", email);
//			checking whether the user is admin or not
			if (userService.getRole(email).equals("Admin")) {
				return "adminHome";
			} else {
				String Useremail=(String) session.getAttribute("email");
				UserEntity userEntity=userService.getUser(Useremail);
				boolean userStatus=userEntity.isPremiumCustomer();
				if(userStatus==true)
				{
					return "customerhome";
				}else {	
					return "samplepayment";
				}
			}
		} else {
			return "loginFail";
		}
	  }
	}
	
	@GetMapping("viewsongs")
	public String exploreSongs(HttpSession session,Model model)
	{
		String email=(String) session.getAttribute("email");
		UserEntity userEntity=userService.getUser(email);
		boolean userStatus=userEntity.isPremiumCustomer();
		if(userStatus==true)
		{
			List<SongsEntity> songsEntity= songsService.fetchSongs();
			model.addAttribute("songsList",songsEntity);
			return "CustomerViewSongs";
		}else {
			return "samplepayment";
		}
	}
	
	@GetMapping("ViewPlayList")
	public String viewPlayList(HttpSession session,Model model) {
		
		String email=(String) session.getAttribute("email");
		UserEntity userEntity=userService.getUser(email);
		boolean userStatus=userEntity.isPremiumCustomer();
		if(userStatus==true)
		{
			List<PlayListEntity> playListEntities =playListService.fetchPlayList();
			model.addAttribute("playListEntities",playListEntities);
			return "viewPlayList";
		}else {
			return "samplepayment";
		}
		
	}

	@GetMapping("logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "LogoutSuccessfully";
	}

}
