import java.util.Scanner;

public class TableOfPowersApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Squares and Cubes table");
		Scanner sc = new Scanner(System.in);
		String choice = "y";

		// Prompt User Input
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter an integer: ");
			int x = sc.nextInt();

			// display header rows
			System.out.println("Number\tSquared\tCubed");
			System.out.println("=====\t=======\t=====");
			for (int i = 1; i <= x; i++) {
				// Business Logic
				int square = i * i;
				int cube = i * i * i;

				// Display Results
				System.out.println(+i + "\t" + square + "\t" + cube);
			}
			System.out.println("Continue? (y/n)");
			System.out.println();
			choice=sc.next();
		}
		
		// Bye
		System.out.println("Goodbye!");

	}

}
