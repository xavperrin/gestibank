package fr.gestibank.entity.user;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;



@Entity
@PrimaryKeyJoinColumn(name="_id")
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
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param staffNumber
	 */
	public SuperAdministrator(String firstname, String lastname,  String mail, String password, int staffNumber) {
		super(firstname, lastname, mail, password);
		this.setStaffNumber(staffNumber);
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
	public SuperAdministrator(String firstname, String lastname,  String mail, String password, Address address, Gender gender, int staffNumber, LocalDate beginDate) {
		super(firstname, lastname, mail, password, address, gender);
		this.setStaffNumber(staffNumber);
		this.setBeginDate(beginDate);
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
