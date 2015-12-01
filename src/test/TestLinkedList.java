package test;

import se.hig.aod.lab2.List;
import se.hig.aod.lab2.LinkedList;;

public class TestLinkedList {
	public static void main(String[] args) {
		 List<String> list = new LinkedList <String>();
	     list.insertFirst("!");
	     list.insertFirst("j");
	     list.insertFirst("e");
	     list.insertFirst("h");
	     list.printList();
	      
	     System.out.println(list.getFirst() + " : första elementet i listan.");
	     System.out.println(list.getLast() + " : sista elementet i listan.");

	     list.insertLast("?");

	     list.removeLast();
	     list.printList();
	     
	     // för att jämföra beteendet mellan våran lista och javas lista.
	     java.util.LinkedList<Integer> z = new java.util.LinkedList<>();
	     z.clear();
	      /*
		List<Integer> testList = new LinkedList<Integer>();
		System.out.println(testList.numberOfElements());
		testList.insertFirst(1);
		testList.insertFirst(3);
		testList.insertLast(5);
		boolean tmp = testList.contains(1);
		System.out.println(tmp);
		System.out.println(testList.numberOfElements() + " : size");
		System.out.println(testList.getLast() + " last");
		testList.clear();
		testList.printList();
		testList.reversePrintList();*/
		
	}
}
