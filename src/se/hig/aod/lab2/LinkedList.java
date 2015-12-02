package se.hig.aod.lab2;


public class LinkedList<T> implements ExtendList<T>{

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
		head = null;
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

	@Override
	public T getFirst() throws ListIsEmptyException{
		if(!isEmpty())
			return head.element;
		else
			throw new ListIsEmptyException("List is empty.");
	}

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

	@Override
	public void printList() {
		ListNode<T> current = head;
		while(current != null) {
			System.out.println(current.element);	
			current = current.next;
		}
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

	@Override
	public void insert(T t, int index) {
		ListNode<T> current = head;
		ListNode<T> next = current.next;
		ListNode<T> newNode;
		
		if(isEmpty()){ // det går endas lägga element först i listan om den är tom.
			head = new ListNode<T>(t, null); return;
		}
		
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
	@Override
	public T get(int index) throws ListIsEmptyException{
		
		if(isEmpty())
			throw new ListIsEmptyException("List is empty");
		
		if(index < 0 || index >= size())
			throw new IllegalArgumentException("Index value not valid.");
		
		ListNode<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.element;
	}
	@Override
	public T remove(int index) throws ListIsEmptyException{
		
		if(isEmpty())
			throw new ListIsEmptyException("List is empty");
		
		if(index < 0 || index >= size()) // om indexet är för litet eller större en listan blir det fel. 
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
	
	private int size() {
		int size = 0;
		ListNode<T> current = head;
		while(current != null){
			size++;
			current = current.next;
		}
		return size;
	}
	
}
