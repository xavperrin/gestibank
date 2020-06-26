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

import fr.gestibank.entity.account.DepositAccount;
import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.society.MaritalStatus;
import fr.gestibank.entity.user.Customer;
import fr.gestibank.entity.user.Manager;
import fr.gestibank.entity.user.SuperAdministrator;
import fr.gestibank.repository.AddressRepository;
import fr.gestibank.repository.CustomerRepository;
import fr.gestibank.repository.DepositAccountRepository;
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
		DepositAccountRepository depoDao = ctx.getBean(DepositAccountRepository.class);
		

		
		
		// Ajout de manager Test
		Address adr3 = new Address("890", "Rue du cimetière", "Dedans", "Bruxelles", "344 01", "Belgique");
		addressDao.save(adr3);
		Manager mana1 = new Manager("Elodie", "Bouchard", "elobouch@gmail.com", "123456", adr3, Gender.FEMALE,2,"05.54.87.41.44");
		managerDao.save(mana1);
		
		
		Address adr4 = new Address("890", "Rue du cimetière", "Dedans", "Bruxelles", "344 01", "Belgique");
		addressDao.save(adr4);
		Manager mana2 = new Manager("Luc", "Martin", "lumart1@lycos.fr", "987654", adr4, Gender.MALE,3,"08.87.45.24.85");
		managerDao.save(mana2);
		
		
		// Ajout du SuperAdmin Test
		SuperAdministrator supa = new SuperAdministrator("Chuck","Norris","TheOnlyOne@gmail.com","123", adr3, Gender.MALE,1,LocalDate.now());
		superAdminDao.save(supa);
		
		
		// Ajout de customer Test
		Address adr1 = new Address("890", "La Seine", "", "Paris", "75000", "France");
		addressDao.save(adr1);
		Customer cust1 = new Customer("Jean","Valjean","jeanvaljean@gmail.com","jeanjeanPW", adr1, Gender.MALE,12,MaritalStatus.Single,"01.12.54.35.65");
		cust1.setManager(mana1);
		customerDao.save(cust1);
		
		Address adr2 = new Address("890", "Rue du cimetière", "Dedans", "Bruxelles", "344 01", "Belgique");
		addressDao.save(adr2);
		Customer cust2 = new Customer("Johnny","Hallyday","aquecoucou@gmail.com","allumélefe", adr2 , Gender.MALE,2,MaritalStatus.Divorced,"07.85.45.35.98");
		cust2.setManager(mana1);
		customerDao.save(cust2);

		Customer cust3 = new Customer("Larry ","Greco","elfordAchin@teleworm.us ","password", adr1 , Gender.MALE,0,MaritalStatus.Single,"01.04.57.08.08");
		cust3.setManager(mana2);
		customerDao.save(cust3);
		
		Customer cust4 = new Customer("Amanda ","Thomsen","MalagigiMaheu@rhyta.com ","introuvable", adr1 , Gender.FEMALE,1,MaritalStatus.Single,"01.66.59.98.22");
		cust4.setManager(mana2);
		customerDao.save(cust4);
		
		Customer cust5 = new Customer("Auda ","Chicoine","LangleyCarignan@rhyta.com ","erreur", adr1 , Gender.FEMALE,0,MaritalStatus.Divorced,"01.73.88.77.84");
		cust5.setManager(mana1);
		customerDao.save(cust5);
		
		DepositAccount acc1 = new DepositAccount("FR7630001007941234567890185",1545.32,cust1);
		depoDao.save(acc1);
		
		DepositAccount acc2 = new DepositAccount("FR7630004000031234567890143",10452.48,cust1);
		depoDao.save(acc2);
		
		DepositAccount acc3 = new DepositAccount("FR7630006000011234567890189",7402.21,cust1);
		depoDao.save(acc3);
		
		DepositAccount acc4 = new DepositAccount("FR7610107001011234567890129",124.88,cust2);
		depoDao.save(acc4);
		
		DepositAccount acc5 = new DepositAccount("FR7611315000011234567890138",0.54,cust2);
		depoDao.save(acc5);
		

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