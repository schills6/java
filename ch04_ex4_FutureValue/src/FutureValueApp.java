import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp {

    public static void main(String[] args) {
        System.out.println("The Future Value Calculator\n");
        
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            System.out.print("Enter monthly investment:   ");
            double monthlyInvestment = sc.nextDouble();
            
            System.out.print("Enter number of years:      ");
            int years = sc.nextInt();

            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMaximumFractionDigits(1);
            System.out.print("Enter interest rate:        ");
            double interestRate = 0;
            interestRate = sc.nextDouble();
            interestRate /= 12;
            double monthlyInterestRate = interestRate;
            String interestRateString = percent.format(interestRate);
            
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            double futureValue = 0.0;
            futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
            String futureValueString = currency.format(futureValue);
          
            
            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
        System.out.println("Bye!");
    }
}