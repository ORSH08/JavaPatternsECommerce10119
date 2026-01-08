package orGalProject;

public class ProductFatory {

	public static Product createProduct(ProductType type, String itemName, double price, Category category) {
		if (type == ProductType.REGULAR) {
			return new Product(itemName, price, category);
		} else if (type == ProductType.SPECIAL) {
			return new ProductSpecialPackage(itemName, price, category);
		} else
			throw new IllegalArgumentException(); // New types not supported here
	}

}
