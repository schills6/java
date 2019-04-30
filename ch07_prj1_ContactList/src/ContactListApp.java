
public class ContactListApp {

	public static void main(String[] args) {
//Welcome
		System.out.println("Welcome to the Contact List application");
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
//Prompt for User Input
			System.out.println();
			String firstNameStr = Console.getString("Enter first name: ");
			String lastNameStr = Console.getString("Enter last name: ");
			String emailStr = Console.getString("Enter email: ");
			String phoneStr = Console.getString("Enter phone: ");
			Contact c = new Contact(firstNameStr, lastNameStr, emailStr, phoneStr);
			System.out.println();

//Business Logic

//Display Results
			System.out.println(c.displayContact());
			choice = Console.getString("Continue? (y/n): ");
		}
		System.out.println();
		System.out.println("Goodbye");
	}
}