package fr.gestibank.entity.user;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import fr.gestibank.entity.exception.CheckException;
import fr.gestibank.entity.society.Gender;


@Entity
public class PendingSubscribe implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2754459759946458555L;
	
	@Id @GeneratedValue @Column(name="id")
	Long _id;
	@Column(name="firstname")
	String _firstname;
	@Column(name="lastname")
	String _lastname;
	@Column(name="mail")
	String _mail;
	@Column(name="gender")
	Gender _gender;
	@Column(name="date")
	LocalDate _date;

	public PendingSubscribe(String firstname, String lastname, String mail, Gender gender) {
		super();
		_firstname = firstname;
		_lastname = lastname;
		_mail = mail;
		_gender = gender;
	}

	public PendingSubscribe() {
		super();
	}

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

	public Gender getGender() {
		return _gender;
	}

	public void setGender(Gender gender) {
		_gender = gender;
	}

	public LocalDate getDate() {
		return _date;
	}

	public void setDate(LocalDate date) {
		_date = date;
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
            throw new CheckException("Invalid pending subcribe first name");
        if (_lastname == null || "".equals(_lastname))
            throw new CheckException("Invalid pending subcribe last name");
       if (_mail == null || "".equals(_mail) )
            throw new CheckException("Invalid pending subcribe mail");
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

}