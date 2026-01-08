package orGalProject;

import java.util.Scanner;

public class SellerManagment {
	private Seller[] sellers;
	private int countSellers;

	public SellerManagment() {
		this.sellers = new Seller[2];
		this.countSellers = 0;
	}

	private Seller[] doubleSellersArraySize() {
		// TODO Auto-generated method stub
		Seller[] newArray = new Seller[this.countSellers * 2];
		for (int i = 0; i < this.countSellers; i++) {
			newArray[i] = this.sellers[i];
		}

		return newArray;

	}

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

	public Seller getValidSellerToAdd() {
		boolean again = true;
		String name = InputManagment.getUsername();
		Seller seller = (Seller) PersonFactory.createPerson(PersonType.SELLER, name);
		while (again) {
			if (!addSeller(seller)) {
				System.out.println("This user name already exist in system\n");
				name = InputManagment.getUsername();
				seller.setUserName(name);
			} else
				again = false;

		}
		String password = InputManagment.getPassword();
		seller.setPassword(password);
		return seller;
	}

	public void addProductToSeller(Product pr, int index) {
		// TODO Auto-generated method stub
		sellers[index].setProduct(pr);

	}

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

	public Product[] getSellerProducts(int index) {
		// TODO Auto-generated method stub
		return sellers[index].getAllProducts();

	}

	public int isExistSellerIndex(String name) {
		String sellerNameToChooseFrom = name;
		// check input
		int indexSeller = isExistSellers(sellerNameToChooseFrom);
		while (indexSeller == -1) {
			System.out.println("Seller not found, please try again");
			sellerNameToChooseFrom = InputManagment.getSellerName(this);
			indexSeller = isExistSellers(sellerNameToChooseFrom);
		}
		return indexSeller;
	}

}