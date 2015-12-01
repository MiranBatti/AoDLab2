package se.hig.aod.lab2;

public class ArrayStack<V> implements Stack<V> {
	
	private V[] elements;
	private int top;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		if(capacity <= 0)
			throw new IllegalArgumentException("Stack needs to be larger than 0.");
		elements = (V[]) new Object[capacity];
		top = -1;
	}

	@Override
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
			if(top != -1)
				top--;
		}
		System.out.println("Listan har tömts.");
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public void push(V v) {
		top++;				
		elements[top] = v;
	}

	@Override
	public V pop() throws StackEmptyException{
		if(top == -1)
			throw new StackEmptyException("Can't remove from empty stack.");
		V tmp = elements[top];
		elements[top] = null;
		top--;
		return tmp;
	}

	@Override
	public V top() throws StackEmptyException{
		if(top == -1)
			throw new StackEmptyException("Can't remove from empty stack.");
		return elements[top];
	}
	
	public int size() {
		return top + 1;
	}
	
	public boolean isFull() {
		return size() == elements.length;
	}
}
