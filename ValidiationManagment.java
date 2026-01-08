package orGalProject;

public class ValidiationManagment {

	public static void checkString(String s) {
		if (s.isBlank() || s == null)
			throw new IllegalArgumentException("String cannot be null or blank.");
	}

}
