package se.hig.aod.lab2;
/**
 * An extension for the interface List
 * 
 * @author Miran Batti
 * @author Fredrik Lindorf
 * @version 2015-12-01
 * @param <V>
 */
public interface ExtendList<T> extends List<T>{
	/**
	 * Adds an element at any position in the list.
	 * @param t 
	 * object to add 
	 * index
	 * position in the list
	 */
	public void insert(T t, int index);
	/**
	 * Removes specified element from the list.
	 * @param t
	 * @return removed object
	 */
	public T remove(T t);
	/**
	 * Removes element from specified index.
	 * @param index
	 * @return removed object
	 */
	public T remove(int index);
	/**
	 * Returns element in specified index.
	 * @param index
	 * @return element in index
	 */
	public T get(int index);
}
