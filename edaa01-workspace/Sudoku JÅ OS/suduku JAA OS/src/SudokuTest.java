import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SudokuTest {
	private SudokuSolver solver;

	@BeforeEach
	void setUp() throws Exception {
		solver = new SudokuSolve();
	}

	@AfterEach
	void tearDown() throws Exception {
		solver = null;
	}

	@Test
	void testEmpty() {
		assertTrue(solver.isAllValid(), "Unvalid empty");
		assertTrue(solver.solve(), "Cant solve");
		assertTrue(solver.isAllValid(), "Not valid solution");
	}
	
	@Test
	void testUnsolvableTypeOne() {
		solver.setNumber(0, 0, 5);
		solver.setNumber(0, 3, 5);
		assertFalse(solver.solve(), "Dont return false");
		solver.clear();
		solver.setNumber(0, 0, 5);
		solver.setNumber(3, 0, 5);
		assertFalse(solver.solve(), "Dont return false");
		solver.setNumber(0, 0, 5);
		solver.setNumber(2, 2, 5);
		assertFalse(solver.solve(), "Dont return false");
	}
	
	@Test 
	void testUnsolvableTypeTow() {
		solver.setNumber(0, 0, 1);
		solver.setNumber(0, 1, 2);
		solver.setNumber(0, 2, 3);
		solver.setNumber(1, 0, 4);
		solver.setNumber(1, 1, 5);
		solver.setNumber(1, 2, 6);
		solver.setNumber(2, 3, 7);
		assertFalse(solver.solve(), "dont return false");
		solver.clearNumber(2, 3);
		assertTrue(solver.solve(), "Dont solve");
		assertTrue(solver.isAllValid(), "Not valid solution");
	}
	
	@Test 
	void testClear() {
		solver.setNumber(0, 0, 5);
		solver.setNumber(0, 3, 5);
		assertFalse(solver.solve(), "dont return false");
		solver.clear();
		assertTrue(solver.solve(), "Dont solve");
	}
	
	@Test
	void testThrows() {
		assertThrows(IllegalArgumentException.class, () -> solver.setNumber(3, 3, -1));
	}
}
