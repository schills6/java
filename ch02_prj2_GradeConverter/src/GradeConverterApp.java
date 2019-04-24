import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Letter Grade Converter");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		int numericalGrade = 0;
		String letterGrade = " ";
		
		
		String choice = "y";
		while (!choice.equalsIgnoreCase("n")) {
		
		System.out.print("Enter numerical grade: ");
		
		numericalGrade = sc.nextInt();
		
		if (numericalGrade >= 88) {
			letterGrade = "A"	;
		} else if (numericalGrade >= 80) {
			letterGrade = "B";
		} else if (numericalGrade >= 67) {
			letterGrade = "C";
		} else if (numericalGrade >= 60) {
			letterGrade = "D";
		} else {letterGrade = "F";
		}
		
		System.out.print("Letter grade: "+letterGrade);
		System.out.println();
		System.out.println("Continue? (y/n): ");
		
		choice = sc.next();
		
	}
		sc.close();
}
}
