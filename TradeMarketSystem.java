package orGalProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class TradeMarketSystem extends ExceptionUtil implements TradeMarket {
	private Buyer[] buyers;
	private Seller[] sellers;
	private Map<String, Integer> buyersMap;
	private int countBuyers;
	private int countSellers;

	public TradeMarketSystem() {
		this.buyers = new Buyer[2];
		this.sellers = new Seller[2];
		this.buyersMap = new LinkedHashMap<>();
		this.countBuyers = 0;
		this.countSellers = 0;
	}

	// @Override
	private Buyer[] doubleBuyersArraySize() {
		// TODO Auto-generated method stub
		Buyer[] newArray = new Buyer[this.countBuyers * 2];
		for (int i = 0; i < this.countBuyers; i++) {
			newArray[i] = this.buyers[i];
		}

		return newArray;
	}

	// @Override
	private Seller[] doubleSellersArraySize() {
		// TODO Auto-generated method stub
		Seller[] newArray = new Seller[this.countSellers * 2];
		for (int i = 0; i < this.countSellers; i++) {
			newArray[i] = this.sellers[i];
		}

		return newArray;

	}

	@Override
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

	@Override
	public boolean addSeller(Seller seller) {
		// TODO Auto-generated method stub
		if (this.countSellers == this.sellers.length) {
			this.sellers = doubleSellersArraySize();
		}
		for (int i = 0; i < this.countSellers; i++) {
			if (seller.getUserName().equals(this.sellers[i].getUserName())) {
				return false;
			}
		}
		this.sellers[countSellers] = seller;
		countSellers++;

		return true;
	}

	@Override
	public void addProductToSeller(Product pr, int index) {
		// TODO Auto-generated method stub
		sellers[index].setProduct(pr);

	}

	@Override
	public boolean addProductToBuyer(String productToAdd, int sellerIndex, int buyerIndex) {
		// TODO Auto-generated method stub
		Optional<Product> pr = sellers[sellerIndex].getProductByName(productToAdd);
		if (pr.isPresent()) {
			buyers[buyerIndex].setProductToCart(pr.get());
			return true;

		} else {
			return false;
		}

	}

	@Override
	public void payment(int buyerIndex) {
		// TODO Auto-generated method stub
		buyers[buyerIndex].getCurrentCart().setCartPrice(buyers[buyerIndex].getBalance());
		buyers[buyerIndex].setBalance(0);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String formatedDate = dtf.format(LocalDateTime.now());
		buyers[buyerIndex].getCurrentCart().setDate(formatedDate);
		buyers[buyerIndex].addCart();

	}

	@Override
	public Buyer[] getBuyers() {
		// TODO Auto-generated method stub

		Buyer[] copyOfBuyers = new Buyer[countBuyers];
		for (int index = 0; index < countBuyers; index++) {
			copyOfBuyers[index] = buyers[index];
		}
		return copyOfBuyers;

	}

	@Override
	public Seller[] getSellers(boolean sort) {
		// TODO Auto-generated method stub

		// bubble sort by number of items in shop
		if (sort) {
			Seller temp;
			for (int i = 0; i < this.countSellers; i++) {

				for (int j = i + 1; j < this.countSellers; j++) {

					if (this.sellers[i].getCountProducts() < this.sellers[j].getCountProducts()) {

						temp = sellers[i];
						sellers[i] = sellers[j];
						sellers[j] = temp;

					}

				}
			}
		}

		Seller[] copyOfSellers = new Seller[countSellers];
		for (int index = 0; index < countSellers; index++) {
			copyOfSellers[index] = sellers[index];
		}

		return copyOfSellers;

	}

	public int isExistSellers(String userName) {

		for (int i = 0; i < this.countSellers; i++) {
			if (userName.equals(this.sellers[i].getUserName())) {
				return i;
			}
		}
		return -1;

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

	@Override
	public Product[] getSellerProducts(int index) {
		// TODO Auto-generated method stub
		return sellers[index].getAllProducts();

	}

	public boolean handleEmptyCart(Double balance) {
		try {
			emptyCart(balance);
			return true;

		} catch (EmptyCartException e) {
			return false;
		}
	}

	@Override
	public Buyer getBuyerByIndex(int index) {
		// TODO Auto-generated method stub
		return buyers[index];
	}

	@Override
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

	public ListIterator<String> addDoubleName() {

		if (this.countBuyers == 0)
			return null;
		ArrayList<String> twiceNameArr = new ArrayList<>();
		ListIterator<String> iterator = twiceNameArr.listIterator();
		Set<Map.Entry<String, Integer>> entryset = this.buyersMap.entrySet();
		for (Map.Entry<String, Integer> entry : entryset) {
			iterator.add(entry.getKey());
			iterator.add(entry.getKey());
		}

		return iterator;

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

}
