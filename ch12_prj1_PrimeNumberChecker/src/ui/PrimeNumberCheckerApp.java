package ui;

import java.util.ArrayList;
import java.util.List;

import business.PrimeNumbers;
import util.Console;

public class PrimeNumberCheckerApp {

	public static void main(String[] args) {
		System.out.println("Prime Number Checker");
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int numberChoice = Console.getInt("\nPlease enter an integer between 1 and 5000: ", 0, 5001);
			List<Integer> factors = new ArrayList<>();
			PrimeNumbers pn = new PrimeNumbers(factors);
			pn.checkPrimeAddFactor(numberChoice);
			choice = Console.getChoiceString("\nTry again? (y/n): ", "y", "n");
		}
		System.out.println("\nBye!");
	}
		

}
