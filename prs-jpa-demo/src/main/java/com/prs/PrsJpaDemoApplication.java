package com.prs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.business.Product;
import com.prs.business.PurchaseRequest;
import com.prs.business.PurchaseRequestLineItem;
import com.prs.business.User;
import com.prs.business.Vendor;
import com.prs.db.ProductDB;
import com.prs.db.PurchaseRequestDB;
import com.prs.db.PurchaseRequestLineItemDB;
import com.prs.db.UserDB;
import com.prs.db.VendorDB;
import com.prs.util.Console;
import com.prs.util.StringUtils;

@SpringBootApplication
public class PrsJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemoApplication.class, args);
		System.out.println("Hello");
		displayMenu();
		String menuChoice = Console.getRequiredString("\nEnter a command: ");
		while (!menuChoice.equalsIgnoreCase("exit")) {
			switch (menuChoice) {
				case "ulist":
					displayAllUsers();
					break;
				case "uadd":
					addUser();
					break;
				case "udel":
					deleteUser();
					break;
				case "vlist":
					displayAllVendors();
					break;
				case "vadd":
					addVendor();
					break;
				case "vdel":
					deleteVendor();
					break;
				case "plist":
					displayAllProducts();
					break;
				case "prlist":
					displayAllPurchaseRequests();
					break;
				case "lilist":
					displayAllPurchaseRequestLineItems();
					break;
			}
			displayMenu();
			menuChoice = Console.getRequiredString("\nEnter a command: ");
		}

		System.out.println("\nBye");
	}

	public static void displayMenu() {
		System.out.println("\n COMMAND MENU");
		System.out.println("========================");
		System.out.println("ulist  -Display all users");
		System.out.println("uadd   -Add a user");
		System.out.println("udel   -Delete a user");
		System.out.println("vlist  -Display all vendors");
		System.out.println("vadd   -Add a vendor");
		System.out.println("vdel   -Delete a vendor");
		System.out.println("plist   -Display all products");
		System.out.println("prlist  -Display all purchase requests");
		System.out.println("lilist   -Display all line items");
		System.out.println("help  -Show this menu");
		System.out.println("exit  -Exit the app");
	}

	private static void displayAllUsers() {
		System.out.println("\nUSER LIST");
		System.out.println(
				"==========================================================================================================================");
		List<User> users = UserDB.getAll();
		StringBuilder sb = new StringBuilder();
		for (User u : users) {
			sb.append(StringUtils.padWithSpaces(Integer.toString(u.getId()), 4));
			sb.append(StringUtils.padWithSpaces(u.getUserName(), 15));
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

	private static void displayAllVendors() {
		System.out.println("\nVENDOR LIST");
		System.out.println(
				"==========================================================================================================================");
		List<Vendor> vendors = VendorDB.getAll();
		StringBuilder sb = new StringBuilder();
		for (Vendor v : vendors) {
			sb.append(StringUtils.padWithSpaces(Integer.toString(v.getId()), 4));
			sb.append(StringUtils.padWithSpaces(v.getCode(), 15));
			sb.append(StringUtils.padWithSpaces(v.getName(), 20));
			sb.append(StringUtils.padWithSpaces(v.getAddress(), 20));
			sb.append(StringUtils.padWithSpaces(v.getCity(), 15));
			sb.append(StringUtils.padWithSpaces(v.getState(), 5));
			sb.append(StringUtils.padWithSpaces(v.getZip(), 35));
			sb.append(StringUtils.padWithSpaces(v.getPhoneNumber(), 35));
			sb.append(StringUtils.padWithSpaces(Boolean.toString(v.isPreApproved()), 7));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void displayAllProducts() {
		System.out.println("\nPRODUCT LIST");
		System.out.println(
				"==========================================================================================================================");
		List<Product> products = ProductDB.getAll();
		for (Product p : products) {
			System.out.println(p);
		}
	}

	private static void displayAllPurchaseRequests() {
		System.out.println("\nPURCHASE REQUEST LIST");
		System.out.println(
				"==========================================================================================================================");
		List<PurchaseRequest> purchaserequests = PurchaseRequestDB.getAll();
		for (PurchaseRequest pr : purchaserequests) {
			System.out.println(pr);
		}
	}

	private static void displayAllPurchaseRequestLineItems() {
		System.out.println("\nPURCHASE REQUEST LINE ITEM LIST");
		System.out.println(
				"==========================================================================================================================");
		List<PurchaseRequestLineItem> purchaserequestlineitems = PurchaseRequestLineItemDB.getAll();
		for (PurchaseRequestLineItem prli : purchaserequestlineitems) {
			System.out.println(prli);
		}
	}

	private static void addUser() {
		String username = Console.getRequiredString("Enter Username: ");
		String password = Console.getRequiredString("Enter Password: ");
		String firstName = Console.getRequiredString("Enter First Name: ");
		String lastName = Console.getRequiredString("Enter Last Name: ");
		String phoneNumber = Console.getRequiredString("Enter Phone Number: ");
		String email = Console.getRequiredString("Enter Email: ");
		boolean isReviewer;
		if (Console.getChoiceString("Is user a reviewer? (y/n) : ", "y", "n").equalsIgnoreCase("y")) {
			isReviewer = true;
		} else {
			isReviewer = false;
		}
		boolean isAdmin;
		if (Console.getChoiceString("Is user an admin? (y/n) : ", "y", "n").equalsIgnoreCase("y")) {
			isAdmin = true;
		} else {
			isAdmin = false;
		}

		User u = new User(username, password, firstName, lastName, phoneNumber, email, isReviewer, isAdmin);
		if (UserDB.add(u)) {
			System.out.println("\nUser " + "succesfully added.");
		} else {
			System.out.println("Error adding User.");
		}
	}

	private static void deleteUser() {
		System.out.println("!!! Delete User !!!");
		String email = Console.getString("Enter User email to delete: ");
		User u = UserDB.getUser(email);
		if (u == null) {
			System.out.println("Invalid ID.");
		} else {
			if (UserDB.delete(u)) {
				System.out.println("Delete success");
			} else {
				System.out.println("Error deleting user.");
			}
		}
	}

	private static void addVendor() {
		String code = Console.getRequiredString("Enter Code: ");
		String name = Console.getRequiredString("Enter Name: ");
		String address = Console.getRequiredString("Enter Street Address: ");
		String city = Console.getRequiredString("Enter City: ");
		String state = Console.getRequiredString("Enter State: ");
		String zip = Console.getRequiredString("Enter Zip: ");
		String phoneNumber = Console.getRequiredString("Enter Phone Number: ");
		String email = Console.getRequiredString("Enter email: ");
		boolean isPreApproved;
		if (Console.getChoiceString("Is vendor pre-approved? (y/n) : ", "y", "n").equalsIgnoreCase("y")) {
			isPreApproved = true;
		} else {
			isPreApproved = false;
		}

		Vendor v = new Vendor(code, name, address, city, state, zip, phoneNumber, email, isPreApproved);
		if (VendorDB.add(v)) {
			System.out.println("\nVendor " + "succesfully added.");
		} else {
			System.out.println("Error adding Vendor.");
		}
	}

	private static void deleteVendor() {
		System.out.println("!!! Delete Vendor !!!");
		String code = Console.getString("Enter Vendor code to delete: ");
		Vendor v = VendorDB.getVendor(code);
		if (v == null) {
			System.out.println("Invalid ID.");
		} else {
			if (VendorDB.delete(v)) {
				System.out.println("Delete success");
			} else {
				System.out.println("Error deleting user.");
			}
		}
	}
}
