import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class TipCalculatorApp {

	public static void main(String[] args) {

		// Welcome

		System.out.println("Tip Calculator");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		String choice = "y";

		// User Input

		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Cost of meal: ");
			BigDecimal meal = new BigDecimal("100.00");
			meal = sc.nextBigDecimal();
			meal = meal.setScale(2, RoundingMode.HALF_UP);

			// Biz Logic

			double tip = 0;
			for (int i = 15; i <= 25; i += 5) {
				tip += i;

				tip = (tip / 100);
				BigDecimal tipBD = new BigDecimal(tip);
				tipBD = tipBD.setScale(2, RoundingMode.HALF_UP);
				BigDecimal tipAmount = meal.multiply(tipBD);
				tipAmount = tipAmount.setScale(2, RoundingMode.HALF_UP);
				BigDecimal totalAmount = meal.add(tipAmount);
				totalAmount = totalAmount.setScale(2, RoundingMode.HALF_UP);

				NumberFormat percent = NumberFormat.getPercentInstance();
				String tipPercentString = percent.format(tipBD);
				System.out.println();
				System.out.println(tipPercentString);
				NumberFormat currency = NumberFormat.getCurrencyInstance();
				String tipAmountString = currency.format(tipAmount);
				String totalAmountString = currency.format(totalAmount);
				System.out.println("Tip amount: " + "\t" + tipAmountString);
				System.out.println("Total amount: " + "\t" + totalAmountString);
				System.out.println();
			}

			// Display

			System.out.print("Continue? (y/n) : ");
			choice = sc.next();
			System.out.println();
		}
		// Goodbye

		System.out.println("Goodbye!");
		sc.close();
	}

}
