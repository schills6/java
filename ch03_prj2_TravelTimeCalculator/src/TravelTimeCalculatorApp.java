

import java.util.Scanner;

public class TravelTimeCalculatorApp {

	//Welcome
	public static void main(String[] args) {
	System.out.println("Welcome to the Travel Time Calculator");
	System.out.println();
	
	Scanner sc = new Scanner(System.in);
	String choice = "y";
	while (choice.equalsIgnoreCase("y")) {
	
	//Prompt User Input
	System.out.print("Enter miles: ");
	double miles = sc.nextDouble();
	System.out.print("Enter miles per hour: ");
	double mph = sc.nextDouble();
	System.out.println();

	//Business Logic
	double hours = miles / mph;		
	double minutes = miles % mph;
	int hrs = (int) hours;
	int mins = (int) minutes;
			
	
	//Display results
	String message = 
		"Estimated travel time" + "\n"
	  + "---------------------" + "\n"
	  + "Hours: "          +hrs + "\n"
	  + "Minutes: "        +mins+ "\n";
	
	System.out.println(message);
	
	System.out.println("Continue? (y/n): ");
	choice = sc.next();
	

	}
	//Goodbye
	System.out.println("Goodbye.");
	sc.close();
		
}	
}
