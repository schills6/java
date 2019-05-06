package ui;

import util.Console;

public class CalculatorPhase2App {

	public static void main(String[] args) {
		System.out.println("Welcome to the Calculator App Phase 2!\n");
		String choice = "";
		choice = Console.getChoiceString(
				"Select your operation: addition (a), subtraction (s), multiplication (m), or division (d) ", "a", "s",
				"m", "d");
		while (!choice.equalsIgnoreCase("x")) {
			int firstNum = Console.getInt("\nEnter an integer: ");
			int secondNum = Console.getInt("Enter another integer: ");
			String result = doMath(choice, firstNum, secondNum);
			System.out.println(result);
			choice = Console.getChoiceString(
					"\nSelect your operation: addition (a), subtraction (s), multiplication (m), division (d), or exit(x) ",
					"a", "s", "m", "d", "x");
		}
		System.out.println("Goodbye!");
	}

	public static String doMath(String choice, int firstNum, int secondNum) {
		String result = "";
		if (choice.equalsIgnoreCase("a")) {
			result = firstNum + " + " + secondNum + " = " + (firstNum + secondNum);
		} else if (choice.equalsIgnoreCase("s")) {
			result = firstNum + " - " + secondNum + " = " + (firstNum - secondNum);
		} else if (choice.equalsIgnoreCase("m")) {
			result = firstNum + " * " + secondNum + " = " + (firstNum * secondNum);
		} else if (choice.equalsIgnoreCase("d")) {
			result = firstNum + " / " + secondNum + " = " + (firstNum / secondNum) + " remainder = "
					+ (firstNum % secondNum);
			;
		}
		return result;

	}
}