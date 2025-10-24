import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Sudoku {

	public Sudoku(SudokuSolver solver) {
		SwingUtilities.invokeLater(() -> createWindow(solver, "Sudoku Solver"));
	}

	private void createWindow(SudokuSolver solver, String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 50));
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		JButton solve = new JButton("Solve");
		JButton clear = new JButton("Clear");
		solve.setFont(font1);
		clear.setFont(font1);
		panel.add(solve);
		panel.add(clear);
		pane.add(panel, BorderLayout.SOUTH);

		GridLayout grid = new GridLayout(9, 9, 2, 2);
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(grid);
		
		Color ourColor = new Color(255,255,155);
		Font font2 = new Font("SansSerif", Font.BOLD, 40);

		JTextField[][] textFields = new JTextField[9][9];
		for (int i = 0; i < textFields.length; i++) {
			for (int j = 0; j < textFields[i].length; j++) {
				textFields[i][j] = new JTextField();
				textFields[i][j].setPreferredSize(new Dimension(60, 60));
				textFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				textFields[i][j].setFont(font2);
				if ((i < 3 || i > 5) && (j < 3 || j > 5) || (i < 6 && i > 2) && (j < 6 && j > 2)) {
					textFields[i][j].setBackground(ourColor);
				}

				gridPanel.add(textFields[i][j]);
			}
		}
		pane.add(gridPanel, BorderLayout.NORTH);

		solve.addActionListener(e -> {
			int[][] nbrs = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (!textFields[i][j].getText().equals("")) {
						try {
						nbrs[i][j] = Integer.parseInt(textFields[i][j].getText());
						}
						catch(Exception NumberFormatException) {
							JOptionPane.showMessageDialog(frame, "Månste vara heltal 1-9");
							return;
						}
					}
				}
			}
			try {
				solver.setMatrix(nbrs);
			} catch (Exception IllegalArgumentException) {
				JOptionPane.showMessageDialog(frame, "Månste vara heltal 1-9");
				return;
			}
			if (!solver.isAllValid()) {
				JOptionPane.showMessageDialog(frame, "Det finns ingen lösning!");
			} else {
				if (!solver.solve()) {
					JOptionPane.showMessageDialog(frame, "Det finns ingen lösning!");
				} else {

					nbrs = solver.getMatrix();
					for (int i = 0; i < 9; i++) {
						for (int j = 0; j < 9; j++) {
							textFields[i][j].setText("" + nbrs[i][j]);
						}
					}
				}
			}
		});

		clear.addActionListener(e -> {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					textFields[i][j].setText("");
				}
			}
			solver.clear();
		});

		frame.pack();
		frame.setVisible(true);
	}

}
