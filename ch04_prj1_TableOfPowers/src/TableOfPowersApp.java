import java.util.Scanner;

public class TableOfPowersApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Squares and Cubes table");
		Scanner sc = new Scanner(System.in);
		String choice = "y";

		// Prompt User Input
		while (choice.equalsIgnoreCase("y")) {
			System.out.println();
			System.out.print("Enter an integer: ");
			int n = sc.nextInt();

			// Business Logic
			System.out.println();
			System.out.println("Number\tSquared\tCubed");
			System.out.println("======\t=======\t=====");
			for (int i = 1; i <= n; i++) {
				int square = i * i;
				int cube = i * i * i;

				// Display Results
				System.out.println(i + "\t" + square + "\t" + cube);
			}
			System.out.println();
			System.out.print("Continue? (y/n) ");
			choice = sc.next();
			System.out.println();
		}

		// Bye
		System.out.println();
		System.out.println("Goodbye!");
		sc.close();

	}

}
