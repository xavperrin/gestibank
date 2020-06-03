/**
 * 
 */
package test;

import java.util.Date;

import gestibank.exception.CheckException;
import gestibank.society.Address;
import gestibank.society.Gender;
import gestibank.user.Manager;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Xavier Perrin
 *
 */
public class ManagerTest extends TestCase {
	Manager _validManager;
	
	
	   public ManagerTest(final String s) {
	        super(s);
	    }
	   
	   public static TestSuite suite() {
	        return new TestSuite(ManagerTest.class);
	    }


	/**
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		Address addr= new Address("3ter", "street1", "street2", "city", "zipcode", "country");
		_validManager=new Manager("bill000", "Bill", "Gates", "bilou@microsoft.fr", "passwordbill001", addr, Gender.MALE, 101, new Date());
	}
	 //==================================
    //=            Test cases          =
    //==================================

	/**
  * This test tries to create an object with valid values.
  */
 public void testCreateValidManager() throws CheckException {

     final Manager manager = new Manager("bill000", "Bill", "Gates", "bill@gates.com", "password000", 6654);
		assertEquals("Bill", manager.getFirstname());
		assertEquals("Gates", manager.getLastname());
		manager.checkData();
 }
 
 
public void testCreateManagerWithInvalidValues() throws Exception{
 	
 	try {
 		final Manager manager = new Manager("1234", "", "Gates", "bill@gates.com", "pass1234", 1523);
 		manager.checkData();
 		fail("Object with empty values should not be created");
 	} catch (CheckException e) {
     	assertEquals("Invalid user first name", e.getMessage());
     }
     try {
     	final Manager manager = new Manager("1234", "Bill", "", "bill@gates.com", "pass1234", 1523);
         manager.checkData();
         fail("Object with empty values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user last name", e.getMessage());
     }

     // Creates objects with null values
     try {
     	final Manager manager = new Manager("1234", null, "Gates", "bill@gates.com", "pass1234", 1523);
         manager.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user first name", e.getMessage());
     }
     try {
     	final Manager manager = new Manager("1234", "Bill", null, "bill@gates.com", "pass1234", 1523);
         manager.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user last name", e.getMessage());
     }
     
     try {
     	final Manager manager = new Manager("1234", "Bill", "Gates", null, "pass1234", 1523);
         manager.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user mail", e.getMessage());
     }
 }

/**
 * This test use each getter
 */
public void testAllGetters() {
	assertEquals("bill000", _validManager.getId());
	assertEquals("Bill", _validManager.getFirstname());
	assertEquals("Gates", _validManager.getLastname());
	assertEquals(new Address("3ter", "street1", "street2", "city", "zipcode", "country"), _validManager.getAddress());
	assertEquals("bilou@microsoft.fr", _validManager.getMail());
}

/**
 * This test use each setter
 */
public void testAllSetters() {
	_validManager.setFirstname("Bill12");
	_validManager.setLastname("Gates2");
	_validManager.setAddress(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"));
	_validManager.setMail("anotherMail");
	_validManager.setGender(Gender.FEMALE);
	assertEquals("Bill2", _validManager.getFirstname());
	assertEquals("Gates2", _validManager.getLastname());
	assertEquals("street12", _validManager.getAddress().getStreet1());
	assertEquals("street22", _validManager.getAddress().getStreet2());
	assertEquals("city2", _validManager.getAddress().getCity());
	assertEquals("zipcode2", _validManager.getAddress().getZipcode());
	assertEquals("country2", _validManager.getAddress().getCountry());
	assertEquals("anotherMail", _validManager.getMail());
	assertEquals(Gender.FEMALE, _validManager.getGender());
}

}
