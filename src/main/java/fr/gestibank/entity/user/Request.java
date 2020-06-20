package fr.gestibank.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Request implements Serializable {

	
	@Id @GeneratedValue @Column(name="id")	
	Long _id;
	@Column(length=255, name="message")
	String _message;
	@Column(length=30, name="type")
	String _type;
	
	
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
	
	// Constructeur sans paramètre
	public Request() {
		super();
	}
	
	/**
	 * 
	 * @param id
	 * @param message
	 * @param type
	 */
	public Request(Long id, String message, String type) {
		super();
		_id = id;
		_message = message;
		_type = type;
	}
	
	@Override
	public String toString() {
		return "Request [_id=" + _id + ", _message=" + _message + ", _type=" + _type + "]";
	}	
	
	
	
}
