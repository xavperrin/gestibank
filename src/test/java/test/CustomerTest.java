/**
 * 
 */
package test;

import fr.gestibank.entity.exception.CheckException;
import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.society.MaritalStatus;
import fr.gestibank.entity.user.Customer;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * @author Xavier Perrin
 *
 */

public class CustomerTest extends TestCase {
	private Customer _validCustomer;
	private Customer _voidCustomer;
	
	
	   public CustomerTest(final String s) {
	        super(s);
	    }
	   
	   public static TestSuite suite() {
	        return new TestSuite(CustomerTest.class);
	    }


	/**
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		Address addr= new Address("3ter", "street1", "street2", "city", "zipcode", "country");
		_validCustomer=new Customer("Bill", "Gates", "bilou@microsoft.fr", "passwordbill001", addr, Gender.MALE, MaritalStatus.Married  );
		_voidCustomer=new Customer();
	}
	 //==================================
    //=            Test cases          =
    //==================================

	/**
  * This test tries to create an object with valid values.
  */
 public void testCreateValidCustomer() throws CheckException {

     final Customer customer = new Customer("Bill", "Gates", "bill@gates.com", "password000");
		assertEquals("Bill", customer.getFirstname());
		assertEquals("Gates", customer.getLastname());
		customer.checkData();
 }
 
 
public void testCreateManagerWithInvalidValues() throws Exception{
 	
 	try {
 		final Customer customer = new Customer("", "Gates", "bill@gates.com", "pass1234");
 		customer.checkData();
 		fail("Object with empty values should not be created");
 	} catch (CheckException e) {
     	assertEquals("Invalid user first name", e.getMessage());
     }
     try {
     	final Customer customer = new Customer("Bill", "", "bill@gates.com", "pass1234");
         customer.checkData();
         fail("Object with empty values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user last name", e.getMessage());
     }

     // Creates objects with null values
     try {
     	final Customer customer = new Customer(null, "Gates", "bill@gates.com", "pass1234");
         customer.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user first name", e.getMessage());
     }
     try {
     	final Customer customer = new Customer("Bill", null, "bill@gates.com", "pass1234");
         customer.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user last name", e.getMessage());
     }
     
     try {
     	final Customer customer = new Customer("Bill", "Gates", null, "pass1234");
         customer.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user mail", e.getMessage());
     }
 }

/**
 * This test use each getter
 */
public void testAllGetters() {
	assertEquals("Bill", _validCustomer.getFirstname());
	assertEquals("Gates", _validCustomer.getLastname());
	assertEquals(new Address("3ter", "street1", "street2", "city", "zipcode", "country"), _validCustomer.getAddress());
	assertEquals("bilou@microsoft.fr", _validCustomer.getMail());
	assertEquals(MaritalStatus.Married, _validCustomer.getMaritalStatus());
	
}

/**
 * This test use each setter
 */
public void testAllSetters() {
	_validCustomer.setFirstname("Bill2");
	_validCustomer.setLastname("Gates2");
	_validCustomer.setAddress(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"));
	_validCustomer.setMail("anotherMail");
	_validCustomer.setGender(Gender.FEMALE);
	_validCustomer.setMaritalStatus(MaritalStatus.Divorced);
	assertEquals("Bill2", _validCustomer.getFirstname());
	assertEquals("Gates2", _validCustomer.getLastname());
	assertEquals(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"), _validCustomer.getAddress());
	assertEquals("anotherMail", _validCustomer.getMail());
	assertEquals(Gender.FEMALE, _validCustomer.getGender());
	assertEquals(MaritalStatus.Divorced, _validCustomer.getMaritalStatus());
}


/**
 * This test use each setter
 */
public void testAllSettersWithDefaultConstructor() {
	_voidCustomer.setFirstname("Ada");
	_voidCustomer.setLastname("Lovelace");
	_voidCustomer.setAddress(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"));
	_voidCustomer.setMail("ada.lovelace@live.com");
	_voidCustomer.setGender(Gender.FEMALE);
	_voidCustomer.setMaritalStatus(MaritalStatus.Divorced);
	assertEquals("Ada", _voidCustomer.getFirstname());
	assertEquals("Lovelace", _voidCustomer.getLastname());
	assertEquals(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"), _voidCustomer.getAddress());
	assertEquals("ada.lovelace@live.com", _voidCustomer.getMail());
	assertEquals(Gender.FEMALE, _voidCustomer.getGender());
	assertEquals(MaritalStatus.Divorced, _voidCustomer.getMaritalStatus());
}

/**
 * The following tests mail contents
 */
public void testCheckMailWithValidLength() {
	Customer customer = _validCustomer;
    boolean b = customer.checkMail();
    assertEquals(customer.getMail() + " est une adresse de longueur valide", true, b);
}

public void testCheckMailWithTooShortLength() {
	Customer customer = _validCustomer;
    customer.setMail("x@x.fr");
    boolean b = customer.checkMail();
    assertEquals("x@x.fr est une adresse trop courte => Echec", false, b);
}

public void testCheckMailWithTooLongLength() {
	Customer customer = _validCustomer;
    customer.setMail("engagelejeuquejelegagne@duel-de-mots.fr");
    boolean b = customer.checkMail();
    assertEquals(customer.getMail() + " est une adresse trop longue => Echec", false, b);
}

public void testCheckMailWithArrobas() {
	Customer customer = _validCustomer;
    boolean b = customer.checkMail();
    assertEquals(true, b);
}

public void testCheckMailWithoutArrobas() {
	Customer customer = _validCustomer;
    customer.setMail("nobody.nowhere");
    boolean b = customer.checkMail();
    assertEquals("Adresse sans @ => Echec", false, b);
}

public void testCheckMailsWithValidDomain() {
	Customer customer = _validCustomer;
    boolean b = customer.checkMail();
    assertEquals("Adresse should be OK!", true, b);
    customer.setMail("anyone@cnam.fr");
    assertEquals("Adresse should be OK!", true, b);
    customer.setMail("anyone@x.ue");
    assertEquals("Adresse should be OK!", true, b);
}

public void testCheckMailsWithInvalidDomain() {
	Customer customer = _validCustomer;
    customer.setMail("nobody@x.com");
    boolean b = customer.checkMail();
    assertFalse("Forbidden domain!", b);
    customer.setMail("nobody@x.us");
    b = customer.checkMail();
    assertFalse("Forbidden country!", b);
}



}