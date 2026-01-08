package orGalProject;

public class ProductSpecialPackage extends Product {
	private boolean specialPackge;

	public ProductSpecialPackage(String itemName, double price, Category category) {
		super(itemName, price, category);
		this.specialPackge = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString() + ", special package: " + specialPackge;
	}

}
