package fr.gestibank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.gestibank.entity.account.DepositAccount;
import fr.gestibank.entity.user.Customer;
import fr.gestibank.service.DepositAccountService;
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
	private DepositAccountService depositaccountservice; 
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/manager")
	public String adminManager(@RequestParam("id") Long id, Model model) {
		List<Customer> listCustomers = managerService.assignedCustomers(id);
		model.addAttribute("listCustomers", listCustomers);		
				
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

	@RequestMapping("/hello")
	private String hello() {
		return "hello";
	}

	@RequestMapping("/subscribe")
	public String subscribe() {
		return "subscribe";
	}
	
	@RequestMapping("/accounts")
	String accounts(Model model){
		
		List<DepositAccount> list = depositaccountservice.listAll();
		model.addAttribute("list", list);
		return "accounts";
	}
	
	
	  @RequestMapping("/accounts/{id}") String accounts(Model model, @PathVariable(name = "id") Long id){
	  List<DepositAccount> list = depositaccountservice.get(id);
	  
	  model.addAttribute("list", list);
	  
	  return "accounts_user";
	  
	  }
}
