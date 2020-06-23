package fr.gestibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@EnableAutoConfiguration
@ComponentScan
public class TestApp extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(TestApp.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TestApp.class);
	
	}
	
	@RequestMapping("/")
	String home(){
		return "home";
	}
}
