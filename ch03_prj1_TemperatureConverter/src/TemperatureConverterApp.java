
import java.util.Scanner;

public class TemperatureConverterApp {

	public static void main(String[] args) {
	
	//Welcome
	System.out.println("Welcome to the Temperature Converter");
	System.out.println();
	String choice = "y";
	Scanner sc = new Scanner(System.in);
	double degrees = 0.0;
	
	while (choice.equalsIgnoreCase("y")) {
	//Prompt User Input 
	System.out.print("Enter degrees in Fahrenheit: ");	
	degrees = sc.nextDouble();
	
	//Business Logic
	double degreesCelsius = (degrees - 32)* 5/9;
	degreesCelsius = (double) Math.round(degreesCelsius * 100)/100;
			
	//Display Results
	System.out.print("Degrees in Celsius: "+degreesCelsius);	
	System.out.println();
	System.out.println();
	System.out.println("Continue? (y/n): ");
	choice = sc.next();
	}
	
	//Goodbye
	sc.close();
	System.out.println("Goodbye!");
	}
}
