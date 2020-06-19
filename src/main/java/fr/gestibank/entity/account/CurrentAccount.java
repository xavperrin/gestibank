package fr.gestibank.entity.account;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="_id")
public class CurrentAccount extends DepositAccount {

	public CurrentAccount(String iBAN, double starter) {
		super(iBAN, starter);
		setOverdraftFacility(0);
	}
}
