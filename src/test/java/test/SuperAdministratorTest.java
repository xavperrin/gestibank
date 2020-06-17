/**
 * 
 */
package test;


import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;

import gestibank.exception.CheckException;
import gestibank.society.Address;
import gestibank.society.Gender;
import gestibank.user.Manager;
import gestibank.user.SuperAdministrator;
import junit.framework.TestCase;

/**
 * @author Jean-Francois
 *
 */
public class SuperAdministratorTest extends TestCase {

	
	   public SuperAdministratorTest(final String s) {
	        super(s);
	    }
	/**
	 * @throws java.lang.Exception
	 */
	private SuperAdministrator _validSuperAdmin;
	
	protected
	void setUp() throws Exception {
		Address addr= new Address("3ter", "street1", "street2", "city", "zipcode", "country");
		_validSuperAdmin=new SuperAdministrator("bill000", "Bill", "Gates", "bilou@microsoft.fr", "passwordbill001", addr, Gender.MALE, 101, LocalDate.now());
		
	}

	/**
	 * Test method for {@link gestibank.user.SuperAdministrator#SuperAdministrator(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateValidSuperAdmin() {
		final SuperAdministrator finalsuperadmin = new SuperAdministrator("bill000", "Bill", "Gates", "bill@gates.com", "password000", 6654);
		assertEquals("Bill", finalsuperadmin.getFirstname());
		assertEquals("Gates", finalsuperadmin.getLastname());
		try {
			finalsuperadmin.checkData();
		} catch (CheckException e) {
			assertEquals("testCreateValidSuperAdmin not working", e.getMessage());
		}
		
		
	}
	
	
	public void testCreateSuperAdminWithInvalidValues() throws Exception{
	 	
	 	try {
	 		final SuperAdministrator finalsuperadmin = new SuperAdministrator("1234", "", "Gates", "bill@gates.com", "pass1234", 1523);
	 		finalsuperadmin.checkData();
	 		fail("Object with empty values should not be created");
	 	} catch (CheckException e) {
	     	assertEquals("Invalid user first name", e.getMessage());
	     }
	     try {
	     	final SuperAdministrator finalsuperadmin = new SuperAdministrator("1234", "Bill", "", "bill@gates.com", "pass1234", 1523);
	     	finalsuperadmin.checkData();
	         fail("Object with empty values should not be created");
	     } catch (CheckException e) {
	     	assertEquals("Invalid user last name", e.getMessage());
	     }

	     // Creates objects with null values
	     try {
	     	final SuperAdministrator finalsuperadmin = new SuperAdministrator("1234", null, "Gates", "bill@gates.com", "pass1234", 1523);
	     	finalsuperadmin.checkData();
	         fail("Object with null values should not be created");
	     } catch (CheckException e) {
	     	assertEquals("Invalid user first name", e.getMessage());
	     }
	     try {
	     	final SuperAdministrator finalsuperadmin = new SuperAdministrator("1234", "Bill", null, "bill@gates.com", "pass1234", 1523);
	     	finalsuperadmin.checkData();
	         fail("Object with null values should not be created");
	     } catch (CheckException e) {
	     	assertEquals("Invalid user last name", e.getMessage());
	     }
	     
	     try {
	     	final SuperAdministrator finalsuperadmin = new SuperAdministrator("1234", "Bill", "Gates", null, "pass1234", 1523);
	     	finalsuperadmin.checkData();
	         fail("Object with null values should not be created");
	     } catch (CheckException e) {
	     	assertEquals("Invalid user mail", e.getMessage());
	     }
	 }

	/**
	 * This test use each getter
	 */
	public void testAllGetters() {
		assertEquals("bill000", _validSuperAdmin.getId());
		assertEquals("Bill", _validSuperAdmin.getFirstname());
		assertEquals("Gates", _validSuperAdmin.getLastname());
		assertEquals(new Address("3ter", "street1", "street2", "city", "zipcode", "country"), _validSuperAdmin.getAddress());
		assertEquals("bilou@microsoft.fr", _validSuperAdmin.getMail());
		assertEquals(101, _validSuperAdmin.getStaffNumber());
	}

	/**
	 * This test use each setter
	 */
	public void testAllSetters() {
		_validSuperAdmin.setFirstname("Bill2");
		_validSuperAdmin.setLastname("Gates2");
		_validSuperAdmin.setAddress(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"));
		_validSuperAdmin.setMail("anotherMail");
		_validSuperAdmin.setGender(Gender.FEMALE);
		_validSuperAdmin.setStaffNumber(326556);
		assertEquals("Bill2", _validSuperAdmin.getFirstname());
		assertEquals("Gates2", _validSuperAdmin.getLastname());
		assertEquals(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"), _validSuperAdmin.getAddress());
		assertEquals("anotherMail", _validSuperAdmin.getMail());
		assertEquals(Gender.FEMALE, _validSuperAdmin.getGender());
		assertEquals(326556, _validSuperAdmin.getStaffNumber());
	}


}
