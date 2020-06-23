package fr.gestibank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/home")
	String home(){
		return "home";
	}
	
	@RequestMapping("/about")
	String about(){
		return "about";
	}
	
}
