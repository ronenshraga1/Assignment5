import java.util.Iterator;

public class LinkedList<T> implements List<T> {
	
	// ---------------------- fields ---------------------- 
	private Link<T> first;
	
	// ---------------------- constructors ----------------------
	public LinkedList(){		
		first = null;
	}

	// ---------------------- methods ----------------------
	//Returns the number of elements in this list
	public int size() {
		int counter = 0;
		for(Link<T> curr = first; curr != null; curr = curr.getNext()) {
			counter = counter + 1;
		}
		return counter;
	}
	
	//Returns true if this list contains no elements.
	public boolean isEmpty() {
		return first == null;
	}
	
	//Adds element to the beginning of this list
	public void addFirst(T element) {
		if (element == null)
			throw new IllegalArgumentException("input argument is null");
		first = new Link<T>(element, first);
	}
	
	//Returns the element at the specified position in this list.
	public T get(int index) {
	    if (!rangeCheck(index)) {
			throw new IllegalArgumentException("Index: " + index + ", Size: " + size());
		}
	    Link<T> current = first;
	    while (index > 0) {
	        index = index - 1;
	        current = current.getNext();
	    }
	    return (T) current.getData();
	}
	
	//Returns a String representing this object
	public String toString() {
	    String output = "<";
	    Link<T> current = first;
	    while (current != null) {
	        output = output + current.toString();
	        current = current.getNext();
	        if(current != null)
	        	output = output + ", ";
	    }
	    output = output + ">";
	    return output;
	}
	
	//Remove the first Link which contains toRemove, if such one exists
	public boolean remove(T toRemove) {
		if (toRemove == null) {
			throw new IllegalArgumentException("element is null");
		}
		boolean removed = false;
		Link<T> curr = first;
		Link<T> prev = curr;
		while (curr != null && !removed){
			if (curr.getData().equals(toRemove)){
				if (curr == first)
					first = curr.getNext();
				else {
					prev.setNext(curr.getNext());
				}
				removed = true;
			}
			else{
				prev = curr;
				curr = curr.getNext();
			}
		}
		return removed;
	}
	
	//Returns true if this list contains the specified element
	public boolean contains(T element){
		if (element == null) {
			throw new IllegalArgumentException("input argument is null");
		}
		boolean output = false;
		for(Link<T> curr = first; curr != null && !output; curr = curr.getNext()) {
			output = element.equals(curr.getData());
		}
		return output;		
	}

	//Replaces the element at the specified position in this list with the specified element
	public T set(int index, T element){
		if(!rangeCheck(index)) {
			throw new IllegalArgumentException("Index: " + index + ", Size: " + size());
		}
		if (element == null) {
			throw new IllegalArgumentException("input argument is null");
		}
		Link<T> current = first;
		while (index > 0) {
			index = index - 1;
			current = current.getNext();
		}
		T prev = current.getData();
		current.setData(element);
		return prev;
	}
	
    public T remove(int index) {
		if(!rangeCheck(index)) {
			throw new IllegalArgumentException("Index: " + index + ", Size: " + size());
		}
        Link<T> current = first;
        Link<T> prev = current;
        while (index > 0) {
            index = index - 1;
            prev = current;
            current = current.getNext();
        }
        T ans = (T) current.getData();
        if (first == current) {
            first = first.getNext();
        }
        else {
            prev.setNext(current.getNext());
        }
        return ans;
    }

	//Inserts the specified element at the specified position in this list
	public void add(int index, T element) {
		if (!rangeCheck(index)) {
			throw new IllegalArgumentException("index is not in range");
		}
		if (element == null) {
			throw new IllegalArgumentException("element is null");
		}
		if (index == 0) {
			addFirst(element);
		}
		else{
			Link<T> prev = null;
			Link<T> curr = first;
			for (int i = 0; i < index; i = i + 1){
				prev = curr;
				curr = curr.getNext();
			}
			Link<T> toAdd = new Link<>(element, curr);
			prev.setNext(toAdd);
		}
	}
	
	//Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
	public int indexOf(T element){
		int output = -1;
		int index = 0;
		for(Link<T> curr = first; curr != null && output == -1; curr = curr.getNext()) {
			if (curr.getData().equals(element)) {
				output = index;
			}
			else {
				index = index + 1;
			}
		}
		return output;
	}
	
	//Appends the specified element to the end of this list
	public void add(T element) {
		   if(element == null) {
			   throw new IllegalArgumentException("input argument is null");
		   }
		   Link<T> newLink = new Link<>(element); 
		   if(isEmpty()){
			   first = newLink;
		   }
		   else {
			   Link<T> current = first;
			   while (current.getNext() != null){
				   current = current.getNext();				   
			   }
			   current.setNext(newLink);
		   }
	}
	
	// returns true iff the given index is in range
	private boolean rangeCheck(int index) {
		if(index >= 0 && index < size()) {
			return true;
		}
		return false;	        
	}

	public Iterator<T> iterator() {
		return new LinkedListIterator<T>(first);
	}
}
