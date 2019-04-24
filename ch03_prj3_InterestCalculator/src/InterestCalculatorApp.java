
import java.util.Scanner;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.math.RoundingMode;

public class InterestCalculatorApp {

	public static void main(String[] args) {
	//Welcome
	System.out.println("Welcome to the Interest Calculator");
	
	Scanner sc = new Scanner(System.in);
	String choice = "y";
	while (choice.equalsIgnoreCase("y")) {
			
	//Prompt User Input
	System.out.print("Enter loan amount: ");
	String loanAmountString = sc.next();
	System.out.print("Enter interest rate: ");
	String interestRateString = sc.next();
	System.out.println();
		
		
	//Business Logic
	BigDecimal loanAmount = new BigDecimal (loanAmountString);
	BigDecimal interestRate = new BigDecimal (interestRateString);
	BigDecimal interest = interestRate.multiply(loanAmount);
	interest = interest.setScale(2,RoundingMode.HALF_UP);
	
		
	//Display Results
	NumberFormat percent = NumberFormat.getPercentInstance();
	percent.setMaximumFractionDigits(3);
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	System.out.println("Loan amount: " + currency.format(loanAmount));
	System.out.println("Interest rate: "+ percent.format(interestRate));
	System.out.println("Interest: "+ currency.format(interest));
	System.out.println();
	System.out.print("Continue? (y/n)");
	System.out.println();
	choice = sc.next();
	System.out.println();
	
	} 
	//Goodbye
	System.out.println("Goodbye");
	System.out.println();
	sc.close();
}	
}
