import java.util.Scanner;

public class CommonDivisorCalculatorApp {

	public static void main(String[] args) {

		// Welcome
		System.out.println("Greatest Common Divisor Finder");
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		System.out.println();

		// Prompt User Input
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter first number: ");
			int x = sc.nextInt();
			System.out.print("Enter second number: ");
			int y = sc.nextInt();

			// Business Logic
			while (x != 0) {
				while (y >= x) {
					y -= x;
				}
				int origX = x;
				int origY = y;
				x = origY;
				y = origX;
			}
			// Display Results

			System.out.println("Greatest common divisor: " + y);
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
