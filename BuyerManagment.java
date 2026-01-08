package orGalProject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class BuyerManagment extends ExceptionUtil {

	private Buyer[] buyers;
	private Map<String, Integer> buyersMap;
	private ArrayList<String> twiceNameArr;
	private MyArrayList<String> myArrayList;
	private MyArrayList.Memento<String> m;
	private int countBuyers;

	public BuyerManagment() {
		this.buyers = new Buyer[2];
		this.buyersMap = new LinkedHashMap<>();
		this.countBuyers = 0;
		this.twiceNameArr = new ArrayList<>();
	}

	// SellerManagment sellerManagment = new SellerManagment();

	private Buyer[] doubleBuyersArraySize() {
		// TODO Auto-generated method stub
		Buyer[] newArray = new Buyer[this.countBuyers * 2];
		for (int i = 0; i < this.countBuyers; i++) {
			newArray[i] = this.buyers[i];
		}

		return newArray;
	}

	public Buyer getValidBuyerToAdd() {
		boolean again = true;
		String name = InputManagment.getUsername();
		Buyer buyer = (Buyer) PersonFactory.createPerson(PersonType.BUYER, name);
		while (again) {

			if (!addBuyer(buyer, true)) {
				System.out.println("This user name already exist in system");
				name = InputManagment.getUsername();
				buyer.setUserName(name);

			} else {
				again = false;
			}
		}
		String password = InputManagment.getPassword();
		buyer.setPassword(password);
		Address ad = InputManagment.getAddress();
		buyer.setAddress(ad);
		return buyer;
	}

	public boolean addBuyer(Buyer buyer, boolean includeDuplicates) {
		// TODO Auto-generated method stub
		if (this.countBuyers == this.buyers.length) {
			this.buyers = doubleBuyersArraySize();
		}
		if (!includeDuplicates) {
			for (int i = 0; i < this.countBuyers; i++) {
				if (buyer.getUserName().equals(this.buyers[i].getUserName())) {
					return false;
				}
			}
		}

		this.buyers[countBuyers] = buyer;
		addNameToMap(buyer.userName);
		countBuyers++;

		return true;
	}
	
	
	public MyArrayList<String> getMyArray()
	{
		return myArrayList;
	}

	public boolean addProductToBuyer(SellerManagment s, String productToAdd, int sellerIndex, int buyerIndex) {
		// TODO Auto-generated method stub
		Seller[] sellers = s.getSellers(false);
		OutputManagment.displaySellers(s);
		Optional<Product> pr = sellers[sellerIndex].getProductByName(productToAdd);
		if (pr.isPresent()) {
			buyers[buyerIndex].setProductToCart(pr.get());
			System.out.println("product added to buyers cart");
			return true;

		} else {
			System.out.println("product not found,try again");
			return false;
		}

	}

	public void payment(int buyerIndex) {
		// TODO Auto-generated method stub
		buyers[buyerIndex].getCurrentCart().setCartPrice(buyers[buyerIndex].getBalance());
		buyers[buyerIndex].setBalance(0);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String formatedDate = dtf.format(LocalDateTime.now());
		buyers[buyerIndex].getCurrentCart().setDate(formatedDate);
		buyers[buyerIndex].addCart();

	}

	public void handlePayment() {
		String buyerNameToAddProduct = InputManagment.getBuyerName(this);
		if (buyerNameToAddProduct == null)
			return;
		int indexBuyer = isExistBuyerIndex(buyerNameToAddProduct);
		if (!handleEmptyCart(buyers[indexBuyer].getBalance())) {
			System.out.println("cart balance is 0.00");
		} else {
			System.out.println("The balance is : " + buyers[indexBuyer].getBalance() + " would you like to pay? y/n");
			String pay = InputManagment.getYesOrNo();
			if (pay.equals("y")) {
				payment(indexBuyer);
				System.out.println("cart paid successfuly!");
			}
		}
	}

	public Buyer[] getBuyers() {
		// TODO Auto-generated method stub

		Buyer[] copyOfBuyers = new Buyer[countBuyers];
		for (int index = 0; index < countBuyers; index++) {
			copyOfBuyers[index] = buyers[index];
		}
		return copyOfBuyers;

	}

	public int isExistBuyers(String userName) {

		for (int i = 0; i < this.countBuyers; i++) {
			if (userName.equals(this.buyers[i].getUserName())) {
				return i;
			}
		}

		return -1;

	}

	public int getCountBuyers() {
		return countBuyers;
	}

	public int isExistBuyerIndex(String buyerNameToAddProduct) {
		int indexBuyer = isExistBuyers(buyerNameToAddProduct);
		while (indexBuyer == -1) {
			System.out.println("Buyer not found, please try again");
			buyerNameToAddProduct = InputManagment.getBuyerName(this);
			indexBuyer = isExistBuyers(buyerNameToAddProduct);
		}
		return indexBuyer;
	}

	public boolean handleEmptyCart(Double balance) {
		try {
			emptyCart(balance);
			return true;

		} catch (EmptyCartException e) {
			return false;
		}
	}

	public Buyer getBuyerByIndex(int index) {
		// TODO Auto-generated method stub
		return buyers[index];
	}

	public boolean copyOrder(Buyer buyer, int choice) {
		// TODO Auto-generated method stub
		buyer.getCurrentCart().setFirst(null);
		Cart carts[] = buyer.getAllCarts();
		Product pr[] = carts[choice - 1].getAllProducts();
		for (Product p : pr) {
			buyer.setProductToCart(p);
		}
		return true;
	}

////////////////////////////////////////////////////////////////////////////////////////////

	public void addNameToMap(String name) {

		String key = name.toLowerCase();
		if (this.buyersMap.get(key) == null) {
			this.buyersMap.put(key, 1);
		} else {
			int value = this.buyersMap.get(key).intValue();
			value++;
			this.buyersMap.put(key, value);

		}

	}

	public Map<String, Integer> getMap() {

		if (this.countBuyers == 0)
			return null;
		return this.buyersMap;
	}

	public int checkNameCounter(String name) {

		if (this.buyersMap == null)
			return -1;
		String lowerCaseName = name.toLowerCase();
		if (!this.buyersMap.containsKey(lowerCaseName)) {
			return -1;
		} else {
			int value = this.buyersMap.get(name).intValue();
			return value;

		}

	}

	public void addDoubleName() {
		MyButton button = new MyButton();
		button.attach(new Action1());
		button.attach(new Action2());

		if (this.countBuyers == 0) {
			System.out.println("there are no buyers\n");
			return;
		}

//		ArrayList<String> twiceNameArr = new ArrayList<>();
		ListIterator<String> iterator = twiceNameArr.listIterator();
		ListIteratorAdapter<String> adapter = new ListIteratorAdapter<String>(iterator);
		Set<Map.Entry<String, Integer>> entryset = this.buyersMap.entrySet();
		for (Map.Entry<String, Integer> entry : entryset) {
			adapter.myAdd(entry.getKey());
			adapter.myAdd(entry.getKey());
		}
		OutputManagment.printDoubleNames(adapter);
		System.out.println(
				"Do you want to see the output of my self-implemented iterators (Y/y or any other key to skip)\n");
		String print = InputManagment.getYesOrNo();
		if (print.equalsIgnoreCase("y")) {
			myArrayList = new MyArrayList<>(twiceNameArr, button);
			Iterator<String> it = myArrayList.iterator();
			System.out.println("\nprint array with our iterator\n");
			OutputManagment.printArrayList(it);
			ListIterator<String> listItertor = myArrayList.listIterator();
			System.out.println("\nprint array with our list iterator\n");
			OutputManagment.printArrayList(listItertor);
			System.out.println("\nprint array with our list iterator backwords\n");
			OutputManagment.printDoubleNames(adapter);
			
			System.out.println("\n\ncurrent state of our array list is :\n ");
			OutputManagment.printMyArrayList(myArrayList);

		}

	}
	
	
	
	
	
	public void saveState()
	{
      m = myArrayList.createMemento();
     
     
	}
	
	public boolean restoreState()
	{
		if(m==null)
		{
			System.out.println("nothing saved to restore\n");
			return false;
		}
		else
		{
			myArrayList.setMemento(m);
			return true;
		}
		
	}
	
	
	

	public int getLongestKey() {
		String longestKey = "";
		for (String key : this.buyersMap.keySet()) {
			if (key.length() > longestKey.length()) {
				longestKey = key;
			}
		}
		return longestKey.length();
	}

	public Set<Buyer> sortArrayByName() {
		if (this.countBuyers == 0)
			return null;
		Set<Buyer> buyerTreeSet = new TreeSet<>((b1, b2) -> {
			String name1 = b1.getUserName();
			String name2 = b2.getUserName();
			int x = name1.compareToIgnoreCase(name2);
			if (x == 0) {
				return x;
			}
			return (name1.length() > name2.length()) ? 1 : -1;

		});
		for (int i = 0; i < this.countBuyers; i++) {
			buyerTreeSet.add(this.buyers[i]);
		}

		return buyerTreeSet;

	}

	public void createNewCartFromHistory() {
		// TODO Auto-generated method stub
		String buyerNameToAddProduct = InputManagment.getBuyerName(this);
		if (buyerNameToAddProduct == null)
			return;
		int indexBuyer = isExistBuyerIndex(buyerNameToAddProduct);
		Buyer buyer = getBuyerByIndex(indexBuyer);
		if (buyer.getCurrentCart().getProductCount() != 0) {
			System.out.println("your cart is not empty, would you like to replace products? y/n");
			String proceed = InputManagment.getYesOrNo();

			if (proceed.equals("y")) {
				chooseCartToReplace(buyer);
			}
		} else {
			chooseCartToReplace(buyer);
		}
	}

	private void chooseCartToReplace(Buyer buyer) {
		System.out.println("please choose the order you would like to copy:\n");
		Cart[] history = buyer.getAllCarts();
		if (history.length == 0) {
			System.out.println("No prior orders\n");
		} else {
			for (int index = 0; index < history.length; index++) {
				System.out.println("order " + (index + 1));
				System.out.println(history[index].toString());
				System.out.println(OutputManagment.buildProductArray(history[index].getAllProducts()));
				System.out.println();
			}
			boolean valid = false;
			int choice;
			while (!valid) {
				try {
					choice = InputManagment.getInt();
					if (choice > 0 && choice <= history.length) {
						valid = true;
						copyOrder(buyer, choice);
					}
				} catch (IllegalArgumentException e) {
					System.out.println("invalid choice please try again");
					// choice=scanner.nextLine();

				}

			}
		}
	}

	public void generateBuyers() {
		addBuyer((Buyer) PersonFactory.createPerson(PersonType.BUYER, "tami"), true);
		addBuyer((Buyer) PersonFactory.createPerson(PersonType.BUYER, "Gal"), true);
		addBuyer((Buyer) PersonFactory.createPerson(PersonType.BUYER, "GAL"), true);
		addBuyer((Buyer) PersonFactory.createPerson(PersonType.BUYER, "Shemesh"), true);
		addBuyer((Buyer) PersonFactory.createPerson(PersonType.BUYER, "T"), true);
		addBuyer((Buyer) PersonFactory.createPerson(PersonType.BUYER, "tami"), true);
		addBuyer((Buyer) PersonFactory.createPerson(PersonType.BUYER, "Ronit"), true);
		System.out.println("Buyers added to Array\n");

	}
	

}