package orGalProject;

public class MarketManagmentFacade {
	private static MarketManagmentFacade instance;
	private BuyerManagment buyerManagment;
	private SellerManagment sellerManagment;
	

	private MarketManagmentFacade() {
		this.buyerManagment = new BuyerManagment();
		this.sellerManagment = new SellerManagment();

	}

	public static MarketManagmentFacade getInstance() {
		if (instance == null) {
			instance = new MarketManagmentFacade();
		}
		return instance;
	}

	public void addSeller() {
		this.sellerManagment.getValidSellerToAdd();
		System.out.println(sellerManagment.getSellers(false)[0]);
		// System.out.println(seller.userName + seller.password);
	}

	public void addBuyer() {
		this.buyerManagment.getValidBuyerToAdd();
		// System.out.println(buyerManagment.getBuyers()[0]);

	}

	public void addProductToSeller() {
		String sellerNameToAddProduct = InputManagment.getSellerName(sellerManagment);
		if (sellerNameToAddProduct == null)
			return;
		int index = sellerManagment.isExistSellerIndex(sellerNameToAddProduct);
		Product pr = InputManagment.getProduct();
		sellerManagment.addProductToSeller(pr, index);
	}

	public void addProductToBuyer() {
		String buyerNameToAddProduct = InputManagment.getBuyerName(buyerManagment);
		if (buyerNameToAddProduct == null)
			return;
		int indexBuyer = buyerManagment.isExistBuyerIndex(buyerNameToAddProduct);
		String sellerNameToBuyFrom = InputManagment.getSellerName(sellerManagment);
		if (sellerNameToBuyFrom == null)
			return;
		int indexSeller = sellerManagment.isExistSellerIndex(sellerNameToBuyFrom);
		boolean isProducts = OutputManagment.displaySellerProducts(sellerManagment, indexSeller);
		if (!isProducts)
			return;
		String productToAdd = InputManagment.getProductname();
		boolean successful = buyerManagment.addProductToBuyer(sellerManagment, productToAdd, indexSeller, indexBuyer);
		// check if input in valid, if its valid it means the adding was successful
		while (successful == false) {
			productToAdd = InputManagment.getProductname();
			successful = buyerManagment.addProductToBuyer(sellerManagment, productToAdd, indexSeller, indexBuyer);
		}

	}



	public void payment() {
		buyerManagment.handlePayment();
	}

	public void displayBuyers() {
		OutputManagment.displayBuyers(buyerManagment);
	}

	public void displaySellers() {
		OutputManagment.displaySellers(sellerManagment);
	}

	public void displaySellersProductByCategory() {
		OutputManagment.displaySellersProductByCategory(sellerManagment);
	}

	public void displayBuyersNames() {
		OutputManagment.displayBuyersNames(buyerManagment);
	}

	public void printNamesCount() {
		OutputManagment.printNamesCount(buyerManagment);
	}

	public void printSpesificNameCount() {
		OutputManagment.printSpesificNameCount(buyerManagment);
	}

	public void printDoubleNames() {
		buyerManagment.addDoubleName();
	}

	public void printSortedSet() {
		OutputManagment.printSortedSet(buyerManagment);
	}

	public void createNewCartFromHistory() {
		buyerManagment.createNewCartFromHistory();
	}

	public void generateBuyers() {
		buyerManagment.generateBuyers();
	}
	
	
	public void saveMemento() {
		buyerManagment.saveState();
	}
	
	public boolean restoreMemento() {
		boolean x = buyerManagment.restoreState();
		return x;
	}
	
	
	public void printMyArray() {
		OutputManagment.printMyArrayList(buyerManagment.getMyArray());
	}
	
	

}