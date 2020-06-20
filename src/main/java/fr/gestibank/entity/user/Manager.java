package fr.gestibank.entity.user;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;




@Entity
@PrimaryKeyJoinColumn(name="_id")
public class Manager extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4533222629834744029L;
	
	@Column(name ="staffNumber")
	private int _staffNumber;
	@Column(name ="beginDate")
	private LocalDate  _beginDate;
	@Column(name ="endDate")
	private LocalDate  _endDate;
	@Column(length=20, name ="phoneNumber")
	private String _phoneNumber;
	
	

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
	
	public Manager() {
		super();
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param staffnumber
	 * @param phonenumber
	 */
	public Manager(String firstname, String lastname, String mail, String password, int staffnumber, String phonenumber) {
		super(firstname, lastname, mail, password);
		setStaffnumber(staffnumber);
		setPhonenumber(phonenumber);
	}

	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param address
	 * @param gender
	 * @param staffnumber
	 * @param begin
	 */
	public Manager(String firstname, String lastname, String mail, String password, Address address,
			Gender gender, int staffnumber, LocalDate begin) {
		super(firstname, lastname, mail, password);
		this.setStaffnumber(staffnumber);
		this.setBeginDate(begin);
		this.setAddress(address);
	}

	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param staffnumber
	 */
	public Manager(String firstname, String lastname, String mail, String password, int staffnumber) {
		super(firstname, lastname, mail, password);
		this._staffNumber=staffnumber;
		
	}


}
