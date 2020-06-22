package fr.gestibank.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Request implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2413972612816001625L;
	
	@Id @GeneratedValue @Column(name="id")	
	Long _id;
	@Column(length=255, name="message")
	String _message;
	@Column(length=30, name="type")
	String _type;
	
	@ManyToOne
	@JoinColumn(name="fk_customer_id")
	private Customer _customer;
	@ManyToOne
	@JoinColumn(name="fk_manager_id")
	private Manager _manager;
	
	
	public Long getId() {
		return _id;
	}
	public void setId(Long id) {
		_id = id;
	}
	public String getMessage() {
		return _message;
	}
	public void setMessage(String message) {
		_message = message;
	}
	public String getType() {
		return _type;
	}
	public void setType(String type) {
		_type = type;
	}

	public Customer getCustomer() {
		return _customer;
	}
	public void setCustomer(Customer customer) {
		_customer = customer;
	}
	public Manager getManager() {
		return _manager;
	}
	public void setManager(Manager manager) {
		_manager = manager;
	}
	
	// Constructeur sans paramètre
	public Request() {
		super();
	}
	
	/**
	 * 
	 * @param message
	 * @param type
	 * @param customer
	 * @param manager
	 */
	public Request(String message, String type, Customer customer, Manager manager) {
		super();
		_message = message;
		_type = type;
		_customer = customer;
		_manager = manager;
	}
	
	@Override
	public String toString() {
		return "Request [_id=" + _id + ", _message=" + _message + ", _type=" + _type + "]";
	}	
}
