package sudoku;

import javax.swing.Jbutton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class SudokuController {

	public SudokuController(Sudoku sudoku) {
		SwingUtilities.invokeLater(() -> 
				createWindow(sudoku, "Sudoky", 500, 500));
	}
}

private void createWindow(Sudoku sudoku, String title, 
							int width, int height) {
	
	JFrame frame = new JFrame(title);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}