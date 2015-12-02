package se.hig.aod.lab2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Miran Batti
 * @author Fredrik Lindorf
 * 
 * @version 2015-12-01
 *
 */
public class ListTest {
	
	ExtendList<Integer> testList;
	int[] fixture = {1, 2, 3, 4};
	
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
	/**
	 * Testar lägga in element i listan med insert(index) och testar hämta från index som inte finns.
	 * Listan är tom.
	 */
	@Test
	public void testInsertAnyPositionOnEmpty() {
		testList.insert(4, 3);
		assertEquals(4, testList.getFirst().intValue());
		assertEquals(4, testList.getLast().intValue());
		assertEquals(4, testList.get(0).intValue());
		try {
			testList.get(1);
			fail("Expected: IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertNotNull("Expected: IllegalArgumentException");
		}
	}
	/**
	 * Testar lägga in element i listan med (insert) i en lista som inte är tom.
	 */
	@Test
	public void testInsertPopulatedList() {
		for (int i = 0; i < fixture.length; i++) {
			testList.insert(fixture[i], i);
		}
		assertEquals(1, testList.getFirst().intValue());
		assertEquals(2, testList.get(1).intValue());
		assertEquals(3, testList.get(2).intValue());
		assertEquals(4, testList.getLast().intValue());
		
		testList.insert(5, 2); // 5:an kommer hamna mellan 2 och 3
		assertEquals(5, testList.get(2).intValue());
	}
	/**
	 * Testar ta bort från listan med remove(index).
	 */
	@Test
	public void removeByIndex() {
		for (int i = 0; i < fixture.length; i++) {
			testList.insert(fixture[i], i);
		}
		testList.remove(0);
		assertEquals(2, testList.getFirst().intValue());
		testList.remove(1); // tar bort 3
		assertEquals(4, testList.get(1).intValue());
	}
	/**
	 * Testar remove(index) då listan har fyllts och sedan tömts.
	 */
	@Test
	public void removeByIndexWhenEmpty() {
		for (int i = 0; i < fixture.length; i++) {
			testList.insert(fixture[i], i);
		}
		testList.clear();
		try {
			testList.remove(0);
			fail("Expected: ListIsEmptyException");
		} catch (ListIsEmptyException e) {
			assertNotNull("Expected: ListIsEmptyException!");
		}
	}
} // end class
