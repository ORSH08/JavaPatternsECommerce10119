package orGalProject;

public class Product {

	private String itemName;
	private double price;
	private Category category;
	private int id;
	// private static final int MIN_PRODUCT_ENUM = 0;
	private static int idEnumerator = 0;

	public Product(String itemName, double price, Category category) throws IllegalArgumentException {
		if (itemName.isBlank()) {
			throw new IllegalArgumentException();
		}
		this.id = ++idEnumerator;
		this.itemName = itemName;
		this.price = price;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return itemName + ", price: " + price + ", category: " + category + " ,serial number: " + id;
	}
}