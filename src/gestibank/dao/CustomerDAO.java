package gestibank.dao;

import gestibank.exception.CheckException;
import gestibank.exception.DataAccessException;
import gestibank.exception.DuplicateKeyException;
import gestibank.exception.ObjectNotFoundException;
import gestibank.user.Customer;

public class CustomerDAO extends DataAccessObject {
	
	
	private static final String HASHTABLE_FILE_NAME = "persistentCustomer.ser";
	
	
	 public CustomerDAO() throws DataAccessException {
		super(HASHTABLE_FILE_NAME);
	}

	 
	 /**
	     * This method gets a Customer object from the HashMap.
	     *
	     * @param id Customer identifier to be found in the hastable
	     * @return Customer the customer object with all its attributs set
	     * @throws CheckException          is thrown if invalid data is found
	     * @throws ObjectNotFoundException is thrown if the customer id not found in the hastable
	     */

	public Customer find(String id) throws ObjectNotFoundException, CheckException {
		
		// Checks data integrity
        checkId(id);
        return (Customer) super.select(id);
	}

	/**
     * This method inserts a Customer object into the HashMap and serializes the Hastable on disk.
     *
     * @param customer Customer Object to be inserted into the hastable
     * @throws CheckException          is thrown if invalid data is found
     * @throws DuplicateKeyException is thrown when an identical object is already in the hastable
     */
    public void insert(final Customer customer) throws DuplicateKeyException, CheckException {
        // Checks data integrity
        customer.checkData();
        // Puts the object into the hastable
        super.insert(customer, customer.getId());
    }
    
    /**
     * This method updates a Customer object of the HashMap and serializes the Hastable on disk.
     *
     * @param customer Customer to be updated from the hastable
     * @throws ObjectNotFoundException     is thrown if the customer id not found in the hastable
     * @throws DuplicateKeyException is thrown when an identical object is already in the hastable
     * @throws CheckException is thrown if the customer has invalid data 
     */
    public void update(final Customer customer) throws ObjectNotFoundException, DuplicateKeyException, CheckException {
    	String id = customer.getId();
    	checkId(id);
    	customer.checkData();
    	remove(id);
        insert(customer);
    }

    /**
     * This method deletes a Customer object from the HashMap and serializes the Hastable on disk.
     *
     * @param id Customer identifier to be deleted from the hastable
     * @throws ObjectNotFoundException is thrown if there's a persistent problem
     */
    public void remove(final String id) throws ObjectNotFoundException {
        super.remove(id);
    }

}
