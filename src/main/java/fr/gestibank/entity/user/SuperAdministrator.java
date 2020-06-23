package fr.gestibank.entity.user;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;



@Entity
@PrimaryKeyJoinColumn(name="fk_user_id")
public class SuperAdministrator extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1560638527837467307L;
	
	@Column(name ="staffNumber")
	private int _staffNumber;
	@Column(name ="beginDate")
	private LocalDate _beginDate;

	
	public SuperAdministrator() {
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
	public SuperAdministrator(String firstname, String lastname, String mail, String password, Address address,
			Gender gender) {
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
	 * @param beginDate
	 */
	public SuperAdministrator(String firstname, String lastname, String mail, String password, Address address,
			Gender gender, int staffNumber, LocalDate beginDate) {
		super(firstname, lastname, mail, password, address, gender);
		_staffNumber = staffNumber;
		_beginDate = beginDate;
	}

	public int getStaffNumber() {
		return _staffNumber;
	}

	public void setStaffNumber(int staffNumber) {
		_staffNumber = staffNumber;
	}

	public LocalDate getBeginDate() {
		return _beginDate;
	}

	public void setBeginDate(LocalDate beginDate) {
		_beginDate = beginDate;
	}

	@Override
	public String toString() {
		return "SuperAdministrator [ staffNumber = " + _staffNumber + ", beginDate = " + _beginDate;
	}
}
