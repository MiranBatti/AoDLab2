package test;

import se.hig.aod.lab2.ExtendList;
import se.hig.aod.lab2.LinkedList;;

public class TestLinkedList {
	public static void main(String[] args) {
		 ExtendList<String> list = new LinkedList <String>();
	     list.insertFirst("!");
	     list.insertFirst("j");
	     list.insertFirst("e");
	     list.insertFirst("h");
	     list.printList();
	      
	     System.out.println(list.getFirst() + " : första elementet i listan.");
	     System.out.println(list.getLast() + " : sista elementet i listan.");

//	     list.insertLast("?");
	     list.insert("?", 0);

//	     System.out.println(list.removeLast() + " : sista elementet som togs bort.");
	     System.out.println(list.remove(0) + " : index removed");
	     System.out.println(list.get(2) + " : get");
	     list.reversePrintList();
	     
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
