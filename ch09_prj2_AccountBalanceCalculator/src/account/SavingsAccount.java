package account;

public class SavingsAccount extends Account {

	//instance variables	
	private double monthlyInterestRate;
	private double monthlyInterestPayment;
	
	//constructors

	public SavingsAccount(double balance, double monthlyInterestRate) {
		super(balance);
		this.monthlyInterestRate = monthlyInterestRate;
	}

	
	//methods
	
	public double getMonthlyInterestPayment() {
		return monthlyInterestPayment;
	}
	
	public void applyMonthlyPayment() {
		monthlyInterestPayment = balance * monthlyInterestRate;
		balance += monthlyInterestPayment;
	}
}
