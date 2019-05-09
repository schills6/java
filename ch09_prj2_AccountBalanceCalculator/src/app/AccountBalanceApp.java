package app;

import presentation.Console;
import account.Account;
import account.CheckingAccount;
import account.SavingsAccount;
import java.text.NumberFormat;
import java.util.Scanner;

public class AccountBalanceApp {

	public static void main(String[] args) {
//Welcome
		System.out.println("Welcome to the Account application");
		System.out.println();
//Display Starting Balances
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		SavingsAccount sa = new SavingsAccount(1000, .01);
		CheckingAccount ca = new CheckingAccount(1000, 1.00);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Starting Balances");
		printBalances(cf, sa, ca);

//Transactions for month (include while loop)
		System.out.println("\nEnter the transactions for the month\n");
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String transType = Console.getChoiceString(sc,"Withdrawal or deposit? (w/d): ","w","d");
			String accountType = Console.getChoiceString(sc,"Checking or savings? (c/s) : ","c","s");
			double amt = Console.getDouble("Amount? ", 0, Double.POSITIVE_INFINITY);
			
			Account a;
			if (accountType.equalsIgnoreCase("c")) {
				a = ca;
			}
			else {
				a = sa;
			}
			
			if (transType.equalsIgnoreCase("w")) {
				a.withdraw(amt);
			}
			else {
				a.deposit(amt);
			}
				
			System.out.println();
			choice = Console.getChoiceString(sc,"Continue? (y/n) : ", "y","n");
			System.out.println();
		}
		

//Display Monthly Payments and Fees
		ca.subtractMonthlyFee();
		sa.applyMonthlyPayment();
		System.out.println();
		System.out.println("Monthly Payments and Fees");
		System.out.println("Checking fee:                 " + cf.format(ca.getMonthlyFee()));
		System.out.println("Savings interest payment:     " + cf.format(sa.getMonthlyInterestPayment()));
		System.out.println();
		
//Display Final Balances
		System.out.println("Final Balances");
		printBalances(cf, sa, ca);

	}

	private static void printBalances(NumberFormat cf, SavingsAccount sa, CheckingAccount ca) {
		System.out.println("Checking: " + cf.format(ca.getBalance()));
		System.out.println("Savings: " + cf.format(sa.getBalance()));
	}

}
