package se.hig.aod.lab2;
/**
 * Queue representing FIFO queue of objects.
 * 
 * @author Miran Batti
 * @author Fredrik Lindorf
 * 
 * @version 2015-12-01
 *
 * @param <V>
 */
public class ArrayQueue<V> implements Queue<V> {
	
	private V[] elements;
	private int size;
	private int front, back;
	private final int capacity;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		elements = (V[]) new Object[capacity];
		front = 0;
		back = 0;
		size = 0;
		this.capacity = capacity;
	}

	/** 
     * Removes all elements from this queue and writes 
     * a message on {@link System}.out).
     */
	@Override
	public void clear() {
		elements = null;
		size = 0;
		System.out.println("Köen har tömts.");
	}

	/**
	 * Checks if this queue is empty.
	 * 
	 * @return true if queue is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Add an element at the last position in this queue.
	 * 
	 * @param object added to this queue.
	 */
	@Override
	public void enqueue(V v) throws QueueFullException{
		if(isFull()) {
			throw new QueueFullException("Queue is full!");
			}
		elements[back] = v;
		back = (back + 1) % capacity;
		size++;
	}

	/**
	 * Removes the first element from this queue. Will throw
	 * {@link QueueEmptyException} if this queue is empty.
	 * 
	 * @return the first element.
	 */
	@Override
	public V dequeue() throws QueueEmptyException{
		V tmp;
		if(isEmpty())
			throw new QueueEmptyException("Queue is empty");
		tmp = elements[front];
		elements[front] = null;
		front = (front + 1) % capacity;
		size--;
		return tmp;
	}

	/**
	 * Returns the first element in this queue, without removing it. Will throw
	 * {@link QueueEmptyException} if this queue is empty.
	 * 
	 * @return the first element.
	 */
	@Override
	public V getFront() throws QueueEmptyException{
		if(isEmpty())
			throw new QueueEmptyException("List is empty.");
		return elements[front];
	}

	/**
	 * Check if this queue is full.
	 * @return true if list full, otherwise false
	 */
	public boolean isFull() {
		return(this.size == this.capacity);		
	}
	
	/**
	 * Returns the size of this queue.
	 * @return the size of this queue
	 */
	public int size() {
		return size;
	}
}
