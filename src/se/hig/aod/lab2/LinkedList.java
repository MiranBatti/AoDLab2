package se.hig.aod.lab2;

import javax.swing.ListSelectionModel;

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
	/**
	 * Returnerar antal element i listan.
	 */
	@Override
	public int numberOfElements() {
		ListNode<T> current = head;
		int size = 0;
		// så länge nuvarande nod inte är tom ökas size.
		// efter storleken ökas kollar vi i nästa nod.
		while(current != null) {
			size++;
			current = head.next;
		}	
		return size;
	}
	/**
	 * Lägg element först i listan.
	 */
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
	/**
	 * Lägg element sist i listan.
	 */
	@Override
	public void insertLast(T t) {
		while(head.next != null) 
			head = head.next;
		ListNode<T> tmp = new ListNode<T>(t, null);
		head.next = tmp;
	}
	/**
	 * Ta bort det första elementet i listan.
	 */
	@Override
	public T removeFirst() {
		ListNode<T> tmp;
		if(!isEmpty()) {
			tmp = head;
			head.element = null;
			head = tmp.next;
		}
		return head.element; // behöver felhantering. returnerar sista elementet i listan.
	}

	@Override
	public T removeLast() {
		if(isEmpty()) {
			System.err.println("Nothing to remove; list is empty.");
			return null;
		} else if(numberOfElements() == 1)
			removeFirst();
		else { // traverserar listan till den sista noden.
			while(head.next != null)
				head = head.next;
			ListNode<T> tmp = head; // för att returnera sista elementet.
			head = null;
			return tmp.element;
		}
		return null;
	}

	@Override
	public T getFirst() {
		if(!isEmpty())
			return head.element;
		else
			return null;
	}

	@Override
	public T getLast() {
		ListNode<T> tmp = head;
		// behöver kanske felhantering för tom lista.
		if(!isEmpty()) {
			while(head.next != null) {
				head = head.next;			
				tmp = head;
			}
		} else return null;
		return tmp.element;
	}

	@Override
	public boolean contains(T t) {
		ListNode<T> tmp = head;
		if(getFirst().equals(t))
			return true;
		else
			while(head.next != null) {
				tmp = head;
				head = head.next;
				if(tmp.equals(t))
					return true;
			}
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
