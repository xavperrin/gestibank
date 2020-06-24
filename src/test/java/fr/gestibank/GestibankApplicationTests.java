package fr.gestibank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.Instant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.gestibank.entity.account.CurrentAccount;
import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.user.Customer;
import fr.gestibank.entity.user.Manager;
import fr.gestibank.entity.user.SuperAdministrator;
import fr.gestibank.entity.user.User;
import fr.gestibank.repository.UserRepository;
import fr.gestibank.repository.AddressRepository;
import fr.gestibank.repository.CurrentAccountRepository;
import fr.gestibank.repository.CustomerRepository;
import fr.gestibank.repository.ManagerRepository;
import fr.gestibank.repository.SuperAdministratorRepository;

@SpringBootTest
class GestibankApplicationTests {

	@Autowired
	private UserRepository userDao;
	@Autowired
	private AddressRepository addrDao;
	@Autowired
	private CustomerRepository customerDao;
	
	@Autowired
	private CurrentAccountRepository currentaccountDao;
	
	@Autowired
	private ManagerRepository managerDao;
	@Autowired
	private SuperAdministratorRepository superadminDao;
	
	
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
		
		getFromDb.setMail(getFromDb.getMail()+Instant.now().toEpochMilli());
		User updatedUser =userDao.save(getFromDb);
		assertNotEquals(savedUserInDb, updatedUser);
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
	
	

	@Test
	public void testSaveManager() {
		Manager manager=getManager();
		Address addr=getAddress();
		manager.setAddress(addr);
	    Address savedAddressInDb=addrDao.save(addr);
	   Manager savedManagerInDb =managerDao.save(manager);
	    Address getAddressFromDb = addrDao.findById(savedAddressInDb.getId()).get();
		Manager getManagerFromDb = managerDao.findById(savedManagerInDb.getId()).get();
		assertEquals(getAddressFromDb, savedAddressInDb);
		assertEquals(getManagerFromDb, savedManagerInDb);
	}
	
	
	@Test
	public void testSaveSuperAdministrator() {
		SuperAdministrator superadmin=getSuperAdministrator();
		Address addr=getAddress();
		superadmin.setAddress(addr);
	    Address savedAddressInDb=addrDao.save(addr);
	    SuperAdministrator savedAdminInDb =superadminDao.save(superadmin);
	    Address getAddressFromDb = addrDao.findById(savedAddressInDb.getId()).get();
	    SuperAdministrator getSuperFromDb = superadminDao.findById(savedAdminInDb.getId()).get();
		assertEquals(getAddressFromDb, savedAddressInDb);
		assertEquals(getSuperFromDb, savedAdminInDb);
	}
	
	
	@Test
	public void testSaveAccounts() {
		Customer customer=getCustomer();
		Address addr=getAddress();
		customer.setAddress(addr);
	    Address savedAddressInDb=addrDao.save(addr);
	   Customer savedCustomerInDb =customerDao.save(customer);
	    Address getAddressFromDb = addrDao.findById(savedAddressInDb.getId()).get();
		Customer getCustomerFromDb = customerDao.findById(savedCustomerInDb.getId()).get();
		assertEquals(getAddressFromDb, savedAddressInDb);
		assertEquals(getCustomerFromDb, savedCustomerInDb);
		
		CurrentAccount currentaccount=getCurrentAccount();
		currentaccount.setCustomer(getCustomerFromDb);
		currentaccount.setBalance(1000.00);
		
		
		
		
		CurrentAccount savedcurrentAccountfromDB=currentaccountDao.save(currentaccount);
		CurrentAccount currentAccountgetFromDb = currentaccountDao.findById(savedcurrentAccountfromDB.getId()).get();
		
		
		assertEquals(savedcurrentAccountfromDB, currentAccountgetFromDb);
		
		
	}
	
	/*
	 * 
	 * Private methods for tests
	 * 
	 * 
	 */
	
	private CurrentAccount getCurrentAccount() {
		CurrentAccount ca=new CurrentAccount();
		ca.setIBAN(getIBAN());
		return ca;
		
	}

	private String getIBAN() {
		return new String("NL67ABNA"+Math.floor(100000 + Math.random() * 900000));
	}

	private SuperAdministrator getSuperAdministrator() {
		SuperAdministrator _super=new SuperAdministrator();
		_super.setFirstname("Admin");
		Long timestamp=Instant.now().toEpochMilli();
		_super.setLastname("Johnson"+timestamp);
		_super.setMail("customer.johnson+"+timestamp+"@gmail.com");
		_super.setGender(Gender.FEMALE);
		_super.setPassword("superwoman123");
		return _super;
	}

	private Manager getManager() {
		// TODO Auto-generated method stub
		Long timestamp=Instant.now().toEpochMilli();
		return new Manager("Manager"+timestamp, " Tykal", " m.anager"+timestamp+"@microsoft.fr", "passwordond", new Address("3ter", "street1", "street2", "city", "zipcode", "country"),Gender.MALE, 1523, "06 77 66 43 52");
	}

	/**
	 *  
	 * @return Customer
	 */
	private Customer getCustomer() {
		Long timestamp=Instant.now().toEpochMilli();
		Customer _customer= new Customer();
		_customer.setFirstname("Customer");
		_customer.setLastname("Johnson"+timestamp);
		_customer.setMail("customer.johnson+"+timestamp+"@gmail.com");
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
		Long timestamp=Instant.now().toEpochMilli();
		User _user= new User();
		_user.setFirstname("User"+timestamp);
		_user.setLastname("Johnson");
		_user.setMail("user.johnson"+timestamp+"@gmail.com");
		_user.setGender(Gender.FEMALE);
		_user.setPassword("superwoman123");
		return _user;
	}

	
	
	

}
