package fr.gestibank;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.user.User;
import fr.gestibank.repository.UserRepository;

@SpringBootTest
class GestibankApplicationTests {

	@Autowired
	private UserRepository userDao;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testSaveUser() {
		User user=getUser();
		User savedUserInDb =userDao.save(user);
		User getFromDb = userDao.findById(savedUserInDb.getId()).get();
		
		assertEquals(getFromDb, savedUserInDb);
	}
	
	
	

	private User getUser() {
		User _user= new User();
		_user.setFirstname("Katherine");
		_user.setLastname("Johnson");
		_user.setAddress(new Address("2bis", "2729  Oxford Court", "street2", "Memphis", "38118", "United States"));
		_user.setMail("katherine.johnson@gmail.com");
		_user.setGender(Gender.FEMALE);
		return _user;
	}

}
