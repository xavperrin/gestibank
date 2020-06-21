package fr.gestibank.entity.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CurrentAccount extends DepositAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5518770430839873116L;

	@Id @GeneratedValue @Column(name="id")
	private Long _id;
	
	public CurrentAccount(String iBAN, double starter) {
		//super(iBAN, starter);
		setOverdraftFacility(0);
	}

	public CurrentAccount() {
		super();
		// le contr vide nous permet d'appeler les méthodes afin d'instancer des nouveaux "account"
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		_id=id;
	}
	
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return _id;
	}
	
}
