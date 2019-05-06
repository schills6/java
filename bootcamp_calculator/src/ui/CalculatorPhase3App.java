package ui;

import util.Console;
import business.Calculation;

public class CalculatorPhase3App {

	public static void main(String[] args) {
		System.out.println("Welcome to the Calculator App Phase 3!\n");
		String choice = "";
		choice = Console.getChoiceString(
				"Select your operation: addition (a), subtraction (s), multiplication (m), or division (d) ", "a", "s",
				"m", "d");
		Calculation c = new Calculation();
		while (!choice.equalsIgnoreCase("x")) {
			switch (choice) {
			case "a":
			case "A":
				int firstNum = Console.getInt("\nEnter an integer: ");
				int secondNum = Console.getInt("Enter another integer: ");
				System.out.println("\n" + firstNum + " " + "+" + " " + secondNum + " " + "=" + " "
						+ c.getSum(firstNum, secondNum));
				break;
			case "s":
			case "S":
				firstNum = Console.getInt("\nEnter an integer: ");
				secondNum = Console.getInt("Enter another integer: ");
				System.out.println("\n" + firstNum + " " + "-" + " " + secondNum + " " + "=" + " "
						+ c.getDifference(firstNum, secondNum));
				break;
			case "m":
			case "M":
				firstNum = Console.getInt("\nEnter an integer: ");
				secondNum = Console.getInt("Enter another integer: ");
				System.out.println("\n" + firstNum + " " + "*" + " " + secondNum + " " + "=" + " "
						+ c.getProduct(firstNum, secondNum));
				break;
			case "d":
			case "D":
				firstNum = Console.getInt("\nEnter an integer: ");
				secondNum = Console.getInt("Enter another integer: ");
				System.out.println("\n" + firstNum + " " + "/" + " " + secondNum + " " + "=" + " "
						+ c.getQuotient(firstNum, secondNum) + " remainder= " + c.getRemainder(firstNum, secondNum));
				break;
			default:
				break;
			}

			choice = Console.getChoiceString(
					"\nSelect your operation: addition (a), subtraction (s), multiplication (m), division (d), or exit(x) ",
					"a", "s", "m", "d", "x");
		}

		System.out.println("\nGoodbye!");
	}
}
