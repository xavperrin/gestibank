/**
 * 
 */
package test;

import java.time.LocalDate;

import fr.gestibank.entity.account.CurrentAccount;
import fr.gestibank.entity.exception.CheckException;
import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.society.MaritalStatus;
import fr.gestibank.entity.user.Customer;
import fr.gestibank.entity.user.Manager;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import nl.garvelink.iban.IBAN;
import nl.garvelink.iban.IBANFieldsCompat;

/**
 * @author Xavier Perrin
 *
 */
public class CurrentAccountTest extends TestCase {
	
	private CurrentAccount _validAccount;
	
	
	public CurrentAccountTest(final String s) {
	        super(s);
	    }
	   
	   public static TestSuite suite() {
	        return new TestSuite(CurrentAccountTest.class);
	    }
	   
	   /**
		 * @throws java.lang.Exception
		 */
		public void setUp() throws Exception {
			_validAccount= new CurrentAccount("FR9814508000402374632743K44", 200.00, new Customer("Bill", "Gates", "bill@gate.com", "password123"));
		}

	
	public void testCreateValidCurrentAccount() throws CheckException {

	     final CurrentAccount currentaccount = new CurrentAccount("FR9814508000402374632743K44", 200.00, new Customer("Bill", "Gates", "bill@gate.com", "password123"));
			assertEquals("FR9814508000402374632743K44", currentaccount.getIBAN());
			assertEquals("14508", IBANFieldsCompat.getBankIdentifier(IBAN.valueOf(currentaccount.getIBAN())));
			currentaccount.checkData();
	 }
	
	
	public void testCreateCurrentAccountWithInvalidValues() throws Exception{
	 	
	 	try {
	 		final CurrentAccount current = new CurrentAccount("", 200.00, new Customer("Bill", "Gates", "bill@gate.com", "password123"));
	 		current.checkData();
	 		fail("Object with empty values should not be created");
	 	} catch (CheckException e) {
	     	assertEquals("Current account with empty IBAN values should not be created", e.getMessage());
	     }
	 // Creates objects with null values
	     try {
	    	 final CurrentAccount current = new CurrentAccount(null, 200, new Customer("Bill", "Gates", "bill@gate.com", "password123"));
	    	 current.checkData();
	         fail("Object with empty values should not be created");
	     } catch (CheckException e) {
	     	assertEquals("Current account with null values should not be created", e.getMessage());
	     }
	     try {
		 		final CurrentAccount current = new CurrentAccount("FR9814508000402374632743K44", 200.00, null);
		 		current.checkData();
		 		fail("Object with empty values should not be created");
		 	} catch (CheckException e) {
		     	assertEquals("Current account with null customer linked should not be created", e.getMessage());
		     }
	     
	     
	     try {
		 		final CurrentAccount current = new CurrentAccount("FR9814508000402374632743K44", 200.00, new Customer());
		 		current.checkData();
		 		fail("Object with empty values should not be created");
		 	} catch (CheckException e) {
		     	assertEquals("Current account with an empty customer linked should not be created", e.getMessage());
		     }
	 }
	
	
	/**
	 * This test use each getter
	 */
	public void testAllGetters() {
		assertEquals("FR9814508000402374632743K44", _validAccount.getIBAN());
		assertEquals(200.00, _validAccount.getBalance());
		assertEquals(new Customer("Bill", "Gates", "bill@gate.com", "password123"), _validAccount.getCustomer());
		assertEquals(0.0,_validAccount.getOverdraftFacility());
	}
	
	
	/**
	 * This test use each setter
	 */
	public void testAllSetters() {
		_validAccount.setIBAN("FO5611798676287492");
		_validAccount.setBalance(89.00);
		_validAccount.setCustomer(new Customer("Ada", "Lovelace", "ada.lovelace@live.com", "password15456", new Address("890", "Vrchlického", "", "Domažlice 1", "344 01", "Czech Republic"), Gender.FEMALE, MaritalStatus.Single));
		assertEquals("FO5611798676287492", _validAccount.getIBAN());
		assertEquals(89.00, _validAccount.getBalance());
		assertEquals(new Customer("Ada", "Lovelace", "ada.lovelace@live.com", "password15456", new Address("890", "Vrchlického", "", "Domažlice 1", "344 01", "Czech Republic"), Gender.FEMALE, MaritalStatus.Single), _validAccount.getCustomer());
	}

}
