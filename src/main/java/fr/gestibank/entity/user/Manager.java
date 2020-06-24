package fr.gestibank.entity.user;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;




@Entity
@PrimaryKeyJoinColumn(name="fk_user_id")
public class Manager extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4533222629834744029L;

				  
	@Column(name ="staff_number")
	private int _staffNumber;
	@Column(name ="begin_date")
	private LocalDate  _beginDate;
	@Column(name ="end_date")
	private LocalDate  _endDate;
	@Column(length=20, name ="phone_number")
	private String _phoneNumber;
	
	/** "mappedBy" signifie que cette association est déjà décrite dans l'autre classe, on spécifie que c'est sur l'attribut "_manager".
	 * "FetchType.LAZY" : on spécifie à Hibernate que lorsqu'il charge un "Manager", il ne chargera pas l'attribut "_pendingSubscribes". Hibernate ne chargera "_pendingSubscribes" que "à la demande" => il faut utiliser la méthode getPendingSubscribes()
	 *  Note : "By default no operations are cascaded."
	 */
	@OneToMany(mappedBy="_manager", fetch=FetchType.LAZY)
	@Column(name="list_pending_subscribes")
	private Collection<PendingSubscribe> _pendingSubscribes;
	@OneToMany(mappedBy="_manager", fetch=FetchType.LAZY)
	@Column(name="list_customers")
	private Collection<Customer> _customers;
	@OneToMany(mappedBy="_manager", fetch=FetchType.LAZY)
	@Column(name="list_requests")
	private Collection<Request> _requests;
	
	
					  
			 
  

							 
		   
  
 
	/**
	 * @return the staffnumber
	 */
	public int getStaffnumber() {
		return _staffNumber;
	}

	/**
	 * @param staffnumber the staffnumber to set
	 */
	public void setStaffnumber(int staffnumber) {
		_staffNumber = staffnumber;
	}

	
	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return _phoneNumber;
	}

	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		_phoneNumber = phonenumber;
	}
	
	
	/**
	 * @return the beginDate
	 */
	public LocalDate getBeginDate() {
		return _beginDate;
	}

	/**
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(LocalDate beginDate) {
		_beginDate = beginDate;
	}
	
	
	/**
	 * @return the endDate
	 */
	public LocalDate getEndDate() {
		return _endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDate endDate) {
		_endDate = endDate;
	}
	
	public Collection<PendingSubscribe> getPendingSubscribes() {
		return _pendingSubscribes;
	}

	public void setPendingSubscribes(Collection<PendingSubscribe> pendingSubscribes) {
		_pendingSubscribes = pendingSubscribes;
	}

	public Collection<Customer> getCustomers() {
		return _customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		_customers = customers;
	}

	public Collection<Request> getRequests() {
		return _requests;
	}

	public void setRequests(Collection<Request> requests) {
		_requests = requests;
	}

	public Manager() {
		super();
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param address
	 * @param gender
	 */
	public Manager(String firstname, String lastname, String mail, String password, Address address, Gender gender) {
		super(firstname, lastname, mail, password, address, gender);
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param address
	 * @param gender
	 * @param staffNumber
	 * @param phoneNumber
	 */
	public Manager(String firstname, String lastname, String mail, String password, Address address, Gender gender,
			int staffNumber, String phoneNumber) {
		super(firstname, lastname, mail, password, address, gender);
		_staffNumber = staffNumber;
		_phoneNumber = phoneNumber;
	}

	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param address
	 * @param gender
	 * @param staffNumber
	 * @param beginDate
	 * @param phoneNumber
	 */
	public Manager(String firstname, String lastname, String mail, String password, Address address, Gender gender,
			int staffNumber, LocalDate beginDate, String phoneNumber) {
		super(firstname, lastname, mail, password, address, gender);
		_staffNumber = staffNumber;
		_beginDate = beginDate;
		_phoneNumber = phoneNumber;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(_beginDate, _endDate, _phoneNumber, _staffNumber);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Manager)) {
			return false;
		}
		Manager other = (Manager) obj;
		return Objects.equals(_beginDate, other._beginDate) && Objects.equals(_endDate, other._endDate)
				&& Objects.equals(_phoneNumber, other._phoneNumber) && _staffNumber == other._staffNumber;
	}

	
	


	

}
