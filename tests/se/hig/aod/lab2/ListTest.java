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
	/**
	 * Testar om listan är tom.
	 */
	@Test
	public void isEmptyTest() {
		assertTrue(testList.isEmpty());
	}
	/**
	 * Testar listans storlek då den är tom.
	 */
	@Test
	public void nbrOfElementsOnEmptyTest() {
		assertEquals(0, testList.numberOfElements());
	}
	/**
	 * Testar listans storlek då den inte är tom.
	 */
	@Test
	public void nbrOfElementsNotEmptyTest() {
		testList.insertFirst(5);
		assertEquals(1, testList.numberOfElements());
	}
	/**
	 * Testar om listan innehåller ett element som sökes efter.
	 */
	@Test
	public void containsElementTest() {
		testList.insertFirst(3);
		assertTrue(testList.contains(3));
	}
	/**
	 * Testar om listan inte innehåller ett element som sökes efter.
	 */
	@Test
	public void doesNotContainElementTest() {
		try {
			testList.contains(6);
			fail("Expected: ListIsEmptyException!");
		} catch (ListIsEmptyException e) {
			assertNotNull("Expected: ListIsEmptyException!");
		}
	}
	/**
	 * Sätt in ett element i listan och sedan en till som kommer vara först i listan.
	 */
	@Test
	public void insertFirstWhenListIsPopulated() {
		testList.insertFirst(2);
		testList.insertFirst(1);
		assertEquals(1, testList.getFirst().intValue());
	}
	/**
	 * Testar om värdet i första elementet i listan stämmer och om listan inte är tom efter
	 * ett element läggs till först i listan.
	 */
	@Test
	public void insertFirstWhenEmpty() {
		testList.insertFirst(4);
		assertEquals(4, testList.getFirst().intValue());
		assertTrue(!testList.isEmpty());
	}
	/**
	 * Testar lägga till element i slutet av listan efter något sätt in slutet av listan.
	 */
	@Test
	public void insertLastWhenListIsPopulated() {
		testList.insertLast(2);
		testList.insertLast(1);
		assertEquals(1, testList.getLast().intValue());
	}
	/**
	 * Testar om värdet i första elementet i listan stämmer och om listan inte är tom efter
	 * ett element läggs till först i listan.
	 */
	@Test
	public void insertLastWhenEmpty() {
		testList.insertLast(4);
		assertEquals(4, testList.getFirst().intValue());
		assertEquals(4, testList.getLast().intValue());
		assertTrue(!testList.isEmpty());
	}
} // end class
