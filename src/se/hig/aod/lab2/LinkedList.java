package se.hig.aod.lab2;

public class LinkedList<T> implements List<T> {

	private ListNode<T> head;
	private int size;
	
	public LinkedList() {
		this.head = null;
	}
	/**
	 * Kollar om listan är tom.
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}
	/**
	 * Tömmer listan
	 */
	@Override
	public void clear() {
		//medan listan inte är tom: ta bort första elementet.
		while(!isEmpty()) {
			removeFirst();
		}
	}

	@Override
	public int numberOfElements() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertFirst(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertLast(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printListR() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reversePrintList() {
		// TODO Auto-generated method stub
		
	}

	static class ListNode<T> {
		T element;
		ListNode next;
		
		public ListNode(T data, ListNode next) {
			this.element = data;
			this.next = next;
		}
	}
	
}
