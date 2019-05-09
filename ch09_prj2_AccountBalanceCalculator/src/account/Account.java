package account;

import interfaces.Balanceable;
import interfaces.Depositable;
import interfaces.Withdrawable;

public class Account implements Withdrawable, Depositable, Balanceable {
	
//instance variables
	protected double balance;
	
//constructors
	
	public Account(double balance) {
		super();
		this.balance = balance;
	}
	
	public Account() {
		super();
	}

	
	@Override
	public double getBalance() {
		return balance;
	}


	@Override
	public void setBalance(double amount) {
		balance = amount;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}

}
