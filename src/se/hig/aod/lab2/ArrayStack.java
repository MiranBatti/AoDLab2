package se.hig.aod.lab2;

/**
 * Stack representing LIFO stack of objects.
 * 
 * @author Miran Batti
 * @author Fredrik Lindorf
 * 
 * @version 2015-12-01
 *
 * @param <V>
 */
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

	/** 
     * Removes all elements from this stack and writes 
     * a message on {@link System}.out).
     */
	@Override
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = null;
			if(top != -1)
				top--;
		}
		System.out.println("Stacken har tömts.");
	}

	/**
     * Checks if this stack is empty.
     * 
     * @return true if stack is empty, false otherwise.
     */
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	/**
     * Adds an element on the top of this stack.
     * 
     * @param v - the object added on the top of the stack.
     */
	@Override
	public void push(V v) {
		top++;				
		elements[top] = v;
	}

	/**
	 * Removes the top element of this stack. Will throw
	 * {@link StackEmptyException} if the stack is empty.
	 * 
	 * @return top element of the stack.
	 */
	@Override
	public V pop() throws StackEmptyException{
		if(top == -1)
			throw new StackEmptyException("Can't remove from empty stack.");
		V tmp = elements[top];
		elements[top] = null;
		top--;
		return tmp;
	}

	/**
     * Returns the top element of this stack, without removing it.
     * Will throw {@link StackEmptyException} if the stack is empty.
     * 
     * @return top element of the stack.
     */
	@Override
	public V top() throws StackEmptyException{
		if(top == -1)
			throw new StackEmptyException("Stack is empty.");
		return elements[top];
	}
	
	/**
	 * Returns the size of this stack.
	 * @return the size of this stack
	 */
	public int size() {
		return top + 1;
	}

	/**
	 * Check if this stack is full.
	 * @return true if stack is full, otherwise false
	 */
	public boolean isFull() {
		return size() == elements.length;
	}
}
