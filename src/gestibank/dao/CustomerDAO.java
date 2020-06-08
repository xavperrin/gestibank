package gestibank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import gestibank.exception.CheckException;
import gestibank.exception.DataAccessException;
import gestibank.exception.DuplicateKeyException;
import gestibank.exception.ObjectNotFoundException;
import gestibank.user.Customer;
import gestibank.util.uidgen.UniqueIdGenerator;

public class CustomerDAO implements DataAccessObject<Customer, String> {
	
	  // Used for logging
    private final transient String _cname = this.getClass().getName();
    private static final String sname = DataAccessObject.class.getName();
    
    // ======================================
    // =             Attributes             =
    // ======================================
    private static final String _TABLE = "T_CUSTOMER";
    private static final String _COLUMNS = "ID, FIRSTNAME, LASTNAME, SREETNUMBER, STREET1, STREET2, CITY, ZIPCODE, COUNTRY, EMAIL";
    private static final String _PARAMS = "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    // Used to get a unique id with the UniqueIdGenerator
    private static final String COUNTER_NAME = "Customer";
    
	
	 // ======================================
    // =            Static Block            =
    // ======================================
    static {
        // Loads the JDBC driver class
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            //Trace.throwing(sname, "static", e);
        }
    }
    
    
 // ======================================
    // =           Business methods         =
    // ======================================

	
	/**
     * This method inserts a Customer object into the database.
     *
     * @param customer Customer Object to be inserted into the database
     * @throws CheckException          is thrown if invalid data is found
     * @throws DuplicateKeyException is thrown when an identical object is already in the database
	 * @throws DataAccessException 
     */
	@Override
	public void create(Customer customer) throws DuplicateKeyException, CheckException, DataAccessException {
		// TODO Auto-generated method stub
		// Checks data integrity
        customer.checkData();
     // Puts the object into the database
        insert(customer, customer.getId());
	}

	/**
     * This method gets a Customer object from database.
     *
     * @param id Customer identifier to be found in database
     * @return Customer the customer object with all its attributes set
     * @throws CheckException          is thrown if invalid data is found
     * @throws ObjectNotFoundException is thrown if the customer id not found in the database
     */
	@Override
	public Customer retrieve(String id) throws CheckException {
		// TODO Auto-generated method stub
		// Checks data integrity
        checkId(id);
		
		return null;
	}
    /**
     * This method updates a Customer of the database.
     *
     * @param customer Customer to be updated from the database
     * @throws ObjectNotFoundException     is thrown if the customer id not found in the database
     * @throws DuplicateKeyException is thrown when an identical object is already in the database
     * @throws CheckException is thrown if the customer has invalid data 
     */

	@Override
	public void update(Customer t) throws ObjectNotFoundException, DuplicateKeyException {
		// TODO Auto-generated method stub
		
	}

	 /**
     * This method deletes a Customer 
     *
     * @param id Customer identifier to be deleted from the hastable
     * @throws ObjectNotFoundException is thrown if there's a persistent problem
	 * @throws CheckException 
     */
	@Override
	public void delete(String id)  throws ObjectNotFoundException, CheckException {
		// TODO Auto-generated method stub
		// Checks data integrity
        checkId(id);
		
	}
	
	

	@Override
	public void checkId(String id)  throws CheckException {
		 if (id == null || "".equals(id))
	        throw new CheckException("Invalid id");
		
	}
	
	/**
     * This method inserts an object into a HashMap and serializes the database on disk.
     *
     * @param object            Object to be inserted into the database
     * @param id                identifier of the object to be inserted
     * @throws DuplicateKeyException is thrown when an identical object is already in the database
	 * @throws DataAccessException 
     */
	
	private void insert(Customer customer, String id) throws DuplicateKeyException, DataAccessException {
		// TODO Auto-generated method stub
		Connection connection = null;
        PreparedStatement preparedstatement = null;
		
		
        try {
            // Gets a database connection
        	
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedstatement = connection.prepareStatement("INSERT INTO "+_TABLE+" ("+_COLUMNS+")"+" VALUES "+_PARAMS);

            // Sets the object Id if necessary
            if ( customer.getId() == null )
            	customer.setId("" + getUniqueId());
            preparedstatement.setString(1, customer.getId());
            preparedstatement.setString(2, customer.getFirstname());
            preparedstatement.setString(3, customer.getLastname());
            preparedstatement.setString(4, customer.getAddress().getStreetNumber());
            preparedstatement.setString(5, customer.getAddress().getStreet1());
            preparedstatement.setString(6, customer.getAddress().getStreet2());
            preparedstatement.setString(7, customer.getAddress().getCity());
            preparedstatement.setString(8, customer.getAddress().getZipcode());
            preparedstatement.setString(9, customer.getAddress().getCountry());
            preparedstatement.setString(10, customer.getMail());
            // Inserts a Row
            preparedstatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            // The data already exists in the database
        	
        	try {

        		connection.rollback();
			} catch (SQLException e2) {
				throw new DataAccessException("Problem during rollback.", e2);
			}
        	
            if (e.getErrorCode() == DATA_ALREADY_EXIST) {
                throw new DuplicateKeyException();
            } else {
                // A Severe SQL Exception is caught
                //displaySqlException(e);
                throw new DataAccessException("Cannot insert data into the database", e);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            // Close
            try {
                if (preparedstatement != null) preparedstatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                //displaySqlException("Cannot close connection", e);
                throw new DataAccessException("Cannot close the database connection", e);
            }
        }
		
		
	}

	/**
     * This method returns a unique identifer generated by the system. 
     *
     * @return a unique identifer
	 * @throws DataAccessException 
     */
    public final String getUniqueId() throws DataAccessException {
        return UniqueIdGenerator.getInstance().getUniqueId(getCounterName());
    }

	private String getCounterName() {
		// TODO Auto-generated method stub
		return COUNTER_NAME;
	}

    /**
     * This method returns a database connection.
     *
     * @return a JDBC connection to the gestibank database
     * @throws SQLException if a SQl exception if found
     */
    public static final Connection getConnection() throws SQLException {
        final Connection connection;
        connection = DriverManager.getConnection(DataAccessObject.URL_DB, DataAccessObject.USER_DB, DataAccessObject.PASSWD_DB);
        return connection;
    }

}
