package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import fr.gestibank.GestibankApplication;
import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.user.User;
import fr.gestibank.repository.UserRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=GestibankApplication.class)

@SpringBootTest(classes = UserRepository.class)
public class UserRepositoryTest {
	
	
	
	@Autowired
	private UserRepository userDao;
	
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
		_user.setAddress(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"));
		_user.setMail("katherine.johnson@gmail.com");
		_user.setGender(Gender.FEMALE);
		return _user;
	}

}
