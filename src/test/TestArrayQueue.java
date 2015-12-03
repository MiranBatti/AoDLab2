package test;

import se.hig.aod.lab2.ArrayQueue;

public class TestArrayQueue {
	public static void main(String[] args) {
		ArrayQueue<Integer> testQueue = new ArrayQueue<>(2);
		System.out.println(testQueue.isEmpty() + " : är tom");
		System.out.println(testQueue.isFull() + " : är full");
		testQueue.enqueue(2);
		testQueue.enqueue(4);
		System.out.println(testQueue.dequeue() + " : dequeued");
		System.out.println(testQueue.size() + " : size");
		System.out.println(testQueue.getFront());
		System.out.println(testQueue.isEmpty() + " : är tom");
		testQueue.enqueue(9);
		System.out.println(testQueue.isFull() + " : är full");
	}
}
