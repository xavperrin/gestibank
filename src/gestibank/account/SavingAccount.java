package gestibank.account;
public class SavingAccount extends DepositAccount {

	public SavingAccount(String iBAN, double starter) {
		super(iBAN, starter);
		setOverdraftFacility(0);
	}

}
