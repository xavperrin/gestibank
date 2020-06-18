package fr.gestibank.entity.user;

import java.time.LocalDate;

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
	private int _staffnumber; 
	private LocalDate  _beginDate;
	private LocalDate  _endDate;
	private String _phonenumber;
	
	

	/**
	 * @return the staffnumber
	 */
	public int getStaffnumber() {
		return _staffnumber;
	}

	/**
	 * @param staffnumber the staffnumber to set
	 */
	public void setStaffnumber(int staffnumber) {
		_staffnumber = staffnumber;
	}

	
	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return _phonenumber;
	}

	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		_phonenumber = phonenumber;
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
	
	public Manager(String firstname, String lastname, String mail, String password, int staffnumber, String phonenumber) {
		super(firstname, lastname, mail, password);
		setStaffnumber(staffnumber);
		setPhonenumber(phonenumber);
	}

	public Manager(String firstname, String lastname, String mail, String password, Address address,
			Gender gender, int staffnumber, LocalDate begin) {
		super(firstname, lastname, mail, password);
		this.setStaffnumber(staffnumber);
		this.setBeginDate(begin);
		this.setAddress(address);
	}

	public Manager(String firstname, String lastname, String mail, String password, int staffnumber) {
		super(firstname, lastname, mail, password);
		this._staffnumber=staffnumber;
		
	}





	
	


}
