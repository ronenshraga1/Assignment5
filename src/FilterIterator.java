import java.util.Iterator;
import java.util.NoSuchElementException;


public class FilterIterator<T> implements Iterator<T> {
	Iterator<T> iterator;
	Iterable<Filter<T>> filters;
	T next;
	
	public FilterIterator(Iterable<T> elements, Iterable<Filter<T>> filters) {
		if (elements == null || filters == null) {
			throw new IllegalArgumentException("elements are null");
		}
		this.iterator = elements.iterator();
	    this.filters = filters;
		next = findValid();
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}

	@Override
	public T next() {
		if(!hasNext()){
			throw new NoSuchElementException();
		}
		T element = next;
		next = findValid();

		return element;
	}
	private T findValid(){
		while (iterator.hasNext()){
			T element = iterator.next();
			if(isValid(element)){
				return element;
			}
		}
		return null;
	}
	private boolean isValid(T element){
		Iterator<Filter<T>> filtersIterator = filters.iterator();
		while (filtersIterator.hasNext()){
			Filter<T> filter = filtersIterator.next();
			if(!filter.accept(element)){
				return false;
			}
		}
		return true;
	}
}
