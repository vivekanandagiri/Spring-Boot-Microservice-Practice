package com.ait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String saveUser(@ModelAttribute("user") UserDTO user, Model model) {
		userService.registerUser(user);
		return "redirect:/login";
	}

	@GetMapping(value = "/login")
	public String showLoginPage() {
		return "login";
	}

	@PostMapping(value = "/login")
	public String userLogin(@RequestParam String email, @RequestParam String password, Model model, HttpSession session,
			RedirectAttributes redirectAttributes) {
		UserDTO user = userService.loginUser(email, password);

		if (user != null) {
			session.setAttribute("user", user.getEmail());
			redirectAttributes.addFlashAttribute("msg", " User Logged in successfully !!");
			return "redirect:/list_product";
		} else {
			/*-------------Approach 1----------------*/
			// rendered in the same page
			// model.addAttribute("errorMessage", "Invalid email or password. Please try
			// again.");
			// return "login";
			/*-------------Approach 2----------------*/
			// redirect and show the response
			redirectAttributes.addFlashAttribute("errorMessage", "Invalid email or password. Please try again.");
			return "redirect:/login";
		}
	}

	@GetMapping(value ="/logout" )
	public String logout(HttpSession session,RedirectAttributes redirectAttributes) {
		String user = (String) session.getAttribute("user");
		if(user!=null) {
			//invalidate the session
			session.invalidate();
			//session.removeAttribute("user");
			//if you want to remove particular attribute from  session manager the this remove attribute method can be used 
		redirectAttributes.addFlashAttribute("errorMessage", "User Logged Out");
		return "redirect:/login";
		}
		else {
			return "redirect:/login";
		}
	}

}
