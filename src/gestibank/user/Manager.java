package gestibank.user;

import java.util.Date;

import gestibank.society.Address;
import gestibank.society.Gender;

/**
 * @author Jean-Francois
 *
 */
public class Manager extends User {
	
	private int _staffnumber; 
	private Date  _beginDate;
	private Date  _endDate;
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
	public Date getBeginDate() {
		return _beginDate;
	}

	/**
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(Date beginDate) {
		_beginDate = beginDate;
	}
	
	
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return _endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}
	
	public Manager(String id, String firstname, String lastname, String mail, String password, int staffnumber, String phonenumber) {
		super(id, firstname, lastname, mail, password);
		setStaffnumber(staffnumber);
		setPhonenumber(phonenumber);
	}

	public Manager(String id, String firstname, String lastname, String mail, String password, Address address,
			Gender gender, int staffnumber, Date begin) {
		super(id, firstname, lastname, mail, password);
		this.setStaffnumber(staffnumber);
		this.setBeginDate(begin);
		this.setAddress(address);
	}

	public Manager(String id, String firstname, String lastname, String mail, String password, int staffnumber) {
		super(id, firstname, lastname, mail, password);
		this._staffnumber=staffnumber;
		
	}





	
	


}
