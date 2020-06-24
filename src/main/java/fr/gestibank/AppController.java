package fr.gestibank;

<<<<<<< HEAD


import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 611e00dcf7b579fa053696c37cc5cd8bc2b3e573
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.gestibank.service.ManagerService;

@Controller
public class AppController {

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	/**
	 * Manager
	 */
	@Autowired
	private ManagerService manager;
	
	@RequestMapping("/manager")
	public String adminManager() {
		return "manager";
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public String create(Model model) {
		return "create";
	}

	@RequestMapping(value = { "/errorlogin" }, method = RequestMethod.GET)
	public String errorlogin(Model model) {
		return "errorlogin";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = { "/pageloggedOK" }, method = RequestMethod.GET)
	public String pageloggedOK(Model model) {
		return "pageloggedOK";
	}

	@RequestMapping(value = { "/pageprincipale" }, method = RequestMethod.GET)
	public String pageprincipale(Model model) {
		return "pageprincipale";
	}

	@RequestMapping(value = { "/subscription" }, method = RequestMethod.GET)
	public String subscription(Model model) {
		return "subscription";
	}

	@RequestMapping("/home")
	private String home() {
		return "home";
	}

	@RequestMapping("/about")
	private String about() {
		return "about";
	}
<<<<<<< HEAD
	

	
=======

>>>>>>> 611e00dcf7b579fa053696c37cc5cd8bc2b3e573
	@RequestMapping("/hello")
	private String hello() {
		return "hello";
	}

	@RequestMapping("/subscribe")
	public String subscribe() {
		return "subscribe";
	}

}
