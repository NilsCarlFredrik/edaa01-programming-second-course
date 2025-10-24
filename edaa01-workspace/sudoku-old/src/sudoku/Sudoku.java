package sudoku;

public class Sudoku implements SudokuSolver {
	private int[][] grid = new int[9][9];
	
	public static void main(String[] args) {
		Sudoku test = new Sudoku();
		test.setNumber(1, 2, 3);
		test.printMatrix();
		test.solve();
		System.out.println(test.isAllValid());
		
		int[][] asdf = { 
				  {3, 1, 6, 5, 7, 8, 4, 9, 2},
		          {5, 2, 9, 1, 3, 4, 7, 6, 8},
		          {4, 8, 7, 6, 2, 9, 5, 3, 1},
		          {2, 6, 3, 4, 1, 5, 9, 8, 7},
		          {9, 7, 4, 8, 6, 3, 1, 2, 5},
		          {8, 5, 1, 7, 9, 2, 6, 4, 3},
		          {1, 3, 8, 9, 4, 7, 2, 5, 6},
		          {6, 9, 2, 3, 5, 1, 8, 7, 4},
		          {7, 4, 5, 2, 8, 6, 3, 1, 9} };
		Sudoku test2 = new Sudoku(asdf);
		System.out.println("");
		test2.printMatrix();
		System.out.println(test2.isAllValid());
		
		int[][] qwerty = { 
				 {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
		         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
		         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
		         {0, 0, 5, 2, 0, 6, 3, 0, 0} };
		Sudoku test3 = new Sudoku(qwerty);
		test3.solve();
		System.out.println("");		
		test3.printMatrix();
		System.out.println(test3.isAllValid());
		
		int[][] zxcv = { 
				 { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
		         { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
		         { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
		         { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
		         { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
		         { 8, 5, 1, 7, 9, 2, 6, 0, 3 },
		         { 1, 3, 8, 0, 0, 7, 0, 4, 6 },
		         { 6, 9, 2, 3, 5, 1, 8, 7, 0 },
		         { 7, 4, 5, 0, 8, 6, 3, 1, 0 } };
		Sudoku test4 = new Sudoku(zxcv);
		test4.solve();
		System.out.println("test4: " + test4.isAllValid());
	}
	
	public Sudoku() {
	}
	
	public Sudoku(int[][] grid) {
		this.grid = grid;
	}

	@Override
	public void setNumber(int r, int c, int nbr) {
		grid[r][c] = nbr;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumber(int r, int c) {
		// TODO Auto-generated method stub
		return grid[r][c];
	}

	@Override
	public void clearNumber(int r, int c) {
		// TODO Auto-generated method stub
		grid[r][c] = 0;
		
	}

	@Override
	public boolean isValid(int r, int c, int nbr) {
		// TODO Auto-generated method stub
		if (!inLines(r, c, nbr) && !inBox(r, c, nbr)) {
			return true;
		}
		return false;
	}
	
	private boolean inLines(int r, int c, int nbr) {
		for (int i = 0; i < 9; i++){
			if (i!=c && grid[r][i] == nbr){
				return true;
			} 
			if (i!=r && grid[i][c] == nbr ){
				return true;
			}
		}
		return false;
	}
	
	private boolean inBox(int r, int c, int nbr) {
		
		int boxRow = (r / 3) * 3;
		int boxCol = (c / 3) * 3;
		for(int i = boxRow; i < boxRow + 3; i++) {
			for(int j = boxCol; j < boxCol + 3; j++) {
				if(i != r && j != c && grid[i][j] == nbr) {
					return true;
				}
			}
		}
		return false;
	}
	
	

	@Override
	public boolean isAllValid() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!isValid(i, j, getNumber(i, j))) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean solve() {
		// TODO Auto-generated method stub
		return solve(0,0);
	}
	
	private boolean solve(int r, int c) {

		if (r == 9) { // har vi kommit till rad 9 är vi klara (sista rutan)
			return true;
		}

		if (getNumber(r, c) == 0) {
			for (int x = 1; x <= 9; x++) {
				setNumber(r, c, x);
				if (!inLines(r, c, x) && !inBox(r, c, x)) {
					if (c != 8) {
						if (solve(r, c + 1)) {
							return true;
						}
					} else {
						if (solve(r + 1, 0)) {  
							return true;
						}
					}
				}
			}
			setNumber(r, c, 0);
			return false;

		} else {
			if (!inLines(r, c, getNumber(r, c)) && !inBox(r, c, getNumber(r, c))) {
				if (c == 8) {
					if (solve(r + 1, 0)) {
						return true;
					}
				} else {
					if (solve(r, c + 1)) {
						return true;
					}

				}
			}
		}
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				grid[i][j] = 0;
			}
		}
		
	}

	@Override
	public int[][] getMatrix() {
		// TODO Auto-generated method stub
		return grid;
	}

	@Override
	public void setMatrix(int[][] nbrs) {
		// TODO Auto-generated method stub
		grid = nbrs;
		
	}

	private void printMatrix() {
		for (int[] i : grid) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
	}
	
}

//private boolean solve(int r, int c) {
//	if (getNumber(r, c) == 0) {
//		for (int i = 1; i < 10; i++) {
//			if(isValid(r, c, i)) {
//				setNumber(r, c, i);
//				if (r == 8 && c == 8) {
//					return true;
//				} else if (r < 8) {
//					return solve(r+1, c);
//				} else { 
//					return solve(0, c+1);
//				}
//			}
//		}
//		setNumber(r, c, 0);
//		return false;
//	}
//	else if(isValid(r, c, getNumber(r, c))) {
//		if (r == 8 && c == 8) {
//			return true;
//		} else if (r < 8) {
//			return solve(r+1, c);
//		} else { 
//			return solve(0, c+1);
//		}
//	}
//	return false;
//}
