package se.hig.aod.lab2;

public class ArrayStack<V> implements Stack<V> {
	
	private V[] elements;
	private final int size = 10;
	
	public ArrayStack() {
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
	public void push(V v) {
		// TODO Auto-generated method stub
	}

	@Override
	public V pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V top() {
		// TODO Auto-generated method stub
		return null;
	}
}
