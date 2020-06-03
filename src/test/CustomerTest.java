/**
 * 
 */
package test;

import java.util.Date;

import gestibank.exception.CheckException;
import gestibank.society.Address;
import gestibank.society.Gender;
import gestibank.user.Customer;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Xavier Perrin
 *
 */
public class CustomerTest extends TestCase {
	Customer _validCustomer;
	
	
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
		_validCustomer=new Customer("bill000", "Bill", "Gates", "bilou@microsoft.fr", "passwordbill001", addr, Gender.MALE);
	}
	 //==================================
    //=            Test cases          =
    //==================================

	/**
  * This test tries to create an object with valid values.
  */
 public void testCreateValidCustomer() throws CheckException {

     final Customer customer = new Customer("bill000", "Bill", "Gates", "bill@gates.com", "password000");
		assertEquals("Bill", customer.getFirstname());
		assertEquals("Gates", customer.getLastname());
		customer.checkData();
 }
 
 
public void testCreateManagerWithInvalidValues() throws Exception{
 	
 	try {
 		final Customer customer = new Customer("1234", "", "Gates", "bill@gates.com", "pass1234");
 		customer.checkData();
 		fail("Object with empty values should not be created");
 	} catch (CheckException e) {
     	assertEquals("Invalid user first name", e.getMessage());
     }
     try {
     	final Customer customer = new Customer("1234", "Bill", "", "bill@gates.com", "pass1234");
         customer.checkData();
         fail("Object with empty values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user last name", e.getMessage());
     }

     // Creates objects with null values
     try {
     	final Customer customer = new Customer("1234", null, "Gates", "bill@gates.com", "pass1234");
         customer.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user first name", e.getMessage());
     }
     try {
     	final Customer customer = new Customer("1234", "Bill", null, "bill@gates.com", "pass1234");
         customer.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid user last name", e.getMessage());
     }
     
     try {
     	final Customer customer = new Customer("1234", "Bill", "Gates", null, "pass1234");
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
	assertEquals("bill000", _validCustomer.getId());
	assertEquals("Bill", _validCustomer.getFirstname());
	assertEquals("Gates", _validCustomer.getLastname());
	assertEquals(new Address("3ter", "street1", "street2", "city", "zipcode", "country"), _validCustomer.getAddress());
	assertEquals("bilou@microsoft.fr", _validCustomer.getMail());
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
	assertEquals("Bill2", _validCustomer.getFirstname());
	assertEquals("Gates2", _validCustomer.getLastname());
	assertEquals(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"), _validCustomer.getAddress());
	assertEquals("anotherMail", _validCustomer.getMail());
	assertEquals(Gender.FEMALE, _validCustomer.getGender());
}

}