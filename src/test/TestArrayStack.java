package test;

import se.hig.aod.lab2.ArrayStack;
import se.hig.aod.lab2.Stack;

public class TestArrayStack {
	public static void main(String[] args) {
		Stack<Integer> s = new ArrayStack<Integer>(3);
		s.push(3);
		s.pop();
		s.clear();
	}
}
