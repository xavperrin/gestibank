package test;




import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.gestibank.entity.user.User;
import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.repository.UserRepository;

/**
 * 
 */



/**
 * @author Xavier Perrin
 *
 */

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {


	@Autowired
    private UserRepository repositoryUnderTest;
	
	
	private User ada;
	
	@Before
	public void setUp() {
		ada = new User("Ada", "Lovelace", "ada.lovelace@gmail.com", "superwoman");

	}
	
//	@Test
//	public void saveAdaAndFindById() {
//		User saved = repositoryUnderTest.save(ada);
//		assertThat(repositoryUnderTest.findById(saved.getId())).isEqualTo((ada));
//
//	}
//	
//	@Test
//    void findUsersBySearchCriteria() {
//		
//		final User user =new User("Ada", "Lovelace", "ada.lovelace@gmail.com", "superwoman");
//        final User _saved=repositoryUnderTest.save(user);
//        assertThat(_saved.getLastname()).isEqualTo("Lovelace");
// }
        
    
	
	@Test
	public void saveAdaAndFindByName() {
		final User saved = repositoryUnderTest.save(ada);
		assertTrue(repositoryUnderTest.findByLastname("Lovelace")).contains((ada));
	}

}
	  
