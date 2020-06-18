package fr.gestibank;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fr.gestibank.entity.user.User;
import fr.gestibank.repository.UserRepository;

@SpringBootApplication
public class GestibankApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GestibankApplication.class, args);
		
		UserRepository userDao = ctx.getBean(UserRepository.class);
		
		// Sauvegarde en dur pour tester
		userDao.save(new User("Jean","Valjean","pasdechance@gmail.com","jeanjeanPW"));
	}

}
