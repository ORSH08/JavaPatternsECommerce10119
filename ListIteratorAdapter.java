package orGalProject;



import java.util.ListIterator;

public class ListIteratorAdapter<E> {
	private ListIterator<E> iterator;
	
	public ListIteratorAdapter(ListIterator<E> itertor)
	{
		this.iterator=itertor;
	}
	

	public boolean myHasNext()
	{
		return iterator.hasNext();
	}
	
	
	public E myNext() {
		return iterator.next();
	}
	
	
	public boolean myHasPrevious()
	{
		return iterator.hasPrevious();
	}
	
	public void myAdd(E e)
	{
		iterator.add(e);
		
	}
	
	public E myPrevious()
	{
		return iterator.previous();
	}
	
	
}
