package orGalProject;

public class PersonFactory {

	public static Person createPerson(PersonType type, String name) {
		if (type == PersonType.BUYER) {
			return new Buyer(name);
		} else if (type == PersonType.SELLER) {
			return new Seller(name);
		} else
			throw new IllegalArgumentException(); // New types not supported here
	}

}
