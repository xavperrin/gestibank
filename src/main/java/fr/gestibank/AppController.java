package fr.gestibank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
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

}
