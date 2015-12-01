package test;

import se.hig.aod.lab2.ArrayQueue;

public class TestArrayQueue {
	public static void main(String[] args) {
		ArrayQueue<Integer> testQueue = new ArrayQueue<>(10);
		testQueue.enqueue(2);
		testQueue.enqueue(4);
		testQueue.dequeue();
		System.out.println(testQueue.getFront());
	}
}
