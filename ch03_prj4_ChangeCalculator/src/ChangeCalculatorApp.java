

import java.util.Scanner;

public class ChangeCalculatorApp {

	public static void main(String[] args) {
		// Welcome
		System.out.print("Welcome to the Change Calculator");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// Prompt User Input
			System.out.println();
			System.out.print("Enter number of cents (0-99): ");
			int cents = sc.nextInt();
			System.out.println();

			// Business Logic
			int quarters = cents / 25;
			int remainder1 = cents % 25;
			int dimes = remainder1 / 10;
			int remainder2 = remainder1 % 10;
			int nickels = remainder2 / 5;
			int remainder3 = remainder2 % 5;
			int pennies = remainder3;

			// Display Results
			System.out.println("Quarters: " + quarters);
			System.out.println("Dimes: " + dimes);
			System.out.println("Nickels: " + nickels);
			System.out.println("Pennies: " + pennies);

			System.out.println();
			System.out.print("Continue? (y/n):");
			choice = sc.next();
			System.out.println();

		}
		// Goodbye
		System.out.println();
		System.out.println("Goodbye.");
		System.out.println();
		sc.close();
	}
}
