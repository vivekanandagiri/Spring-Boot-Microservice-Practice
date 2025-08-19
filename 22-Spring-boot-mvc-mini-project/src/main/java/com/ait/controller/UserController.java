package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ait.dto.UserDTO;
import com.ait.service.UserService;
import com.ait.util.Gender;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping(value = "/register_user")
	public String getUserRegistrationPage(Model model) {
		model.addAttribute("user", new UserDTO());
		model.addAttribute("gender", Gender.values());
		return "registerUser";  
	}
	@PostMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute("user")UserDTO user,Model model) {
		 userService.registerUser(user);
		return "redirect:/login";
	}
	
	@GetMapping(value="/login")
    public String showLoginPage() {
        return "login"; 
    } 
	
	@PostMapping(value="/login")
	public String userLogin(@RequestParam String email, @RequestParam String password, Model model,HttpSession session) {
		UserDTO user = userService.loginUser(email, password);
		
		if (user != null) {
            session.setAttribute("userId", user.getId());
            return "redirect:/list_product"; 
        } else {
            model.addAttribute("errorMessage", "Invalid email or password. Please try again.");
            return "login";
        }
	}

}
