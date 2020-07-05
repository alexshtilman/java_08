package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.LinkedList;

class LinkedTest {
	int[] arrayInt = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	String[] arrayString = { "one", "two", "three" };
	LinkedList<Integer> listInt;
	LinkedList<String> listStr;

	@BeforeEach
	void setup() {
		listInt = new LinkedList<>();
		listStr = new LinkedList<>();
		for (int i = 0; i < arrayInt.length; i++) {
			listInt.add(arrayInt[i]);
		}
		for (int i = 0; i < arrayString.length; i++) {
			listStr.add(arrayString[i]);
		}
	}

	@Test
	void testAddGet() {

		assertEquals(arrayInt.length, listInt.size());
		assertEquals(arrayString.length, listStr.size());
		for (int i = 0; i < arrayInt.length; i++) {
			assertEquals(arrayInt[i], listInt.get(i));
		}
		for (int i = 0; i < arrayString.length; i++) {
			assertEquals(arrayString[i], listStr.get(i));
		}
	}

	@Test
	void testAddByIndex() {
		int[] arrayTest = { 25, 1, 35, 2, 3, 4, 5, 6, 7, 8, 45, 9 };
		assertTrue(listInt.add(0, 25));
		assertTrue(listInt.add(2, 35));
		assertTrue(listInt.add(10, 45));
		for (int i = 0; i < arrayTest.length; i++) {
			assertEquals(arrayTest[i], listInt.get(i));
		}
		assertFalse(listInt.add(-1, -1));
	}

	@Test
	void testRemoveByIndex() {
		int[] arrayTest = { 2, 3, 5, 6, 7, 8 };
		assertEquals(1, listInt.remove(0));
		assertEquals(9, listInt.remove(7));
		assertEquals(4, listInt.remove(2));
		for (int i = 0; i < arrayTest.length; i++) {
			assertEquals(arrayTest[i], listInt.get(i));
		}
		assertEquals(null, listInt.remove(-1));
	}

}
