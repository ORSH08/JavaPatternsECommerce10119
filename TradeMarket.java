package orGalProject;

import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public interface TradeMarket {
	public boolean addBuyer(Buyer buyer, boolean includeDuplicates);

	public boolean addSeller(Seller seller);

	public void addProductToSeller(Product pr, int index);

	public boolean addProductToBuyer(String productToAdd, int sellerIndex, int buyerIndex);

	public void payment(int buyerIndex);

	public Buyer[] getBuyers();

	public Seller[] getSellers(boolean sort);

	public Product[] getSellerProducts(int index);

	public int isExistSellers(String userName);

	public int isExistBuyers(String userName);

	public boolean handleEmptyCart(Double balance);

	public Buyer getBuyerByIndex(int index);

	public boolean copyOrder(Buyer buyer, int choice);

	public Map<String, Integer> getMap();

	public void addNameToMap(String name);

	public int checkNameCounter(String name);

	public ListIterator<String> addDoubleName();

	public int getLongestKey();

	public Set<Buyer> sortArrayByName();

	public int getCountBuyers();

	// public Seller[] getSellersProductByCategory(Category category);

}
