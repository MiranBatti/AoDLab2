package se.hig.aod.lab2;

/**
 * Simple LinkedList implementation.
 * 
 * @author Miran Batti
 * @author Fredrik Lindorf
 * @version 2015-12-02
 *
 * @param 
 *         <T>
 */
public class LinkedList<T> implements ExtendList<T>{

	private ListNode<T> head;
	
	public LinkedList() {
	}
	
	/**
	 * Check if list is empty.
	 * @return true if empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}
	
	/**
	 * Clears the list of all elements.
	 */
	@Override
	public void clear() {
		head = null;
	}
	
	/**
	 * Return number of elements in the list.
	 * @return the size of the list
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
	 * Add an element at the first possition in the list.
	 * 
	 * @param t
	 *            objekt to add.
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
	 * Add an element at the last possition in the list.
	 * 
	 * @param t
	 *            objekt to add.
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
	 * Remove the first element from the list.
	 * 
	 * @return the first element from the list.
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

	/**
	 * Remove the last element from the list.
	 * 
	 * @return the last element from the list.
	 */
	@Override
	public T removeLast() throws ListIsEmptyException{
		ListNode<T> previous = null;;
		ListNode<T> current = head;
		T rtrn = null;
		
		if(isEmpty()) {
			throw new ListIsEmptyException("List is empty.");
		} 
		if(head.next == null)
			head = null;
		else {
			while(current.next != null) {
				previous = current;
				current = current.next;
			}
			rtrn = current.element;
			previous.next = null;
			current = null;
		}
		return rtrn;
	}

	/**
	 * Peek at the first element in the list, without removing it.
	 * 
	 * @return the first element in the list.
	 */
	@Override
	public T getFirst() throws ListIsEmptyException{
		if(!isEmpty())
			return head.element;
		else
			throw new ListIsEmptyException("List is empty.");
	}

	/**
	 * Peek at the last element in the list, without removing it.
	 * 
	 * @return the last element in the list.
	 */
	@Override
	public T getLast() throws ListIsEmptyException{
		ListNode<T> tmp = head;
		// behöver kanske felhantering för tom lista.
		if(!isEmpty()) {
			while(tmp.next != null) {
				tmp = tmp.next;			
			}
		} else throw new ListIsEmptyException("List is empty.");
		return tmp.element;
	}

	/**
	 * Check if the element in t exist somewhere in the list.
	 * 
	 * @param t
	 *            the element.
	 * @return true if the element exist somewhere in the list, otherwise false.
	 */
	@Override
	public boolean contains(T t) throws ListIsEmptyException{
		ListNode<T> current = head;
		if(isEmpty())
			throw new ListIsEmptyException("List is empty.");
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

	/**
	 * Write the contents of the list to System.out using iteration.
	 * 
	 */
	@Override
	public void printList() {
		ListNode<T> current = head;
		while(current != null) {
			System.out.println(current.element);	
			current = current.next;
		}
	}

	/**
	 * Write the contents of the list to System.out using recursion.
	 */
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

	/**
	 * Write the contents of the list to System.out in reversed order.
	 */
	@Override
	public void reversePrintList() {
		if(head == null) return;
		head.printR(head);
	}

	/**
	 * List node used by list to store elements and point to other nodes.
	 * @author Miran Batti
	 * @author Fredrik Lindorf
	 * @version 2015-11-28
	 *
	 * @param <T>
	 */
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
	/**
	 * Adds an element at any position in the list.
	 * @param t 
	 * object to add 
	 * index
	 * position in the list
	 */
	@Override
	public void insert(T t, int index) {
		
		if(isEmpty()){ // det går endas lägga element först i listan om den är tom.
			head = new ListNode<T>(t, null); return;
		}
		
		ListNode<T> current = head;
		ListNode<T> next = current.next;
		ListNode<T> newNode;
		
		if(index == 0) {
			newNode = new ListNode<T>(t, head);
			head = newNode;
			return;
		}
		
		for (int i = 0; i < index - 1; i++) {
			current = current.next;
			next = current.next;
		}
		newNode = new ListNode<T>(t, next);
		current.next = newNode;
	}
	/**
	 * Removes element from list.
	 * @return removed element
	 */
	@Override
	public T remove(T t) throws ListIsEmptyException{
		ListNode<T> current = head;
		ListNode<T> previous = null;
		
		if(isEmpty()) // första fallet är om listan är tom.
			throw new ListIsEmptyException("List is empty");
		
		if(head.equals(t)) { // andra fallet är om det första elementet ska bort.
			current = head;
			head = head.next; // ersätter färsta elementet med nästa.
			return current.element;
		}
		//i det tredje fallet måste vi iterera genom listan tills vi hittar elementet.
		while(current != null && !current.element.equals(t)) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		current = null;
		return null;
	}
	/**
	 * Returns element from specified index.
	 * @param
	 *        index
	 * @return element in index
	 */
	@Override
	public T get(int index) throws ListIsEmptyException{
		
		if(isEmpty())
			throw new ListIsEmptyException("List is empty");
		
		if(index < 0 || index >= this.numberOfElements())
			throw new IllegalArgumentException("Index value not valid.");
		
		ListNode<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.element;
	}
	/**
	 * Removes element from specified index.
	 * @param 
	 *         index
	 * @return removed object
	 */
	@Override
	public T remove(int index) throws ListIsEmptyException{
		
		if(isEmpty())
			throw new ListIsEmptyException("List is empty");
		
		if(index < 0 || index >= this.numberOfElements()) // om indexet är för litet eller större en listan blir det fel. 
			throw new IllegalArgumentException("Index value not valid.");
		
		T removedElement = null;		
		
		if(index == 0) {
			removedElement = head.element;
			head = head.next;
			return removedElement;
		}
		
		ListNode<T> current = head;
		
		for (int i = 0; i < index - 1; i++) {
			current = current.next;
		}
		
		removedElement = current.next.element;
		current.next = current.next.next;
		
		return removedElement;
	}
		
}
