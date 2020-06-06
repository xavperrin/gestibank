package gestibank.account;

public class Debit extends Transaction {

	public Debit(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getWithdraw() {
		// TODO Auto-generated method stub
		return super.getAmount();
	}

	@Override
	public double getDeposit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Debit "+super.toString();
	}

}
