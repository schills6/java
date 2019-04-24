
import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
		System.out.println("Welcome to the Calculator App");
		System.out.println();
		
		sc = new Scanner(System.in);
		
		//define 2 ints
		System.out.print("Enter value for x:	");
		int x = sc.nextInt();
		System.out.println();
		System.out.print("Enter value for y:	");
		int y = sc.nextInt();
		
		
		System.out.println();
		
		// define sum, diff, product, quotient
		int sum = x + y;
		int diff = x - y;
		int product = x * y;
		int quotient = x / y;
		
		
		System.out.println("x: "+x);
		System.out.println("y: "+y);
		System.out.println();
		System.out.println("Sum of x and y: " +sum);
		System.out.println("Difference of x and y: " +diff);
		System.out.println("Product of x and y: " +product);
		System.out.println("Quotient of x and y: " +quotient);
		System.out.println();
		System.out.println("Do you want to continue? y/n");
		
		choice = sc.next ();
		System.out.println();
		}
		
		

	}

}
