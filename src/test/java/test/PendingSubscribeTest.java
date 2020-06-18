/**
 * 
 */
package test;

import gestibank.exception.CheckException;
import gestibank.society.Gender;
import gestibank.user.PendingSubscribe;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * @author Xavier Perrin
 *
 */

public class PendingSubscribeTest extends TestCase {
	PendingSubscribe _validPendingSubscribe;
	
	
	   public PendingSubscribeTest(final String s) {
	        super(s);
	    }
	   
	   public static TestSuite suite() {
	        return new TestSuite(PendingSubscribeTest.class);
	    }


	/**
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		
		_validPendingSubscribe=new PendingSubscribe("Ada", "Lovelace", "adalovelace@lovelace.fr", Gender.FEMALE);
	}
	 //==================================
    //=            Test cases          =
    //==================================

	/**
  * This test tries to create an object with valid values.
  */
 public void testCreatePendingSubscribe() throws CheckException {

     final PendingSubscribe pending = new PendingSubscribe("Bill", "Gates", "bill@gates.com", Gender.MALE);
		assertEquals("Bill", pending.getFirstname());
		assertEquals("Gates", pending.getLastname());
		pending.checkData();
 }
 
 
public void testCreatePendingSubscribeWithInvalidValues() throws Exception{
 	
 	try {
 		final PendingSubscribe pending = new PendingSubscribe("", "Gates", "bill@gates.com", Gender.MALE);
 		pending.checkData();
 		fail("Object with empty values should not be created");
 	} catch (CheckException e) {
     	assertEquals("Invalid pending subcribe first name", e.getMessage());
     }
     try {
     	final PendingSubscribe pending = new PendingSubscribe("Bill", "", "bill@gates.com", Gender.MALE);
         pending.checkData();
         fail("Object with empty values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid pending subcribe last name", e.getMessage());
     }

     // Creates objects with null values
     try {
     	final PendingSubscribe pending = new PendingSubscribe(null, "Gates", "bill@gates.com", Gender.MALE);
         pending.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid pending subcribe first name", e.getMessage());
     }
     try {
     	final PendingSubscribe pending = new PendingSubscribe("Ada", null, "ada@lovelace.com", Gender.FEMALE);
         pending.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid pending subcribe last name", e.getMessage());
     }
     
     try {
     	final PendingSubscribe pending = new PendingSubscribe("Ada", "Lovelace", null, Gender.FEMALE);
         pending.checkData();
         fail("Object with null values should not be created");
     } catch (CheckException e) {
     	assertEquals("Invalid pending subcribe mail", e.getMessage());
     }
 }

/**
 * This test use each getter
 */
public void testAllGetters() {
	assertEquals("Ada", _validPendingSubscribe.getFirstname());
	assertEquals("Lovelace", _validPendingSubscribe.getLastname());
	assertEquals("adalovelace@lovelace.fr", _validPendingSubscribe.getMail());
	assertEquals(Gender.FEMALE, _validPendingSubscribe.getGender());
	
}

/**
 * This test use each setter
 */
public void testAllSetters() {
	_validPendingSubscribe.setFirstname("Bill2");
	_validPendingSubscribe.setLastname("Gates2");
	_validPendingSubscribe.setMail("anotherMail");
	_validPendingSubscribe.setGender(Gender.MALE);
	assertEquals("Bill2", _validPendingSubscribe.getFirstname());
	assertEquals("Gates2", _validPendingSubscribe.getLastname());
	assertEquals("anotherMail", _validPendingSubscribe.getMail());
	assertEquals(Gender.MALE, _validPendingSubscribe.getGender());
	
}


/**
 * The following tests mail contents
 */
public void testCheckMailWithValidLength() {
	PendingSubscribe pending = _validPendingSubscribe;
    boolean b = pending.checkMail();
    assertEquals(pending.getMail() + " est une adresse de longueur valide", true, b);
}

public void testCheckMailWithTooShortLength() {
	PendingSubscribe p = _validPendingSubscribe;
    p.setMail("x@x.fr");
    boolean b = p.checkMail();
    assertEquals("x@x.fr est une adresse trop courte => Echec", false, b);
}

public void testCheckMailWithTooLongLength() {
	PendingSubscribe pending = _validPendingSubscribe;
    pending.setMail("engagelejeuquejelegagne@duel-de-mots.fr");
    boolean b = pending.checkMail();
    assertEquals(pending.getMail() + " est une adresse trop longue => Echec", false, b);
}

public void testCheckMailWithArrobas() {
	PendingSubscribe pending = _validPendingSubscribe;
    boolean b = pending.checkMail();
    assertEquals(true, b);
}

public void testCheckMailWithoutArrobas() {
	PendingSubscribe pending = _validPendingSubscribe;
    pending.setMail("nobody.nowhere");
    boolean b = pending.checkMail();
    assertEquals("Adresse sans @ => Echec", false, b);
}

public void testCheckMailsWithValidDomain() {
	PendingSubscribe pending = _validPendingSubscribe;
    boolean b = pending.checkMail();
    assertEquals("Adresse should be OK!", true, b);
    pending.setMail("anyone@cnam.fr");
    assertEquals("Adresse should be OK!", true, b);
    pending.setMail("anyone@x.ue");
    assertEquals("Adresse should be OK!", true, b);
}

public void testCheckMailsWithInvalidDomain() {
	PendingSubscribe pending = _validPendingSubscribe;
    pending.setMail("nobody@x.com");
    boolean b = pending.checkMail();
    assertFalse("Forbidden domain!", b);
    pending.setMail("nobody@x.us");
    b = pending.checkMail();
    assertFalse("Forbidden country!", b);
}



}