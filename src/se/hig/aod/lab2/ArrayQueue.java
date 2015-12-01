package se.hig.aod.lab2;

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
		this.capacity = capacity;
	}

	@Override
	public void clear() {
		elements = null;
	}

	@Override
	public boolean isEmpty() {
		return back == front ? true : false; // Om slutet av kön är lika stor som början så är den tom.
	}

	@Override
	public void enqueue(V v) {
		if(isFull()) {
			return; // behöver felhantering
		}
		elements[back] = v;
		back += 1 % capacity;
		size++;
	}

	@Override
	public V dequeue() {
		V tmp;
		if(isEmpty())
			return null; // behöver felhantering
		tmp = elements[front];
		elements[front] = null;
		front += 1 % capacity;
		size--;
		return tmp;
	}

	@Override
	public V getFront() {
		return elements[front];
	}

	public boolean isFull() {
		int difference = back - front;// ex: 9 - 10 
		if(difference == -1)
			return true;
		return false;
	}
	
	public int size() {
		return size;
	}
}
