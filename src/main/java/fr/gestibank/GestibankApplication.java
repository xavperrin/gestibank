package fr.gestibank;


import java.time.LocalDate;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.society.MaritalStatus;
import fr.gestibank.entity.user.Customer;
import fr.gestibank.entity.user.Manager;
import fr.gestibank.entity.user.SuperAdministrator;
import fr.gestibank.repository.AddressRepository;
import fr.gestibank.repository.CustomerRepository;
import fr.gestibank.repository.ManagerRepository;
import fr.gestibank.repository.SuperAdministratorRepository;

@SpringBootApplication
public class GestibankApplication {

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	    lci.setParamName("lang");
	    return lci;
	}
	
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GestibankApplication.class, args);
		
		SuperAdministratorRepository superAdminDao = ctx.getBean(SuperAdministratorRepository.class);
		ManagerRepository managerDao = ctx.getBean(ManagerRepository.class);
		CustomerRepository customerDao = ctx.getBean(CustomerRepository.class);
		AddressRepository addressDao = ctx.getBean(AddressRepository.class);
		
		
		
		
		// Ajout de customer Test
		Address adr1 = new Address("890", "La Seine", "", "Paris", "75000", "France");
		addressDao.save(adr1);
		Customer cust1 = new Customer("Jean","Valjean","jeanvaljean@gmail.com","jeanjeanPW", adr1, Gender.MALE,12,MaritalStatus.Single,"01 12 54 35 65");
		customerDao.save(cust1);
		
		Address adr2 = new Address("890", "Rue du cimetière", "Dedans", "Bruxelles", "344 01", "Belgique");
		addressDao.save(adr2);
		Customer cust2 = new Customer("Johnny","Hallyday","aquecoucou@gmail.com","allumélefe", adr2 , Gender.MALE,2,MaritalStatus.Divorced,"07 85 45 35 98");
		customerDao.save(cust2);
		
		
		// Ajout de manager Test
		Address adr3 = new Address("890", "Rue du cimetière", "Dedans", "Bruxelles", "344 01", "Belgique");
		addressDao.save(adr3);
		Manager mana1 = new Manager("Elodie", "Bouchard", "elobouch@gmail.com", "123456", adr3, Gender.FEMALE,2,"05 54 87 41 44");
		managerDao.save(mana1);
		
		
		Address adr4 = new Address("890", "Rue du cimetière", "Dedans", "Bruxelles", "344 01", "Belgique");
		addressDao.save(adr4);
		Manager mana2 = new Manager("Luc", "Martin", "lumart1@lycos.fr", "987654", adr4, Gender.MALE,3,"08 87 45 24 85");
		managerDao.save(mana2);
		
		
		SuperAdministrator supa = new SuperAdministrator("Chuck","Norris","TheOnlyOne@gmail.com","123", adr3, Gender.MALE,1,LocalDate.now());
		superAdminDao.save(supa);
		// System.out.println("id : "+mana2.getId()+" Prenom : "+mana2.getFirstname());
	}


//  https://stackoverflow.com/questions/46659679/spring-boot-application-and-messagesource	
	/*
	  @Bean public LocaleResolver localeResolver() {
	  
	  SessionLocaleResolver localResolver=new SessionLocaleResolver();
	  localResolver.setDefaultLocale(Locale.US); return localResolver; }
	  
	  */
	 /* 
									 
	 * @Bean(name = "messageResourceSB") public MessageSource messageResource() {
	 * ResourceBundleMessageSource messageBundleResrc=new
	 * ResourceBundleMessageSource();
	 * messageBundleResrc.setBasename("i18n/messages"); return messageBundleResrc; }
	 */
	 
}