package orGalProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> {
	private ArrayList<E> arrayList;
	private MyButton button;

	public MyArrayList(ArrayList<E> arrayList, MyButton button) {
		this.arrayList = arrayList;
		this.button = button;
	}
	
	public void add(E val)
	{
		arrayList.add(val);
	}

	public Iterator<E> iterator() {
		return new ConcreteIterator();
	}

	public ListIterator<E> listIterator() {
		return new ConcreteListIterator(0);
	}

	public ListIterator<E> listIterator(int index) {
		return new ConcreteListIterator(index);
	}
	
	public Memento<E> createMemento()
	{
		return new Memento<>(arrayList);
	}
	
	public void setMemento(Memento<E> m)
	{
		arrayList=new ArrayList<>(m.list);
	}
	
	
	public static class Memento<E>{
		private final ArrayList<E> list; 
		
		private Memento(ArrayList<E> arrayList)
		{
			list=new ArrayList<>(arrayList);
		}
		
	}

	public class ConcreteIterator implements Iterator<E> {
		private int cur = 0;

		@Override
		public boolean hasNext() {
			if (cur == arrayList.size()) {
				if (button != null) {
					button.setMsg("My Iterator ended!\n");
					button.click();
				}
			}

			return cur < arrayList.size();

		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return arrayList.get(cur++);

		}

	}

	public class ConcreteListIterator  implements ListIterator<E> {

		private int index = 0;

		public ConcreteListIterator(int startIndex) {
			if (startIndex < 0 || startIndex > arrayList.size()) {
				throw new IndexOutOfBoundsException("Invalid start index");
			}
			this.index = startIndex;
		}

		@Override
		public boolean hasNext() {
			if (index == arrayList.size()) {
				if (button != null) {
					button.setMsg("My ListIterator ended!\n");
					button.click();
				}
			}
			return index < arrayList.size();

		}

		@Override
		public E next() {

			if (!hasNext())
				throw new NoSuchElementException();
			return arrayList.get(index++);

		}

		@Override
		public boolean hasPrevious() {
			if (index == 0) {
				if (button != null) {
					button.setMsg("My ListIterator ended!\n");
					button.click();
				}
			}

			return index > 0;
		}

		@Override
		public E previous() {
			if (!hasPrevious())
				throw new NoSuchElementException();
			return arrayList.get(--index);

		}

		@Override
		public int nextIndex() {
			return index;
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Remove operation is not supported.");

		}

		@Override
		public void set(E e) {
			throw new UnsupportedOperationException("Remove operation is not supported.");

		}

		@Override
		public void add(E e) {
			throw new UnsupportedOperationException("Remove operation is not supported.");

		}

	}

}
