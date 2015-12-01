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
		size = 0;
		this.capacity = capacity;
	}

	@Override
	public void clear() {
		elements = null;
		System.out.println("Listan har tömts.");
	}

	@Override
	public boolean isEmpty() {
		/*
		boolean tmp = false;
		for (int i = 0; i < elements.length; i++) {
			if(elements[i] == null)
				tmp = false;
			else
				tmp = true;
		}*/
		return size == 0;
//		return (back == front) ? true : false; // Om slutet av kön är lika stor som början så är den tom.
	}

	@Override
	public void enqueue(V v) throws QueueFullException{
		if(isFull()) {
			throw new QueueFullException("Queue is full!");
			}
		elements[back] = v;
		back = (back + 1) % capacity;
		size++;
	}

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

	@Override
	public V getFront() throws QueueEmptyException{
		if(isEmpty())
			throw new QueueEmptyException("List is empty.");
		return elements[front];
	}

	public boolean isFull() {
		/*
		int difference = back - front;// ex: 9 - 10 
		if(difference == -1 || difference == (capacity - 1))
			return true;
		return false;*/
		return(this.size == this.capacity);		
	}
	
	public int size() {
		/*
		if(back > front)
            return back - front;
        return capacity - front + back;*/
		return size;
	}
}
