package account;

public class CheckingAccount extends Account {
//instance variables
	private double monthlyFee;

	
//constructors
	public CheckingAccount(double balance, double monthlyFee) {
		super(balance);
		this.monthlyFee = monthlyFee;
	}

//methods	
	public void subtractMonthlyFee () {
		balance -= monthlyFee;				
	}
	
	public double getMonthlyFee() {
		return monthlyFee;
	}
	
}
