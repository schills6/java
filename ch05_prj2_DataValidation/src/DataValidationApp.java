import java.util.Scanner;

public class DataValidationApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Area and Perimeter Calculator");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		String choice = "y";

		// Prompt User Input
		while (choice.equalsIgnoreCase("y")) {

			// Business Logic

			// Display Results

			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			getChoiceString();

		}
		// Goodbye
		System.out.println();
		System.out.println("Goodbye!");
		sc.close();
	}

	public static double getDoubleWithinRange(Scanner sc, String prompt, double min, double max) {

	}

	public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {

	}

	public static void getChoiceString(Scanner sc, String choice) {
		if (choice.equalsIgnoreCase("n")) {
			break;
		} else if (choice.equalsIgnoreCase("y")) {
			continue;
		} else if (choice = null) {
			System.out.println("Error! This entry is required. Try again.");
		} else {
			System.out.println("Error! Entry must be 'y' or 'n'. Try again.");
		}
	}
}
