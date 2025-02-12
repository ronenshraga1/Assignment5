public interface List <T> extends Iterable<T>{
    //Returns the number of elements in this list.
    public int size();

    //Appends the specified element to the end of this list
    public void add(T element);

    //Inserts the specified element at the specified position in this list
    public void add(int index, T element);

    //Replaces the element at the specified position in this list with the specified element
    //Returns the old element from the specified position
    public T set(int index, T element);

    //Returns the element at the specified position in this list.
    public T get(int index);

    //Removes the first occurrence of the specified element from this list, if it is present
    //Return true if the specified element was in the list and was removed, false if the element was not found
    public boolean remove(T element);

    //Removes the element at position i and returns it
    public T remove(int index);

    //Returns true if this list contains the specified element
    public boolean contains(T element);

    //Returns true if this list contains no elements
    public boolean isEmpty();

}

