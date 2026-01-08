package orGalProject;

public class ExceptionUtil {

	public void emptyCart(Double price) throws EmptyCartException {
		if (price == 0) {
			throw new EmptyCartException();

		}
	}

}