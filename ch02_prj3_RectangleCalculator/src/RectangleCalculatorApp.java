
import java.util.Scanner;
public class RectangleCalculatorApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Rectangle Calculator App!");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
		// Prompt for user input
		System.out.print("Enter length: ");
		double length = sc.nextDouble();
		System.out.println();
		System.out.print("Enter width: ");
		double width = sc.nextDouble();
		System.out.println();
		// Business logic
		double area = width * length;
		double perimeter = 2 * width + 2 * length;
				
		// Display results
		System.out.println("Area is "+area);
		System.out.println();
		System.out.println("Perimeter is "+perimeter);
		System.out.println();
		System.out.println("Continue? (y/n) ");
		choice = sc.next();
		}
		// Bye
		sc.close();
		System.out.println("See ya!");
}

}
