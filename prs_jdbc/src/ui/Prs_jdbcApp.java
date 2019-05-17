package ui;

import java.util.List;

import business.User;
import db.DAO;
import db.UserDB;
import util.Console;
import util.StringUtils;

public class Prs_jdbcApp {

	private static DAO<User> userDAO = new UserDB();

	public static void main(String[] args) {
		System.out.println("Welcome to the PRS_JDBC App!");

		displayMenu();
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			action = Console.getRequiredString("\nEnter a command:   ");

			if (action.equalsIgnoreCase("list")) {
				displayAllUsers();
			} else if (action.equalsIgnoreCase("add")) {
				addUser();
			} else if (action.equalsIgnoreCase("del")) {
				deleteUser();
			} else if (action.equalsIgnoreCase("help")) {
				displayMenu();
			} else if (!action.equalsIgnoreCase("exit")) {
				System.out.println("Invalid command.");
			}
		}
		System.out.println("\nBye");
	}

	public static void displayMenu() {
		System.out.println("\nCOMMAND MENU");
		System.out.println("========================");
		System.out.println("list  -List all users");
		System.out.println("add   -Add a user");
		System.out.println("del   -Delete a user");
		System.out.println("help  -Show this menu");
		System.out.println("exit  -Exit the app");
	}

	private static void displayAllUsers() {
		System.out.println("\nUSER LIST");
		System.out.println("==========================================================================================================================");
		List<User> users = userDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (User u : users) {
			sb.append(StringUtils.padWithSpaces(Integer.toString(u.getId()), 4));
			sb.append(StringUtils.padWithSpaces(u.getUsername(), 15));
			sb.append(StringUtils.padWithSpaces(u.getFirstName(), 20));
			sb.append(StringUtils.padWithSpaces(u.getLastName(), 20));
			sb.append(StringUtils.padWithSpaces(u.getPhoneNumber(), 15));
			sb.append(StringUtils.padWithSpaces(u.getEmail(), 35));
			sb.append(StringUtils.padWithSpaces(Boolean.toString(u.isReviewer()), 7));
			sb.append(StringUtils.padWithSpaces(Boolean.toString(u.isAdmin()), 7));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void addUser() {
		String username = Console.getRequiredString("Enter Username: ");
		String pwd = Console.getRequiredString("Enter Password: ");
		String firstName = Console.getRequiredString("Enter First Name: ");
		String lastName = Console.getRequiredString("Enter Last Name: ");
		String phoneNumber = Console.getRequiredString("Enter Phone Number: ");
		String email = Console.getRequiredString("Enter Email: ");
		boolean isReviewer;
		if (Console.getChoiceString("Is user a reviewer? (y/n) : ", "y", "n").equalsIgnoreCase("y")) {
			isReviewer = true;
		}
		else {
			isReviewer = false;
		}
		boolean isAdmin;
		if (Console.getChoiceString("Is user an admin? (y/n) : ", "y", "n").equalsIgnoreCase("y")) {
			isAdmin = true;
		}
		else {
			isAdmin = false;
		}

		User u = new User(username, pwd, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
		if (userDAO.add(u)) {
			System.out.println("\nUser " + "succesfully added.");
		} else {
			System.out.println("Error adding User.");
		}
	}

	private static void deleteUser() {
		System.out.println("!!! Delete User !!!");
		int id = Console.getInt("Enter User ID to delete: ");
		User u = userDAO.get(id);
		if (u == null) {
			System.out.println("Invalid ID.");
		} else {
			if (userDAO.delete(u)) {
				System.out.println("Delete success");
			} else {
				System.out.println("Error deleting user.");
			}
		}
	}
}
