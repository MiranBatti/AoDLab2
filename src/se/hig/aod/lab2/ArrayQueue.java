package se.hig.aod.lab2;

public class ArrayQueue<V> implements Queue<V> {
	
	private V[] elements;
	private final int size = 10;
	
	public ArrayQueue() {
		elements = (V[]) new Object[size];
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enqueue(V v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getFront() {
		// TODO Auto-generated method stub
		return null;
	}

}
