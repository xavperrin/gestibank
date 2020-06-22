package fr.gestibank.entity.user;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnTransformer;

import fr.gestibank.entity.AbstractEntity;
import fr.gestibank.entity.exception.CheckException;
import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends AbstractEntity<Long> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 724866210217217496L;

	@Id @GeneratedValue @Column(name="id")
	private Long _id;
	@Column(length=30, name="firstname")
	private String _firstname;
	@Column(length=30, name="lastname")
	private String _lastname;
	@Column(length=70, name="mail")

	private String _mail;
	@Column(name = "password", columnDefinition="BLOB")
	@ColumnTransformer(
			read = "cast(aes_decrypt(password, 'mysecret') as char(255))", 
			write = "aes_encrypt(?, 'mysecret')"
			)  
	private String _password;
	@ManyToOne
	@JoinColumn(name="fk_address_id")
	private Address _address;
	@Column(name="gender")
	private Gender _gender;

	public Long getId() {
		return _id;
	}
	public void setId(Long id) {
		_id = id;
	}
	public String getFirstname() {
		return _firstname;
	}
	public void setFirstname(String firstname) {
		_firstname = firstname;
	}
	public String getLastname() {
		return _lastname;
	}
	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	public String getMail() {
		return _mail;
	}
	public void setMail(String mail) {
		_mail = mail;
	}
	
	
	public String getPassword() {
		return _password;
	}
	public void setPassword(String password) {
		_password = password;
	}
	
	
	// Constructeur sans paramètre
	public User() {
		super();
	}
	
	/**
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 */
	public User(String firstname, String lastname,  String mail, String password) {
		super();
		_firstname = firstname;
		_lastname = lastname;
		_mail = mail;
		_password = password;
	}
	 

	/**
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param address
	 * @param gender
	 */
	public User(String firstname, String lastname, String mail, String password, Address address,
			Gender gender) {
		super();
		_firstname = firstname;
		_lastname = lastname;
		_mail = mail;
		_password = password;
		_address = address;
		_gender = gender;
	}
	// ======================================
    // =           check methods          =
    // ======================================
    /**
     * This method checks the integrity of the object data.
     *
     * @throws CheckException if data is invalid
     */

	public boolean checkData() throws CheckException {
		if (_firstname == null || "".equals(_firstname))
            throw new CheckException("Invalid user first name");
        if (_lastname == null || "".equals(_lastname))
            throw new CheckException("Invalid user last name");
        if (_mail == null || "".equals(_mail))
            throw new CheckException("Invalid user mail");
		return true;
	}


public boolean checkMail() {
	// regex specifying all the domain extensions
	// source at https://www.wired.com/2008/08/four-regular-expressions-to-check-email-addresses/
	// modified with https://jex.im/regulex/
	String regex = "([a-z0-9][-a-z0-9_\\+\\.]{1,20}[a-z0-9]{2,21})@([a-z0-9][-a-z0-9\\.]{0,9}[a-z0-9]\\."+
	"(arpa|root|aero|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro"+
	"|tel|travel|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|"+
	"bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cd|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|"+
	"cu|cv|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|"+
	"ge|gf|gg|gh|gi|gl|gm|gn|gp|gq|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|"+
	"io|iq|ir|is|it|je|jm|jo|jp|ke|kg|kh|ki|km|kn|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|"+
	"lv|ly|ma|mc|md|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|"+
	"ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|ru|rw|sa|"+
	"sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|st|su|sv|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn"+
	  "|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|yu|za|zm|zw)"+
	"|([0-9]{1,3}\\.{3}[0-9]{1,3}))";
	
	
	return getMail().matches(regex);
}
public Address getAddress() {
	return _address;
}
public void setAddress(Address address) {
	_address = address;
}
public Gender getGender() {
	return _gender;
}
public void setGender(Gender gender) {
	_gender = gender;
}
@Override
public int hashCode() {
	return Objects.hash(_address, _firstname, _gender, _id, _lastname, _mail, _password);
}
@Override
public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	if (!(obj instanceof User)) {
		return false;
	}
	User other = (User) obj;
	return Objects.equals(_address, other._address) && Objects.equals(_firstname, other._firstname)
			&& _gender == other._gender && Objects.equals(_lastname, other._lastname)
			&& Objects.equals(_mail, other._mail) && Objects.equals(_password, other._password);
}



}