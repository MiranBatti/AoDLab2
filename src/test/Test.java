package test;

import se.hig.aod.lab2.List;
import se.hig.aod.lab2.LinkedList;;

public class Test {
	public static void main(String[] args) {
		List<Integer> testList = new LinkedList<Integer>();
		System.out.println(testList.numberOfElements());
		testList.insertFirst(1);
		testList.insertFirst(3);
		testList.insertLast(5);
		boolean tmp = testList.contains(1);
		System.out.println(tmp);
		System.out.println(testList.numberOfElements() + " : size");
		testList.printList();
		testList.reversePrintList();
		
		List<String> s = new LinkedList<String>();
		s.insertFirst("test");
		System.out.println(s.contains("test"));
		s.printList();
		
	}
}
