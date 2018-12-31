package sjsu.Singh.cs146.project1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CircularLinkedListTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsSurvivor() {
		CircularLinkedList prisoners = new CircularLinkedList();
		assertEquals(1, prisoners.isSurvivor(6, 2));
		assertEquals(1, prisoners.isSurvivor(1, 9));
		assertEquals(4, prisoners.isSurvivor(7, 7));
		assertEquals(2, prisoners.isSurvivor(12, 8));
		assertEquals(3, prisoners.isSurvivor(5, 1));
	}

	@Test
	public void testMain() {
		  CircularLinkedList prisoners=new CircularLinkedList();

	      assertTrue(prisoners.isEmpty()); //before inserting, list is empty

	      assertEquals(0, prisoners.size); // Size is 0

	      prisoners.insert(5);

	      assertFalse(prisoners.isEmpty()); // after inserting element, list is not empty

	     assertEquals(1,prisoners.size); //size is 1
	}

}
