package se.hig.aod.lab2;

public class ArrayQueue<V> implements Queue<V> {
	
	private V[] elements;
	private final int size = 10;
	private int top;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		elements = (V[]) new Object[size];
	}

	@Override
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
			if(top != -1)
				top--;
		}
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
