package se.hig.aod.lab2;

public class ArrayStack<V> implements Stack<V> {
	
	private V[] elements;
	private int top;
	
	public ArrayStack(int capacity) {
		if(capacity <= 0)
			throw new IllegalArgumentException("Stack needs to be larger than 0.");
		elements = (V[]) new Object[capacity];
		top = -1;
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
		if(top == elements.length)
			return; // behöver felhantering.
		top++;
		elements[top] = v;
	}

	@Override
	public V pop() {
		if(top == -1)
			return null; // behöver felhantering
		V tmp = elements[top];
		elements[top] = null;
		top--;
		return tmp;
	}

	@Override
	public V top() {
		if(top == -1)
			return null; // behöver felhantering
		return elements[top];
	}
	
	public boolean isFull() {
		// TODO a real fucking implementation
		return false;
	}
}
