import java.util.Scanner;

public class MyConsole extends Console {

	private static Scanner sc = new Scanner(System.in);

	@Override
	public String getString(String prompt) {
		String s = "";
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
				s = sc.nextLine();
				if (!s.isEmpty()) {
					isValid = true;
				} else {
					System.out.println("Error! This entry is required. Try again.");
				}
		}
		return s;
	}

	public int oddOrEven(String prompt) {
		int i = getInt(prompt);
		int oi = i;
		oi %= 2;
		if (oi == 0) {
			System.out.println("The number " + i + " is even.");
			System.out.println();
		} else if (oi != 0) {
			System.out.println("The number " + i + " is odd.");
			System.out.println();
		}
		return i;
	}
}

