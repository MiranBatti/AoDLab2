package se.hig.aod.lab2;

import se.hig.aod.lab2.LinkedList.ListNode;
/**
 * Kod från kurslitteraturen.
 * @author Miran Batti
 *
 * @param <T>
 */
public class LinkedListIterator<T> {
	
	ListNode<T> current;
	
	public LinkedListIterator(ListNode<T> theNode) {
		current = theNode;
	}
	
	public boolean isValid() {
		return current != null;
	}
	
	public T retrieve() {
		return isValid() ? current.element : null;
	}
	
	public void advance() {
		if(isValid())
			current = current.next;
	}
}
