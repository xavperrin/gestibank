package fr.gestibank;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.user.Customer;
import fr.gestibank.repository.AddressRepository;
import fr.gestibank.repository.CustomerRepository;

@SpringBootApplication
public class GestibankApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GestibankApplication.class, args);
		
		CustomerRepository customerDao = ctx.getBean(CustomerRepository.class);
		AddressRepository addressDao = ctx.getBean(AddressRepository.class);
		
		Address adr1 = new Address("890", "La Seine", "", "Paris", "75000", "France");
		addressDao.save(adr1);
		customerDao.save(new Customer("Jean","Valjean","jeanvaljean@gmail.com","jeanjeanPW", adr1, Gender.MALE));
		
		Address adr2 = new Address("890", "Rue du cimetière", "Dedans", "Bruxelles", "344 01", "Belgique");
		addressDao.save(adr2);
		customerDao.save(new Customer("Johnny","Hallyday","aquecoucou@gmail.com","allumélefe", adr2 , Gender.MALE));
	}

}
