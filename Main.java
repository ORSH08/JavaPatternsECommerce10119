
package orGalProject;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		MarketManagmentFacade facade = MarketManagmentFacade.getInstance();
		MenuFacade menuFacade = new MenuFacade(facade);

		try (Scanner scanner = new Scanner(System.in)) {

			boolean keepRunning = true;

			while (keepRunning) {
				// print menu
				System.out.println(
						"\nWelcome to the market!\n-----------------------------\nSelect an action:\n-----------------------------");
				System.out.println("0 - Exit");
				System.out.println("1 - To add seller");
				System.out.println("2 - To add buyer");
				System.out.println("3 - To add product to a seller");
				System.out.println("4 - To add product to a buyer");
				System.out.println("5 - To tranfer payment for buyer's order");
				System.out.println("6 - To Display details of all buyers");
				System.out.println("7 - To Display details of all sellers");
				System.out.println("8 - To Display details of all products by category");
				System.out.println("9 - To chooce cart from buyer history to copy");
				System.out.println("55- To create objects automatically");
				System.out.println("99 - To print buyers user names");
				System.out.println("100 - To print buyers user names with counter");
				System.out.println("101 - To check the counter of a spesific name ");
				System.out.println("102 - To print double strings from Array List ");
				System.out.println("103 - To sort by String length \n-----------------------------\n");

				String choice = scanner.nextLine();

				switch (choice) {
				case "0":
					keepRunning = false;
					System.out.println("Exiting the program...");
					break;

				case "1":
					facade.addSeller();
					break;

				case "2":
					facade.addBuyer();
					break;

				case "3":
					facade.addProductToSeller();
					break;

				case "4":
					facade.addProductToBuyer();
					break;

				case "5":
					facade.payment();
					break;

				case "6":
					facade.displayBuyers();
					break;

				case "7":
					facade.displaySellers();
					break;
				case "8":
					facade.displaySellersProductByCategory();
					break;
				case "9":
					facade.createNewCartFromHistory();
					break;
				case "55":
					facade.generateBuyers();
					break;
				case "99":
				case "100":
				case "101":
				case "102":
				case "103":
					menuFacade.executeCommand(choice);
					break;
				case "104":
					facade.saveMemento();
					facade.printMyArray();
					break;
					
				case "105":
					boolean x = facade.restoreMemento();
					if(x)
						facade.printMyArray(); //only so you could see that the state has changed 
					break;
				default:
					System.out.println("Invalid selection. please try again.");
					break;

				}

			}

		}
	}
}
