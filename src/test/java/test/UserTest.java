package test;

import fr.gestibank.entity.exception.CheckException;
import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.user.User;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This class tests the Customer class
 */
public final class UserTest extends TestCase {
	
	// ======================================
	// =             Attributes             =
	// ======================================
	User _validUser;

    public UserTest(final String s) {
        super(s);
    }
    
    public void setUp() {
		// Creates a valid customer
		
		_validUser = new User("bill000", "Bill", "Gates",   "bilou@microsoft.fr", "passwordbill001", 
				new Address("3ter", "street1", "street2", "city", "zipcode", "country"),
				Gender.MALE);
	}
    

    public static TestSuite suite() {
        return new TestSuite(UserTest.class);
    }

    //==================================
    //=            Test cases          =
    //==================================

    /**
     * This test tries to create an object with valid values.
     */
    public void testCreateValidUser() throws CheckException {

        final User user = new User("bill000", "Bill", "Gates",  "bill@gates.com", "password000");
		assertEquals("Bill", user.getFirstname());
		assertEquals("Gates", user.getLastname());
		user.checkData();

    }

    /**
     * This test tries to create an object with invalid values.
     */
    public void testCreateUserWithInvalidValues() throws Exception{
    	
    	try {
    		final User user = new User("1234", "", "Gates", "bill@gates.com", "pass1234");
    		user.checkData();
    		fail("Object with empty values should not be created");
    	} catch (CheckException e) {
        	assertEquals("Invalid user first name", e.getMessage());
        }
        try {
        	final  User user = new User("1234", "Bill", "", "bill@gates.com", "pass1234");
            user.checkData();
            fail("Object with empty values should not be created");
        } catch (CheckException e) {
        	assertEquals("Invalid user last name", e.getMessage());
        }

        // Creates objects with null values
        try {
        	final  User user = new User("1234", null, "Gates", "bill@gates.com", "pass1234");
            user.checkData();
            fail("Object with null values should not be created");
        } catch (CheckException e) {
        	assertEquals("Invalid user first name", e.getMessage());
        }
        try {
        	final User user = new User("1234", "Bill", null, "bill@gates.com", "pass1234");
            user.checkData();
            fail("Object with null values should not be created");
        } catch (CheckException e) {
        	assertEquals("Invalid user last name", e.getMessage());
        }
        
        try {
        	final User user = new User("1234", "Bill", "Gates", null, "pass1234");
            user.checkData();
            fail("Object with null values should not be created");
        } catch (CheckException e) {
        	assertEquals("Invalid user mail", e.getMessage());
        }
    }
    
    /**
	 * This test use each getter
	 */
	public void testAllGetters() {
		assertEquals("bill000", _validUser.getId());
		assertEquals("Bill", _validUser.getFirstname());
		assertEquals("Gates", _validUser.getLastname());
		assertEquals("3ter", _validUser.getAddress().getStreetNumber());
		assertEquals("street1", _validUser.getAddress().getStreet1());
		assertEquals("street2", _validUser.getAddress().getStreet2());
		assertEquals("city", _validUser.getAddress().getCity());
		assertEquals("zipcode", _validUser.getAddress().getZipcode());
		assertEquals("country", _validUser.getAddress().getCountry());
		assertEquals("bilou@microsoft.fr", _validUser.getMail());
	}

	/**
	 * This test use each setter
	 */
	public void testAllSetters() {
		_validUser.setFirstname("Bill2");
		_validUser.setLastname("Gates2");
		_validUser.setAddress(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"));
		_validUser.setMail("anotherMail");
		_validUser.setGender(Gender.FEMALE);
		assertEquals("Bill2", _validUser.getFirstname());
		assertEquals("Gates2", _validUser.getLastname());
		assertEquals("street12", _validUser.getAddress().getStreet1());
		assertEquals("street22", _validUser.getAddress().getStreet2());
		assertEquals("city2", _validUser.getAddress().getCity());
		assertEquals("zipcode2", _validUser.getAddress().getZipcode());
		assertEquals("country2", _validUser.getAddress().getCountry());
		assertEquals("anotherMail", _validUser.getMail());
		assertEquals(Gender.FEMALE, _validUser.getGender());
	}
    
    
	/**
	 * The following tests mail contents
	 */
	public void testCheckMailWithValidLength() {
		User user = _validUser;
	    boolean b = user.checkMail();
	    assertEquals(user.getMail() + " est une adresse de longueur valide", true, b);
	}

	public void testCheckMailWithTooShortLength() {
		User user = _validUser;
	    user.setMail("x@x.fr");
	    boolean b = user.checkMail();
	    assertEquals("x@x.fr est une adresse trop courte => Echec", false, b);
	}
	
	public void testCheckMailWithTooLongLength() {
		User user = _validUser;
	    user.setMail("engagelejeuquejelegagne@duel-de-mots.fr");
	    boolean b = user.checkMail();
	    assertEquals(user.getMail() + " est une adresse trop longue => Echec", false, b);
	}
	
	public void testCheckMailWithArrobas() {
		User user = _validUser;
	    boolean b = user.checkMail();
	    assertEquals(true, b);
    }

	public void testCheckMailWithoutArrobas() {
		User user = _validUser;
	    user.setMail("nobody.nowhere");
	    boolean b = user.checkMail();
	    assertEquals("Adresse sans @ => Echec", false, b);
    }

	public void testCheckMailsWithValidDomain() {
		User user = _validUser;
	    boolean b = user.checkMail();
	    assertEquals("Adresse should be OK!", true, b);
	    user.setMail("anyone@cnam.fr");
	    assertEquals("Adresse should be OK!", true, b);
	    user.setMail("anyone@x.ue");
	    assertEquals("Adresse should be OK!", true, b);
	}
	
	public void testCheckMailsWithInvalidDomain() {
		User user = _validUser;
	    user.setMail("nobody@x.com");
	    boolean b = user.checkMail();
	    assertFalse("Forbidden domain!", b);
	    user.setMail("nobody@x.us");
	    b = user.checkMail();
	    assertFalse("Forbidden country!", b);
    }
	
	
	

}