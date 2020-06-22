/**
 * 
 */
package test;


import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.util.SerializationUtils;

import fr.gestibank.entity.exception.CheckException;
import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.user.SuperAdministrator;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Xavier
 *
 */
public class SuperAdministratorTest extends TestCase {

	
	   public SuperAdministratorTest(final String s) {
	        super(s);
	    }
	   
	   public static TestSuite suite() {
	        return new TestSuite(SuperAdministratorTest.class);
	    }
	
	private SuperAdministrator _validSuperAdmin;
	private SuperAdministrator _voidSuperAdmin;
	
	/**
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		Address addr= new Address("3ter", "street1", "street2", "city", "zipcode", "country");
		_validSuperAdmin=new SuperAdministrator("Bill", "Gates", "bilou@microsoft.fr", "passwordbill001", addr, Gender.MALE, 101, LocalDate.now());
		_voidSuperAdmin=new SuperAdministrator();
	}

	/**
	 * Test method for {@link gestibank.user.SuperAdministrator#SuperAdministrator(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateValidSuperAdmin() {
		final SuperAdministrator finalsuperadmin = new SuperAdministrator("Bill", "Gates", "bill@gates.com", "password000", 6654);
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
	 		final SuperAdministrator finalsuperadmin = new SuperAdministrator("", "Gates", "bill@gates.com", "pass1234", 1523);
	 		finalsuperadmin.checkData();
	 		fail("Object with empty values should not be created");
	 	} catch (CheckException e) {
	     	assertEquals("Invalid user first name", e.getMessage());
	     }
	     try {
	     	final SuperAdministrator finalsuperadmin = new SuperAdministrator("Bill", "", "bill@gates.com", "pass1234", 1523);
	     	finalsuperadmin.checkData();
	         fail("Object with empty values should not be created");
	     } catch (CheckException e) {
	     	assertEquals("Invalid user last name", e.getMessage());
	     }

	     // Creates objects with null values
	     try {
	     	final SuperAdministrator finalsuperadmin = new SuperAdministrator(null, "Gates", "bill@gates.com", "pass1234", 1523);
	     	finalsuperadmin.checkData();
	         fail("Object with null values should not be created");
	     } catch (CheckException e) {
	     	assertEquals("Invalid user first name", e.getMessage());
	     }
	     try {
	     	final SuperAdministrator finalsuperadmin = new SuperAdministrator("Bill", null, "bill@gates.com", "pass1234", 1523);
	     	finalsuperadmin.checkData();
	         fail("Object with null values should not be created");
	     } catch (CheckException e) {
	     	assertEquals("Invalid user last name", e.getMessage());
	     }
	     
	     try {
	     	final SuperAdministrator finalsuperadmin = new SuperAdministrator("Bill", "Gates", null, "pass1234", 1523);
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

	
	public void testAllSettersWithDefaultConstructor() {
		_voidSuperAdmin.setFirstname("Bill2");
		_voidSuperAdmin.setLastname("Gates2");
		_voidSuperAdmin.setAddress(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"));
		_voidSuperAdmin.setMail("anotherMail");
		_voidSuperAdmin.setGender(Gender.FEMALE);
		_voidSuperAdmin.setStaffNumber(326556);
		assertEquals("Bill2", _voidSuperAdmin.getFirstname());
		assertEquals("Gates2", _voidSuperAdmin.getLastname());
		assertEquals(new Address("2bis", "street12", "street22", "city2", "zipcode2", "country2"), _voidSuperAdmin.getAddress());
		assertEquals("anotherMail", _voidSuperAdmin.getMail());
		assertEquals(Gender.FEMALE, _voidSuperAdmin.getGender());
		assertEquals(326556, _voidSuperAdmin.getStaffNumber());
	}
	
	@Test
	public void superAdminIsSerializable() {
	    final byte[] serializedValidSuperAdmin = SerializationUtils.serialize(_validSuperAdmin);
	    final SuperAdministrator deserializedValidSuperAdmin = (SuperAdministrator) SerializationUtils.deserialize(serializedValidSuperAdmin);
	    assertEquals(_validSuperAdmin, deserializedValidSuperAdmin);
	}
	
	
	

}
