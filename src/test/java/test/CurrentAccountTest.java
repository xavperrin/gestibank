/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Xavier Perrin
 *
 */
public class CurrentAccountTest extends TestCase {
	
	
	   public CurrentAccountTest(final String s) {
	        super(s);
	    }
	   
	   public static TestSuite suite() {
	        return new TestSuite(AddressTest.class);
	    }

	@Test
	public void test() {
		fail("Not yet implemented");
		
		
	}

}
