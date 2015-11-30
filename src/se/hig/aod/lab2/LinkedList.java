package se.hig.aod.lab2;

public class LinkedList<T> implements List<T> {

	private ListNode<T> head;
//	private int size;
	
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
		//medan listan inte är tom; ta bort första elementet.
		while(!isEmpty()) {
			removeFirst();
		}
	}

	@Override
	public int numberOfElements() {
		head = head.next;
		int size = 0;
		
		while(head.next != null) {
			size++;
			head = head.next;
		}
		/*
		// Om listan är tom fångas ett fel med trycatch. Returnerar sedan 0.
		try {
			for (ListNode<T> n = head; n.next != null; n = n.next) {
				size++;
			}
		} catch (NullPointerException e) {
			System.out.println("List is empty.");
		}*/
		
		return size;
	}

	@Override
	public void insertFirst(T t) {
		if(isEmpty()) {
			ListNode<T> tmp = new ListNode<T>(t, null);
			head = tmp;
		} else {
			ListNode<T> tmp = new ListNode<T>(t, head);
			head = tmp;
		}
	}

	@Override
	public void insertLast(T t) {
		while(head.next != null) 
			head = head.next;
		ListNode<T> tmp = new ListNode<T>(t, null);
		head = tmp;
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
		ListNode<T> next;
		
		public ListNode(T element, ListNode<T> next) {
			this.element = element;
			this.next = next;
		}
	}
	
}
