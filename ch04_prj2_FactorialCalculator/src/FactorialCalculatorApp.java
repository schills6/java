import java.util.Scanner;

public class FactorialCalculatorApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Factorial Calculator");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		String choice = "y";

		// Prompt for User Input
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter an integer that's greater than 0 and less than 21: ");
			int x = sc.nextInt();
			long factorial = 1;

			// Business Logic
			for (int i = 1; i <= x; i++) {
				factorial = factorial * i;
			}
			// Display Results
			System.out.println("The factorial of " + x + " " + " is: " + factorial);
			System.out.println();

			System.out.print("Continue? (y/n) ");
			choice = sc.next();
			System.out.println();
		}
		// Goodbye
		System.out.println("Goodbye!");
		sc.close();
	}

}
