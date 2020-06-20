/**
 * 
 */
package test;

import org.junit.Test;
import org.springframework.util.SerializationUtils;

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

public class AddressTest extends TestCase {

	private Address _validAddress;
	private Address _voidAddress;
	
	
	   public AddressTest(final String s) {
	        super(s);
	    }
	   
	   public static TestSuite suite() {
	        return new TestSuite(AddressTest.class);
	    }


	/**
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		_validAddress = new Address("72", "Sömmeringstr.", "Straße 27", "Elchingen", "89270", "Germany");
		_voidAddress=new Address();
	}
	 //==================================
    //=            Test cases          =
    //==================================

	/**
  * This test tries to create an object with valid values.
  */
 public void testCreateValidAddress() throws CheckException {

     final Address addr = new Address("1303", "Holly Street", "street2", "HALLSVILLE", "65255", "United States");
		assertEquals("Holly Street", addr.getStreet1());
		assertEquals("HALLSVILLE", addr.getCity());
		addr.checkData();
 }
 
 
public void testCreateAddressWithInvalidValues() throws Exception{
 	
 	try {
 		final Address address = new Address("", "Mackie Street", "1st floor", "KIANGA", "2546", "Australia");
 		address.checkData();
 		fail("Object with empty values should not be created");
 	} catch (CheckException e) {
     	assertEquals("Invalid address street number", e.getMessage());
     }
     try {
     	final Address address = new Address("23", "", "1st floor", "KIANGA", "2546", "Australia");
     	address.checkData();
         fail("Object with empty values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid street name", e.getMessage());
     }

     // Creates objects with null values
     try {
    	 final Address address = new Address(null, "Mackie Street", "1st floor", "KIANGA", "2546", "Australia");
    	 address.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid address street number", e.getMessage());
     }
     try {
    	 final Address address = new Address("23", null, "1st floor", "KIANGA", "2546", "Australia");
    	 address.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid street name", e.getMessage());
     }
     
     try {
    	 final Address address = new Address("23", "Mackie Street", "1st floor", null, "2546", "Australia");
    	 address.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid city name", e.getMessage());
     }
 }

/**
 * This test use each getter
 */
public void testAllGetters() {
	assertEquals("72", _validAddress.getStreetNumber());
	assertEquals("Sömmeringstr.", _validAddress.getStreet1());
	assertEquals("Straße 27", _validAddress.getStreet2());
	assertEquals("Elchingen", _validAddress.getCity());
	assertEquals("89270", _validAddress.getZipcode());
	assertEquals("Germany", _validAddress.getCountry());
}

/**
 * This test use each setter
 */
public void testAllSetters() {
	_validAddress.setStreetNumber("27");
	_validAddress.setStreet1("Straße");
	_validAddress.setStreet2("Zi. Nummer 123");
	_validAddress.setCity("Wien");
	_validAddress.setZipcode("21109");
	_validAddress.setCountry("Austria");
	assertEquals("27", _validAddress.getStreetNumber());
	assertEquals("Straße", _validAddress.getStreet1());
	assertEquals("Zi. Nummer 123", _validAddress.getStreet2());
	assertEquals("Wien", _validAddress.getCity());
	assertEquals("21109", _validAddress.getZipcode());
	assertEquals("Austria", _validAddress.getCountry());
}


/**
 * This test use each setter
 */
public void testAllSettersWithDefaultConstructor() {
	_voidAddress.setStreetNumber("49");
	_voidAddress.setStreet1("Passauer Strasse");
	_voidAddress.setStreet2("Zi. Nummer 121");
	_voidAddress.setCity("UNTERBERG");
	_voidAddress.setZipcode("5632");
	_voidAddress.setCountry("Austria");
	assertEquals("49", _voidAddress.getStreetNumber());
	assertEquals("Passauer Strasse", _voidAddress.getStreet1());
	assertEquals("Zi. Nummer 121", _voidAddress.getStreet2());
	assertEquals("UNTERBERG", _voidAddress.getCity());
	assertEquals("5632", _voidAddress.getZipcode());
	assertEquals("Austria", _voidAddress.getCountry());
}




@Test
public void addressIsSerializable() {
    final byte[] serializedValidCustomer = SerializationUtils.serialize(_validAddress);
    final Address deserializedValidCustomer = (Address) SerializationUtils.deserialize(serializedValidCustomer);
    assertEquals(_validAddress, deserializedValidCustomer);
}


}