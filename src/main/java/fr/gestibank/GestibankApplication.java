package fr.gestibank;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.gestibank.entity.user.Customer;
import fr.gestibank.repository.CustomerRepository;

@SpringBootApplication
public class GestibankApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GestibankApplication.class, args);
		
		CustomerRepository customerDao = ctx.getBean(CustomerRepository.class);
		
		customerDao.save(new Customer("Jean","Valjean","jeanvaljean@gmail.com","jeanjeanPW"));
		customerDao.save(new Customer("Johnny","Hallyday","aquecoucou@gmail.com","allumélefe"));
	}

}
