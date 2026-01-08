package orGalProject;

public class AddressFactory {

	public static Address createAddress(String street, String buildingNum, String city, String country) {

		return new Address(street, buildingNum, city, country);
	}

}
