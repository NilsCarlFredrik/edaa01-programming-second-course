import java.util.Arrays;

public class SudokuSolve implements SudokuSolver {

	private int[][] grid;
	
	/**
	 * Creates a SudokuSolve object with a 9x9 grid. 
	 */
	public SudokuSolve() {
		grid = new int[9][9];
	}

	/**
	 * Sets the number nbr in box r, c.
	 * 
	 * @param r
	 *            The row
	 * @param c
	 *            The column
	 * @param nbr
	 *            The number to insert in box r, c
	 * @throws IllegalArgumentException        
	 *             if r or c is outside [0..8] or
	 *             nbr is outside [1..9] 
	 */
	@Override
	public void setNumber(int r, int c, int nbr) {
		if (r > 8 || r < 0 || c > 8 || c < 0 || nbr > 9 || nbr < 1) {
			throw new IllegalArgumentException();
		}
		grid[r][c] = nbr;
	}

	/**
	 * Returns the number in box r,c. If the box i empty 0 is returned.
	 * 
	 * @param r
	 *            The row
	 * @param c
	 *            The column
	 * @param number
	 *            The number to insert in r, c
	 * @return the number in box r,c or 0 if the box is empty.
	 * @throws IllegalArgumentException
	 *             if r or c is outside [0..8]
	 */
	@Override
	public int getNumber(int r, int c) {
		if (r > 8 || r < 0 || c > 8 || c < 0) {
			throw new IllegalArgumentException();
		}
		return grid[r][c];
	}
	
	/**
	 * Removes the number in box r, c.
	 * 
	 * @param r
	 *            The row
	 * @param c
	 *            The column
	 * @throws IllegalArgumentException
	 *             if r or c is outside [0..8]
	 */
	@Override
	public void clearNumber(int r, int c) {
		if (r > 8 || r < 0 || c > 8 || c < 0) {
			throw new IllegalArgumentException();
		}
		grid[r][c] = 0;
	}
	
	/**
	 * Checks if the nbr in box r, c fulfill the sudoku rules.
	 * 
	 * @param r
	 *            The row
	 * @param c
	 *            The column
	 * @param number
	 *            The number to check for in r, c
	 * @return true if the nbr is valid, otherwise false
	 * @throws IllegalArgumentException
	 *             if r or c is outside [0..8] or
	 *             nbr is outside [1..9] 
	 */
	@Override
	public boolean isValid(int r, int c, int nbr) {
		if (r > 8 || r < 0 || c > 8 || c < 0 || nbr > 9 || nbr < 1) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < 9; i++) {
			if (grid[i][c] == nbr){
				if (!(i == r)) {
					return false;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (grid[r][i] == nbr){
				if (!(i == c)) {
					return false;
				}
			}
		}

		int rSquare = r / 3;
		int cSquare = c / 3;

		for (int i = rSquare * 3; i < rSquare * 3 + 3; i++) {
			for (int j = cSquare * 3; j < cSquare * 3 + 3; j++) {
				if (grid[i][j] == nbr) {
					if (!(i == r && j == c)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Checks if all the nbr in the grid fulfills the sudoku rules.
	 * 
	 * @return true if all the nbrs in the grid are valid, otherwise false
	 */
	@Override
	public boolean isAllValid() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int nbr = grid[i][j];
				if (nbr != 0 && !isValid(i, j, nbr)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Tries to solve the sudoku in the grid (fills the grid with valid nbrs). 
	 * 
	 * @return true if the sudoku was solved, otherwise false
	 */
	@Override
	public boolean solve() {
		if(!isAllValid()) {
			return false;
		}
		return solve(0, 0);
	}

	private boolean solve(int r, int c) {
		if (r == 8 && c == 9) {
			return true;
		}
		if (c == 9) {
			r++;
			c = 0;
		}
		if (grid[r][c] != 0) {
			return solve(r, c + 1);
		}
		for (int n = 1; n < 10; n++) {
			if (isValid(r, c, n)) {
				grid[r][c] = n;

				if (solve(r, c + 1)) {
					return true;
				}
			}
		}
		grid[r][c] = 0;
		return false;
	}

	/**
	 * Empties the grid.
	 * 
	 */
	@Override
	public void clear() {
		for (int i = 0; i < 9; i++) {
			Arrays.fill(grid[i], 0);
		}
	}
	
	/**
	 * Returns the numbers in the grid. An empty box i represented
	 * by the value 0.
	 * 
	 * @return the numbers in the grid
	 */
	@Override
	public int[][] getMatrix() {
		int[][] temp = new int[9][9];
		for(int i = 0; i < 9; i++) {
			temp[i] = grid[i].clone();
		}
		return temp;
	}

	/**
	 * Fills the grid with the numbers in nbrs.
	 * 
	 * @param nbrs the matrix with the numbers to insert
	 * @throws IllegalArgumentException
	 *             if nbrs have wrong dimension or containing values not in [0..9] 
	 */
	@Override
	public void setMatrix(int[][] nbrs) {
		if (nbrs[0].length != grid[0].length || nbrs.length != nbrs.length) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (nbrs[i][j] < 0 || nbrs[i][j] > 9) {
					throw new IllegalArgumentException();
				}
				grid[i][j] = nbrs[i][j];
			}
		}
	}

}
