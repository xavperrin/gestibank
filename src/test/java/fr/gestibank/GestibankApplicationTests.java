package fr.gestibank;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.user.Customer;
import fr.gestibank.entity.user.User;
import fr.gestibank.repository.UserRepository;
import fr.gestibank.repository.AddressRepository;
import fr.gestibank.repository.CustomerRepository;

@SpringBootTest
class GestibankApplicationTests {

	@Autowired
	private UserRepository userDao;
	@Autowired
	private AddressRepository addrDao;
	@Autowired
	private CustomerRepository customerDao;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testSaveUser() {
		User user=getUser();
		Address addr=getAddress();
		user.setAddress(addr);
	    Address savedAddressInDb=addrDao.save(addr);
	    User savedUserInDb =userDao.save(user);
	    Address getAddressFromDb = addrDao.findById(savedAddressInDb.getId()).get();
		User getFromDb = userDao.findById(savedUserInDb.getId()).get();
		assertEquals(getAddressFromDb, savedAddressInDb);
		assertEquals(getFromDb, savedUserInDb);
	}
	
	
	
	@Test
	public void testSaveUserWithoutAddress() {
		User user=getUser();
		
		
	    User savedUserInDb =userDao.save(user);
	    User getFromDb = userDao.findById(savedUserInDb.getId()).get();
		
		assertEquals(getFromDb, savedUserInDb);
	}
	
	
	@Test
	public void testSaveCustomer() {
		Customer customer=getCustomer();
		Address addr=getAddress();
		customer.setAddress(addr);
	    Address savedAddressInDb=addrDao.save(addr);
	   Customer savedCustomerInDb =customerDao.save(customer);
	    Address getAddressFromDb = addrDao.findById(savedAddressInDb.getId()).get();
		Customer getCustomerFromDb = customerDao.findById(savedCustomerInDb.getId()).get();
		assertEquals(getAddressFromDb, savedAddressInDb);
		assertEquals(getCustomerFromDb, savedCustomerInDb);
	}

	
	/*
	 * 
	 * Private methods for tests
	 * 
	 * 
	 */
	
	/**
	 *  
	 * @return Customer
	 */
	private Customer getCustomer() {
		Customer _customer= new Customer();
		_customer.setFirstname("Katherine");
		_customer.setLastname("Johnson");
		_customer.setMail("katherine.johnson@gmail.com");
		_customer.setGender(Gender.FEMALE);
		_customer.setPassword("superwoman123");
		
		
		return _customer;
	}

	private Address getAddress() {
		Address _address =new Address();
		_address.setStreetNumber("27");
		_address.setStreet1("Straße");
		_address.setStreet2("Zi. Nummer 123");
		_address.setCity("Wien");
		_address.setZipcode("21109");
		_address.setCountry("Austria");
		return _address;
	}

	private User getUser() {
		User _user= new User();
		_user.setFirstname("Katherine");
		_user.setLastname("Johnson");
		_user.setMail("katherine.johnson@gmail.com");
		_user.setGender(Gender.FEMALE);
		_user.setPassword("superwoman123");
		return _user;
	}
	
	
	
	private User getUserWithAddress() {
		User _user= new User();
		_user.setFirstname("Katherine");
		_user.setLastname("Johnson");
		_user.setMail("katherine.johnson@gmail.com");
		_user.setGender(Gender.FEMALE);
		_user.setPassword("superwoman123");
		_user.setAddress(new Address("72", "Sömmeringstr.", "Straße 27", "Elchingen", "89270", "Germany"));
		return _user;
	}
	
	
	
	
	
	

}
