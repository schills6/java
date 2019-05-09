
public class NumberCheckerApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Odd/Even Checker!");
		String choice = "y";
		MyConsole mc = new MyConsole();
		while (choice.equalsIgnoreCase("y")) {

			// Prompt for User Input
			System.out.println();
			mc.oddOrEven("Enter an integer: ");
			
			// Business Logic

			// Display Results
			choice = mc.getString("Continue? (y/n): ");
			System.out.println();
		}
		// Bye
		System.out.println("Goodbye!");
	}

}
