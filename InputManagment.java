package orGalProject;

import java.util.Scanner;

public class InputManagment {
	private static Scanner scanner = new Scanner(System.in);

	public static String getUsername() {
		while (true) {
			System.out.println("Please enter a username:\n");
			String name = scanner.nextLine();
			try {
				ValidiationManagment.checkString(name);
				return name;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());

			}
		}
	}

	public static String getProductname() {

		System.out.println("Please enter product name:\n");
		String name = scanner.nextLine();
		return name;

	}

	public static int getInt() {
		return Integer.parseInt(scanner.nextLine());
	}

	public static String getPassword() {
		while (true) {
			System.out.println("Please enter password:\n");
			String pass = scanner.nextLine();

			try {
				ValidiationManagment.checkString(pass);
				return pass;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	public static Address getAddress() {
		while (true) {
			System.out.println("please enter your address: ");
			System.out.println("please enter state: ");
			String country = scanner.nextLine();
			System.out.println("please enter city: ");
			String city = scanner.nextLine();
			System.out.println("please enter street: ");
			String street = scanner.nextLine();
			System.out.println("please enter building number: ");
			String buildingNum = scanner.nextLine();
			try {
				Address ad = AddressFactory.createAddress(street, buildingNum, city, country);
				return ad;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());

			}

		}

	}

	public static Category getValidCategoryFromUser() {
		boolean valid = false;
		Category category = null;

		while (!valid) {
			System.out.println("Please enter category\n");
			for (Category c : Category.values()) {
				System.out.println("\t" + c);
			}
			try {
				category = Category.valueOf(scanner.nextLine().toUpperCase());
				valid = true;
			} catch (IllegalArgumentException e) {
				System.out.println("invalid category, please try again");

			}
		}
		return category;
	}

	public static String getSellerName(SellerManagment s) {
		if (s.getSellers(false).length != 0) {
			System.out.println("Please choose the seller\n");
			OutputManagment.displaySellersNames(s);
			String sellerNameToAddProduct = scanner.nextLine();
			return sellerNameToAddProduct;

		} else {
			System.out.println(" no sellers in the market\n");
			return null;
		}

	}

	public static String getBuyerName(BuyerManagment b) {
		if (b.getBuyers().length != 0) {
			System.out.println("Please choose the buyer\n");
			OutputManagment.displayBuyersNames(b);
			String buyerNameToAddProduct = scanner.nextLine();
			return buyerNameToAddProduct;
		} else {
			System.out.println(" no buyers in the market\n");
			return null;
		}

	}

	public static Product getProduct() {
		boolean valid = false;
		String productName = null;
		while (valid == false) {
			try {
				System.out.println("please enter product name:\n");
				productName = scanner.nextLine();
				ValidiationManagment.checkString(productName);
				valid = true;
			} catch (IllegalArgumentException e) {
				System.out.println("name cant be null\n");
				productName = scanner.nextLine();
			}
		}
		System.out.println("please enter product price");
		double price = gatValidStringTODoubleInput(scanner, scanner.nextLine());
		System.out.println("Please enter product category");
		System.out.println("categories:");
		Category category = getValidCategoryFromUser();
		String choice;
		System.out.println("Would you like special packaging?");
		choice = scanner.nextLine();

		while (!choice.equals("n") && !choice.equals("y")) {
			System.out.println("what?????????? or y or n ");
			choice = scanner.nextLine();
		}
		if (choice.equals("n")) {
			Product pr = ProductFatory.createProduct(ProductType.REGULAR, productName, price, category);
			return pr;
		} else {
			Product pr = ProductFatory.createProduct(ProductType.SPECIAL, productName, price, category);
			return pr;

		}

	}

	private static double gatValidStringTODoubleInput(Scanner scanner, String str) {
		boolean valid = false;
		double input = 0;
		String newStr = str;
		while (!valid) {
			// System.out.println("Please enter again");

			try {
				// input = scanner.nextLine();
				input = Double.valueOf(newStr);
				valid = true;

			} catch (IllegalArgumentException e) {
				System.out.println("input needs to in integers, please try again");
				newStr = scanner.nextLine();

			}

		}
		return input;

	}

	public static String getYesOrNo() {
		System.out.println("y/n\n");
		String pay = scanner.nextLine();
		while (!pay.equals("n") && !pay.equals("y")) {
			System.out.println("or y or n\n ");
			pay = scanner.nextLine();
		}
		return pay;
	}
}
