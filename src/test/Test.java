package test;

import se.hig.aod.lab2.List;
import se.hig.aod.lab2.LinkedList;;

public class Test {
	public static void main(String[] args) {
		List<Integer> testList = new LinkedList<Integer>();
		System.out.println(testList.getFirst());
		System.out.println(testList.numberOfElements());
		testList.insertFirst(1);
		boolean tmp = testList.contains(1);
		System.out.println(tmp);
	}
}
