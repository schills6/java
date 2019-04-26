import java.text.NumberFormat;
import java.util.Scanner;

public class InvoiceApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = "y";

		while (!choice.equalsIgnoreCase("n")) {
			// get the input from the user
			System.out.print("Enter customer type (t/r/c): ");
			String customerType = sc.next();
			System.out.print("Enter subtotal:   ");
			double subtotal = sc.nextDouble();

			// get the discount percent
			double discountPercent = 0.0;

			/*
			 * switch(customerType) { case "r": case "R": if (subtotal < 100) {
			 * discountPercent = 0.0; } else if (subtotal >= 100 && subtotal < 250) {
			 * discountPercent = .1; } else if (subtotal >= 250 && subtotal < 500) {
			 * discountPercent = .25; } else if (subtotal >= 500) { discountPercent = .30; }
			 * break; case "c": case "C": discountPercent = .2; break; case "t": case "T":
			 * if (subtotal < 500) { discountPercent = .40; } else if (subtotal >= 500) {
			 * discountPercent = .50; } break; default: discountPercent = .1; break; }
			 */
			// if else (customerType)

			if (customerType.equalsIgnoreCase("r")) {
				if (subtotal < 100) {
					discountPercent = 0.0;
				} else if (subtotal >= 100 && subtotal < 250) {
					discountPercent = .1;
				} else if (subtotal >= 250 && subtotal < 500) {
					discountPercent = .25;
				} else if (subtotal >= 500) {
					discountPercent = .30;
				}
			}
			if (customerType.equalsIgnoreCase("c")) {
				discountPercent = .2;
			}

			if (customerType.equalsIgnoreCase("t")) {
				if (subtotal < 500) {
					discountPercent = .40;
				} else if (subtotal >= 500) {
					discountPercent = .50;
				} else {
					discountPercent = .1;
				}
			}

			// calculate the discount amount and round to 2 decimals
			double discountAmount = subtotal * discountPercent;
			discountAmount = Math.ceil(discountAmount * 100) / 100;

			// calculate the total
			double total = subtotal - discountAmount;

			// format and display the results
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
			System.out.println("Discount percent: " + percent.format(discountPercent) + "\n" + "Discount amount:  "
					+ currency.format(discountAmount) + "\n" + "Total:            " + currency.format(total) + "\n");

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();

		}
	}
}