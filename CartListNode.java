package orGalProject;

public class CartListNode {

	private Cart cr;
	private CartListNode next; // = null

	public CartListNode() {
		this.cr = new Cart();
		this.next = null;
	}

	public Cart getCart() {
		return cr;
	}

	public void setCart(Cart cr) {
		this.cr = cr;
	}

	public CartListNode getNext() {
		return next;
	}

	public void setNext(CartListNode next) {
		this.next = next;
	}

}
