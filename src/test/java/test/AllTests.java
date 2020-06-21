package test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This class launches all the tests of the application
 */
public final class AllTests extends TestCase {

    public AllTests() {
        super();
    }

    public AllTests(final String s) {
        super(s);
    }

    //==================================
    //=            Test suite          =
    //==================================
    public static TestSuite suite() {

        final TestSuite suite = new TestSuite();

        // Domain
        suite.addTest(CustomerTest.suite());
        suite.addTest(UserTest.suite());
        suite.addTest(ManagerTest.suite());
        suite.addTest(SuperAdministratorTest.suite());
        suite.addTest(UserTest.suite());
        suite.addTest(PendingSubscribeTest.suite());
        suite.addTest(AddressTest.suite());
        suite.addTest(CurrentAccountTest.suite());

        return suite;
    }

    public static void main(final String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}