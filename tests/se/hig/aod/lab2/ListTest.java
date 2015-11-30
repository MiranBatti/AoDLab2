package se.hig.aod.lab2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListTest {
	
	List<Integer> testList;
	
	@Before
	public void setUp() throws Exception {
		testList = new LinkedList<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void isEmptyTest() {
		assertTrue(testList.isEmpty());
	}
	
	@Test
	public void nbrOfElementsOnEmpty() {
		assertEquals(0, testList.numberOfElements());
	}
	
	@Test
	public void nbrOfElementsOnNotEmpty() {
		testList.insertFirst(5);
		assertEquals(1, testList.numberOfElements());
	}
	
	@Test
	public void containsElementTest() {
		testList.insertFirst(3);
		assertTrue(testList.contains(3));
	}
}
