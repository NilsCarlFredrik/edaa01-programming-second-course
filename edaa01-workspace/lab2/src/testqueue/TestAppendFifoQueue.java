package testqueue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

//import java.util.*;

class TestAppendFifoQueue {
	private FifoQueue<Integer> intQueueA, intQueueB;
	
	@BeforeEach
	void setUp() throws Exception {
		intQueueA = new FifoQueue<Integer>(); 
		intQueueB = new FifoQueue<Integer>();
	}

	@AfterEach
	void tearDown() throws Exception {
		intQueueA = null;
		intQueueB = null;
	}

	/*
	 * Test appending empty to empty queue
	 */
	@Test
	void testEmpty() {
		assertTrue(intQueueA.isEmpty(), "Wrong result from empty of queue");
		assertTrue(intQueueB.isEmpty(), "Wrong result from empty of queue");
		intQueueA.append(intQueueB);
	}
	
	/*
	 * Test appending empty to non empty queue
	 */
	@Test
	void testAppendEmpty() {
		intQueueA.offer(2);
		intQueueA.offer(4);
		intQueueA.offer(6);
		intQueueA.append(intQueueB);
		for (int i = 1 ; i <= 3; i++) {
			assertEquals(2*i, intQueueA.poll(), "Poll returns incorrect element" );
		}
		
	}
	
	/*
	 * Test appending non empty to empty queue
	 */
	@Test
	void testAppendToEmpty() {
		intQueueA.offer(2);
		intQueueA.offer(4);
		intQueueA.offer(6);
		intQueueB.append(intQueueA);
		for (int i = 1 ; i <= 3; i++) {
			assertEquals(2*i, intQueueB.poll(), "Poll returns incorrect element" );
		}
	}
	
	/*
	 * Test appending non empty to non empty queue
	 */
	@Test
	void testAppend() {
		intQueueA.offer(2);
		intQueueA.offer(4);
		intQueueA.offer(6);
		intQueueB.offer(8);
		intQueueB.offer(10);
		intQueueB.offer(12);
		intQueueA.append(intQueueB);
		assertEquals(6, intQueueA.size(), "Wrong size of queue");
		assertTrue(intQueueB.isEmpty(), "Appended queue not empty");
		for (int i = 1 ; i <= 3; i++) {
			assertEquals(2*i, intQueueA.poll(), "Poll returns incorrect element" );
		}
	}
	
	/*
	 * Test appending queue to itself
	 */
	@Test
	void testAppendSelf() {
		assertThrows(IllegalArgumentException.class, () -> {
			intQueueA.append(intQueueA);
		    });
	}

}
