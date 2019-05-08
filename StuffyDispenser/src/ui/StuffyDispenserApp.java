package ui;

import java.util.List;

import business.Stuffy;
import db.DAO;
import db.StuffyDB;
import util.Console;
import util.StringUtils;

public class StuffyDispenserApp {

	private static DAO<Stuffy> stuffyDAO = new StuffyDB();

	public static void main(String[] args) {
		System.out.println("Welcome to the Stuffy Dispenser App!");

		displayMenu();
		String action = "";
		while (!action.equalsIgnoreCase("exit")) {
			action = Console.getRequiredString("\nEnter a command:   ");

			if (action.equalsIgnoreCase("list")) {
				displayAllStuffies();
			} else if (action.equalsIgnoreCase("add")) {
				addStuffy();
			} else if (action.equalsIgnoreCase("del")) {
				deleteStuffy();
			} else if (action.equalsIgnoreCase("help")) {
				displayMenu();
			} else {
				System.out.println("Invalid command.");
			}
		}
		System.out.println("Bye");
	}

	public static void displayMenu() {
		System.out.println("\nCOMMAND MENU");
		System.out.println("========================");
		System.out.println("list  -List all stuffies");
		System.out.println("add   -Add a stuffy");
		System.out.println("del   -Delete a stuffy");
		System.out.println("help  -Show this menu");
		System.out.println("exit  -Exit the app");
	}

	private static void displayAllStuffies() {
		System.out.println("\nSTUFFY LIST");
		System.out.println("==================================================");
		List<Stuffy> stuffies = stuffyDAO.getAll();
		StringBuilder sb = new StringBuilder();
		for (Stuffy s : stuffies) {
			sb.append(StringUtils.padWithSpaces(Integer.toString(s.getId()), 4));
			sb.append(StringUtils.padWithSpaces(s.getType(), 12));
			sb.append(StringUtils.padWithSpaces(s.getColor(), 12));
			sb.append(StringUtils.padWithSpaces(s.getSize(), 12));
			sb.append(s.getLimbs());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void addStuffy() {
		String type = Console.getRequiredString("Enter type: ");
		String color = Console.getRequiredString("Enter color: ");
		String size = Console.getRequiredString("Enter size: ");
		int limbs = Console.getInt("Enter limbs: ");

		Stuffy s = new Stuffy(type, color, size, limbs);
		if (stuffyDAO.add(s)) {
			System.out.println("\nStuffy " + "succesfully added.");
		} else {
			System.out.println("Error adding stuffy.");
		}
	}

	private static void deleteStuffy() {
		System.out.println("!!! Delete Stuffy !!!");
		int id = Console.getInt("Enter stuffy ID to delete: ");
		Stuffy s = stuffyDAO.get(id);
		if (s == null) {
			System.out.println("Invalid ID.");
		} else {
			if (stuffyDAO.delete(s)) {
				System.out.println("Delete success");
			} else {
				System.out.println("Error deleting stuffy.");
			}
		}
	}
}
