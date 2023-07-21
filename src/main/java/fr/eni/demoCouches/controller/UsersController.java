package fr.eni.demoCouches.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.demoCouches.bll.UserService;
import fr.eni.demoCouches.bo.User;

@Controller
public class UsersController {
	 private final UserService userService;

	    @Autowired
	    public UsersController(UserService userService) {
	        this.userService = userService;
	    }

	    @GetMapping({"/", "/users"})
	    public String getUsersByAge(@RequestParam(name = "age", required = false, defaultValue = "0") int age, Model model) {
	        List<User> usersByAge = userService.getUsersByAge(age);
	        model.addAttribute("users", usersByAge);
	        model.addAttribute("selectedAge", age);
	        model.addAttribute("user", new User());//initialisation du formulaire
	        return "users";
	    }
	    
	    @PostMapping("/saveUser")
	    public String ajouterUser(User user) {
	    	this.userService.saveUser(user);
	    	return "redirect:/users?age=0";
	    }
}
