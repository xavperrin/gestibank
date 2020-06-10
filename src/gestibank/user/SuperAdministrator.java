package gestibank.user;

import java.time.LocalDate;
import java.util.ArrayList;

import gestibank.society.Address;
import gestibank.society.Gender;

public class SuperAdministrator extends User {
	
	private int _staffNumber;
	private LocalDate _beginDate;
	private ArrayList<Manager> _listManagers;

	
	// Constructeur basique (listManagers non pr�cis�)
	public SuperAdministrator(String id, String firstname, String lastname,  String mail, String password, int staffNumber) {
		super(id, firstname, lastname, mail, password);
		this.setStaffNumber(staffNumber);
	}
	
	// Constructeur basique (listManagers non pr�cis�)
	public SuperAdministrator(String id, String firstname, String lastname,  String mail, String password, Address address, Gender gender, int staffNumber, LocalDate beginDate) {
		super(id, firstname, lastname, mail, password, address, gender);
		this.setStaffNumber(staffNumber);
		this.setBeginDate(beginDate);
	}
	
	// Constructeur avec listManagers
	public SuperAdministrator(String id, String firstname, String lastname,  String mail, String password, Address address, Gender gender, int staffNumber, LocalDate beginDate, ArrayList<Manager> listManagers) {
		super(id, firstname, lastname, mail, password, address, gender);
		this.setStaffNumber(staffNumber);
		this.setBeginDate(beginDate);
		this.setListManagers(listManagers);
	}

	// test

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

	public ArrayList<Manager> getListManagers() {
		return _listManagers;
	}

	public void setListManagers(ArrayList<Manager> listManagers) {
		_listManagers = listManagers;
	}

	@Override
	public String toString() {
		return "SuperAdministrator [ staffNumber = " + _staffNumber + ", beginDate = " + _beginDate + ", listManagers = "
				+ _listManagers + " ]";
	}
	
	
	
	

}
