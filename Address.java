package orGalProject;

public class Address {

	private String streetAddress;
	private String buildingNumber;
	private String city;
	private String country;

	public Address(String streetAddress, String buildingNumber, String city, String state)
			throws IllegalArgumentException {
		if (streetAddress.isBlank()) {
			throw new IllegalArgumentException("state cant be null");

		}
		if (buildingNumber.isBlank()) {
			throw new IllegalArgumentException("buildingNumber cant be null");
		}
		if (city.isBlank()) {
			throw new IllegalArgumentException("city cant be null");
		}
		if (state.isBlank()) {
			throw new IllegalArgumentException("state cant be null");
		}

		this.streetAddress = streetAddress;
		this.buildingNumber = buildingNumber;
		this.city = city;
		this.country = state;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) throws IllegalArgumentException {
		if (streetAddress.isBlank()) {
			throw new IllegalArgumentException("state cant be null");
		}
		this.streetAddress = streetAddress;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) throws IllegalArgumentException {
		if (buildingNumber.isBlank()) {
			throw new IllegalArgumentException("building Number cant be null");
		}

		this.buildingNumber = buildingNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) throws IllegalArgumentException {
		if (city.isBlank()) {
			throw new IllegalArgumentException("city cant be null");
		}

		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String state) throws IllegalArgumentException {
		if (state.isBlank()) {
			throw new IllegalArgumentException("state cant be null");
		}
		this.country = state;
	}

	@Override
	public String toString() {
		return streetAddress + " " + buildingNumber + ", " + city + ", " + country;

	}
}