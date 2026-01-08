package orGalProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OutputManagment {

	public static void printNamesWithCounter(BuyerManagment b) {

		int maxNameLength = b.getLongestKey();
		Set<Map.Entry<String, Integer>> entryset = b.getMap().entrySet();
		for (Map.Entry<String, Integer> entry : entryset) {
			String name = entry.getKey();
			int count = entry.getValue();
			int dotsCount = maxNameLength - name.length() + 10;
			String dots = ".".repeat(dotsCount);
			System.out.println(name + dots + count);

		}

	}

	public static void printArrayListBackwords(ListIteratorAdapter<String> iterator) {
		while (iterator.myHasPrevious()) {
			System.out.println(iterator.myPrevious());
		}

	}

	public static void printArrayList(Iterator<String> iterator) {
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
	
	
	public static void printMyArrayList(MyArrayList<?> lst) {
		
		Iterator<?> it = lst.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
	

	public static void printSpesificNameCount(BuyerManagment b) {
		if (b.getCountBuyers() == 0)
			System.out.println("There are no buyers\n");
		else {
			System.out.println("Please enter a name:\n");
			String name = InputManagment.getBuyerName(b);

			int nameCounter = b.checkNameCounter(name);
			if (nameCounter == -1)
				System.out.println("No such name in the Original array\n");
			else
				System.out.printf("The number of times %s appears in the original array is %d.\n", name, nameCounter);
		}
	}

	public static void printDoubleNames(ListIteratorAdapter<String> it) {
		if (it == null)
			System.out.println("There are no buyers\n");
		else
			printArrayListBackwords(it);
	}

	public static void printTreeSet(Set<Buyer> s) {
		Iterator<Buyer> iterator = s.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next().getUserName().toUpperCase());
	}

	public static void displaySellersProductByCategory(SellerManagment s) {
		Category category = InputManagment.getValidCategoryFromUser();
		StringBuilder stringBuilder = new StringBuilder();
		Product[] pr = null;
		Seller[] sellers = s.getSellers(false);
		for (int index = 0; index < sellers.length; index++) {
			pr = sellers[index].getAllProducts();
			for (int index1 = 0; index1 < pr.length; index1++) {
				if (pr[index1].getCategory().equals(category)) {
					stringBuilder.append(pr[index1].toString());
					stringBuilder.append("\n");
				}

			}
			if (!stringBuilder.isEmpty()) {
				System.out.println(sellers[index].getUserName());
				System.out.println(stringBuilder);

			}
			stringBuilder.setLength(0);

		}

	}

	public static void displaySellers(SellerManagment s) {
		Seller[] sellersToDisplay = s.getSellers(true);
		if (sellersToDisplay.length != 0) {
			System.out.println("The sellers in the market are:");
			for (Seller seller : sellersToDisplay) {
				System.out.println(seller.toString());
				if (seller.getAllProducts().length != 0) {
					System.out.println("The products are:");
					System.out.println(buildProductArray(seller.getAllProducts()));
					System.out.println();
				} else {
					System.out.println("There are no products");
				}

			}
		}

		else {

			System.out.println("There are no sellers in the market");
		}

	}

	public static void displayBuyers(BuyerManagment b) {
		Buyer[] buyersToDisplay = b.getBuyers();
		if (buyersToDisplay.length != 0) {
			System.out.println("The buyers in the market are:\n");
			for (Buyer buyer : buyersToDisplay) {
				System.out.println(buyer.toString());
				System.out.println("The current cart is: ");
				Cart currentCart = buyer.getCurrentCart();
				if (currentCart.getAllProducts().length == 0) {
					System.out.println("No products in current cart\n");
				} else {
					System.out.println("balance: " + buyer.getBalance());
					System.out.println("The items in cart is: ");
					System.out.println(buildProductArray(currentCart.getAllProducts()));

				}
				System.out.println();
				System.out.println("The orders history is:\n");
				Cart[] history = buyer.getAllCarts();
				if (history.length == 0) {
					System.out.println("No prior orders\n");
				} else {
					for (Cart cart : history) {
						System.out.println(cart.toString());
						System.out.println(buildProductArray(cart.getAllProducts()));
						System.out.println();
					}
				}
				System.out.println();
			}
		} else {
			System.out.println("There are no buyers in the market");
		}
	}

	public static void displaySellersNames(SellerManagment s) {
		Seller[] sellersToDisplay = s.getSellers(false);
		if (sellersToDisplay.length == 0) {
			System.out.println("there are no sellers in the system");
		} else {
			System.out.println("The sellers are: \n");
			for (Seller seller : sellersToDisplay) {
				System.out.println(seller.getUserName());
			}

			System.out.println();

		}
	}

	public static void displayBuyersNames(BuyerManagment b) {
		Buyer[] buyersToDisplay = b.getBuyers();
		if (buyersToDisplay.length == 0) {
			System.out.println("There are no buyers in the system");
		} else {
			System.out.println("The buyers are:\n");
			for (Buyer buyer : buyersToDisplay) {
				System.out.println(buyer.getUserName());
			}

			System.out.println();

		}

	}

	public static StringBuilder buildProductArray(Product[] pr) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < pr.length; i++) {
			stringBuilder.append(pr[i].toString());
			stringBuilder.append("\n");
		}
		return stringBuilder;
	}

	public static boolean displaySellerProducts(SellerManagment s, int index) {
		System.out.println("the products you can choose from are:");
		Product[] productsToDisplay = s.getSellerProducts(index);
		if (productsToDisplay.length != 0) {
			for (Product pr : productsToDisplay) {
				System.out.println(pr.toString());
			}
		} else {
			System.out.println("there are no products\n");
			return false;
		}
		return true;
	}

	public static void printNamesCount(BuyerManagment b) {
		Map<String, Integer> map = b.getMap();
		if (!(map == null))
			printNamesWithCounter(b);
		else
			System.out.println("There are no buyers\n");
	}

	public static void printSortedSet(BuyerManagment b) {
		Set<Buyer> treeSet = b.sortArrayByName();
		if (treeSet == null)
			System.out.println("There are no buyers\n");
		else
			printTreeSet(treeSet);
	}
}
