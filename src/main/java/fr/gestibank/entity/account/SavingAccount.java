package fr.gestibank.entity.account;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="_id")
public class SavingAccount extends DepositAccount {

	public SavingAccount(String iBAN, double starter) {
		super(iBAN, starter);
		setOverdraftFacility(0);
	}
}
