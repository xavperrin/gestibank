/**
 * 
 */
package test;

import java.time.LocalDate;

import fr.gestibank.entity.exception.CheckException;
import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.user.Manager;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Xavier Perrin
 *
 */
public class ManagerTest extends TestCase {
	Manager _validManager;
	Manager _voidManager;
	
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
		_voidManager=new Manager();
		Address addr= new Address("3ter", "street1", "street2", "city", "zipcode", "country");
		_validManager=new Manager("Bill", "Gates", "bilou@microsoft.fr", "passwordbill001", addr, Gender.MALE, 101, LocalDate.now());
	}
	 //==================================
    //=            Test cases          =
    //==================================

	/**
  * This test tries to create an object with valid values.
  */
 public void testCreateValidManager() throws CheckException {

     final Manager manager = new Manager("Bill", "Gates", "bill@gates.com", "password000", 6654);
		assertEquals("Bill", manager.getFirstname());
		assertEquals("Gates", manager.getLastname());
		manager.checkData();
 }
 
 
public void testCreateManagerWithInvalidValues() throws Exception{
 	
 	try {
 		final Manager manager = new Manager("", "Gates", "bill@gates.com", "pass1234", 1523);
 		manager.checkData();
 		fail("Object with empty values should not be created");
 	} catch (CheckException e) {
     	assertEquals("Invalid user first name", e.getMessage());
     }
     try {
     	final Manager manager = new Manager("Bill", "", "bill@gates.com", "pass1234", 1523);
         manager.checkData();
         fail("Object with empty values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user last name", e.getMessage());
     }

     // Creates objects with null values
     try {
     	final Manager manager = new Manager(null, "Gates", "bill@gates.com", "pass1234", 1523);
         manager.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user first name", e.getMessage());
     }
     try {
     	final Manager manager = new Manager("Bill", null, "bill@gates.com", "pass1234", 1523);
         manager.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user last name", e.getMessage());
     }
     
     try {
     	final Manager manager = new Manager("Bill", "Gates", null, "pass1234", 1523);
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
	assertEquals("Bill", _validManager.getFirstname());
	assertEquals("Gates", _validManager.getLastname());
	assertEquals(new Address("3ter", "street1", "street2", "city", "zipcode", "country"), _validManager.getAddress());
	assertEquals("bilou@microsoft.fr", _validManager.getMail());
	assertEquals(101, _validManager.getStaffnumber());
}

/**
 * This test use each setter
 */
public void testAllSetters() {
	_voidManager.setFirstname("Ada");
	_voidManager.setLastname("Lovelace");
	_voidManager.setAddress(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"));
	_voidManager.setMail("anothermail@gmail.com");
	_voidManager.setGender(Gender.FEMALE);
	_voidManager.setStaffnumber(326556);
	assertEquals("Ada", _validManager.getFirstname());
	assertEquals("Lovelace", _voidManager.getLastname());
	assertEquals(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"), _validManager.getAddress());
	assertEquals("anothermail@gmail.com", _validManager.getMail());
	assertEquals(Gender.FEMALE, _voidManager.getGender());
	assertEquals(326556, _voidManager.getStaffnumber());
}



}
