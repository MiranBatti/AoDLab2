package se.hig.aod.lab2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Miran Batti
 * @author Fredrik Lindorf
 * @version 2015-12-01
 *
 */
public class ArrayQueueTest {
	ArrayQueue<Character> testQueue;
	char[] fixture = {'a', 'b', 'c', 'd'};

	@Before
	public void setUp() throws Exception {
		testQueue = new ArrayQueue<Character>(4);
	}

	@After
	public void tearDown() throws Exception {
		testQueue = null;
	}

	/**
	 * Testa om kö är tom när den skapas
	 */
	@Test
	public void testNewQueueIsEmpty ()
	{
		assertEquals(true, testQueue.isEmpty());
	}
	
	/**
	 * Testa om kö inte är tom efter någonting lagras i kö
	 */
	@Test
	public void testQueueWithItemNotEmpty ()
	{
		testQueue.enqueue(fixture[0]);
		assertFalse ("Containing an item but empty!", testQueue.isEmpty ());
	}
	
	/**
	 * Testa ta bort från en tom kö
	 */
	@Test
	public void testDequeueOnEmptyQueue ()
	{
		try
		{
			testQueue.dequeue();
			fail("Expected: QueueEmptyException!");
		} catch (QueueEmptyException e)
		{
			assertNotNull("Expected: QueueEmptyException!", e);
		}
	}
	
	/**
	 * Testa om kö är tom efter någonting lagras och sedan tas bort
	 */
	@Test
	public void testQueueIsEmptyAfterDequeue ()
	{
		testQueue.enqueue(fixture[0]);
		testQueue.dequeue();
		assertEquals(true, testQueue.isEmpty());
	}
	
	/**
	 * Testa ordningen. Den första i köen ska ut först.
	 */
	@Test
	public void testDequeueOrder ()
	{
		for (int i = 0; i < fixture.length; i++) {
			testQueue.enqueue(fixture[i]);
		}
		char a = testQueue.dequeue();
		assertEquals('a', a);
	}
	/**
	 * Testa tömma en tom kö.
	 */
	@Test
	public void testClearEmptyQueue ()
	{
		testQueue.clear();
		assertEquals(true, testQueue.isEmpty());
	}
	
	/**
	 * Testa tömma en kö som innehåller flera objekt.
	 */
	@Test
	public void testClearPopulatedQueue ()
	{
		for (int i = 0; i < fixture.length; i++) {
			testQueue.enqueue(fixture[i]);
		}
		testQueue.clear();
		assertEquals(true, testQueue.isEmpty());
	}

	/**
	 * Testar om kön är full då den är full.
	 */
	@Test
	public void testIsFullWhenFull() {
		for (int i = 0; i < fixture.length; i++) {
			testQueue.enqueue(fixture[i]);
		}
		assertTrue(testQueue.isFull());
	}

	/**
	 * Testar om kön är full då den är tom.
	 */
	@Test
	public void testIsFullWhenEmpty() {
		assertFalse(testQueue.isFull());
	}
	
	/**
	 * Testar köns storlek.
	 */
	@Test
	public void testSize() {
		for (int i = 0; i < fixture.length; i++) {
			testQueue.enqueue(fixture[i]);			
		}
		assertEquals(4, testQueue.size());
	}
}
