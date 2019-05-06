package ui;

import util.Console;

public class CalculatorPhase1App {

	public static void main(String[] args) {
		System.out.println("Welcome to the Calculator App Phase 1!\n");
		String choice = "";
		choice = Console.getChoiceString(
				"Select your operation: addition (a), subtraction (s), multiplication (m), or division (d) ", "a",
				"s", "m", "d");
		while (!choice.equalsIgnoreCase("x")) {
		switch (choice) {
		case "a":
		case "A":
			int firstNum = Console.getInt("\nEnter an integer: ");
			int secondNum = Console.getInt("Enter another integer: ");
			int result = firstNum + secondNum;
			System.out.println("\n"+firstNum + " " + "+" + " " + secondNum + " " + "=" + " " + result);
			break;
		case "s":
		case "S":
			firstNum = Console.getInt("\nEnter an integer: ");
			secondNum = Console.getInt("Enter another integer: ");
			result = firstNum - secondNum;
			System.out.println("\n"+firstNum + " " + "-" + " " + secondNum + " " + "=" + " " + result);
			break;
		case "m":
		case "M":
			firstNum = Console.getInt("\nEnter an integer: ");
			secondNum = Console.getInt("Enter another integer: ");
			result = firstNum * secondNum;
			System.out.println("\n"+firstNum + " " + "*" + " " + secondNum + " " + "=" + " " + result);
			break;
		case "d":
		case "D":
			firstNum = Console.getInt("\nEnter an integer: ");
			secondNum = Console.getInt("Enter another integer: ");
			result = firstNum / secondNum;
			int remainder = firstNum % secondNum;
			System.out.println("\n"+firstNum + " " + "/" + " " + secondNum + " " + "=" + " " + result + " remainder= " + remainder);
			break;
		default:
			break;
		}

		choice = Console.getChoiceString("\nSelect your operation: addition (a), subtraction (s), multiplication (m), division (d), or exit(x) ", "a", "s", "m", "d", "x");
		}

		System.out.println("\nGoodbye!");
	}
}
