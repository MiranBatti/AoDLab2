package se.hig.aod.lab2;

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

	private ListNode<T> head;
//	private int size;
	
	public LinkedList() {
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
			current = current.next;
		}	
		return size;
	}
	/**
	 * Lägg element först i listan.
	 */
	@Override
	public void insertFirst(T t) {
		ListNode<T> tmp;
		if(isEmpty()) {
			tmp = new ListNode<T>(t, null);
			head = tmp;
		} else {
			tmp = new ListNode<T>(t, head);
			head = tmp;
		}
	}
	/**
	 * Lägg element sist i listan.
	 */
	@Override
	public void insertLast(T t) {
		ListNode<T> last = new ListNode<T>(t, null);
		ListNode<T> first = head;
		
		if(isEmpty()) {
			head = last;
		} else {
			while(first.next != null) 
				first = first.next;
			first.next = last;
		}
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
	public T removeLast() throws ListIsEmptyException{
		ListNode<T> last;
		ListNode<T> first = head;
		
		if(isEmpty()) {
			throw new ListIsEmptyException("List is empty.");
		} 
		if(head.next == null)
			head = null;
		else {
			while(first.next != null) 
				first = first.next;
			first = null;
		}
		/*
		ListNode<T> current = head;
		if(isEmpty()) {
			System.err.println("Nothing to remove; list is empty.");
			return null;
		} else if(numberOfElements() == 1)
			removeFirst();
		else { // traverserar listan till den sista noden.
			while(current.next != null)
				current = current.next;
			ListNode<T> tmp = current; // för att returnera sista elementet.
			current.element = null;
			return tmp.element;
		}*/
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
	public boolean contains(T t) throws ListIsEmptyException{
		ListNode<T> current = head;
		if(!isEmpty() && getFirst().equals(t))
			return true;
		else
			while(current != null) {
				current = head.next;
				if(current.element.equals(t))
					return true;
				else
					return false;
			}
		return false;
	}

	@Override
	public void printList() {
		ListNode<T> current = head;
		while(current != null) {
			System.out.println(current.element);	
			current = current.next;
		}
		/*
		if(!isEmpty()) {
			System.out.println(head.element);
			while(head.next != null) {
				System.out.println(head.element);
				head = head.next;
			}
		}*/
	}

	@Override
	public void printListR() {
			if(head == null) return;
			else {
				while(head != null) {
					System.out.println(head.element);
					head = head.next;
					printListR();
				}
			}
	}

	@Override
	public void reversePrintList() {
		if(head == null) return;
		head.printR(head);
	}

	static class ListNode<T> {
		T element;
		ListNode<T> next;
		
		public ListNode(T element, ListNode<T> next) {
			this.element = element;
			this.next = next;
		}

		public void printR(ListNode<T> node) {
			if(node == null)
				return;
			else
				printR(node.next);
			System.out.println(node.element);	
		}
	}
	
}
