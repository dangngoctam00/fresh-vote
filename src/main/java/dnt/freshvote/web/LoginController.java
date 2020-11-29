package dnt.freshvote.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dnt.freshvote.domain.User;
import dnt.freshvote.service.UserService;


@Controller
public class LoginController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(ModelMap model) {
		model.put("user", new User());
		return "register";
	}
	
	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public String registerPost(@ModelAttribute User user) {
		userService.saveUser(user);
		return "redirect:/login";
	}
}
