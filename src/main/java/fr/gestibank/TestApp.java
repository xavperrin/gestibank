package fr.gestibank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.gestibank.entity.account.DepositAccount;
import fr.gestibank.service.DepositAccountService;


@Controller
@EnableAutoConfiguration
@ComponentScan()
public class TestApp extends SpringBootServletInitializer {

	
	@Autowired
	private DepositAccountService service; 

	public static void main(String[] args) {
		SpringApplication.run(TestApp.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TestApp.class);
	
	}
	/*
	@RequestMapping("/accounts")
	String accounts(Model model){
		
		List<DepositAccount> list = service.listAll();
		model.addAttribute("list", list);
		return "accounts";
	}*/
}
