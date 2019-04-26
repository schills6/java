import java.util.Scanner;

public class DiceRollerApp {

	public static void main(String[] args) {
		// Welcome
		greetingMessage();
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		String roll = sc.next();

		// Prompt User Input, BizLogic, Display Results
		while (choice.equalsIgnoreCase("y")) {
			if (roll.equalsIgnoreCase("y")) {
				rollAndPrintResults();
			} else {
				break;
			}

			System.out.println();
			System.out.print("Roll again? (y/n) ");
			choice = sc.next();

		}
		// Bye
		System.out.println("Goodbye!");
		sc.close();
	}

	public static void rollAndPrintResults() {
		// math
		int dieOne = (int) (Math.random() * 6) + 1;
		int dieTwo = (int) (Math.random() * 6) + 1;
		int total = dieOne + dieTwo;

		// diplay results
		System.out.println();
		System.out.println("Die 1: " + dieOne);
		System.out.println("Die 2: " + dieTwo);
		System.out.println("Total: " + total);
		switch (total) {
		case 2:
			System.out.println("Snake Eyes!");
			break;
		case 12:
			System.out.println("Boxcars!");
			break;
		default:
			break;
		}

	}

	public static void greetingMessage() {
		System.out.println("Dice Roller");
		System.out.println();
		System.out.print("Roll the dice? (y/n): ");
	}
}
