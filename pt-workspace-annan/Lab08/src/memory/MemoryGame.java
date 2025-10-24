package memory;

import se.lth.cs.pt.window.SimpleWindow;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		
		MemoryBoard board = new MemoryBoard(4, "back.jpg", frontFileNames);
		MemoryWindow w = new MemoryWindow(board);
		int r1 = 0;
		int r2 = 0;
		int c1 = 0;
		int c2 = 0;
		int attempts = 0;
		while (!board.hasWon()) {
			int n = 0;
			while (n < 2) {
				w.drawBoard();
				w.waitForMouseClick();
				if (n == 0) {
					r1 = w.getMouseRow();
					c1 = w.getMouseCol();
				} else {
					r2 = w.getMouseRow();
					c2 = w.getMouseCol();
				}
				if (!board.frontUp(w.getMouseRow(), w.getMouseCol())) {
					board.turnCard(w.getMouseRow(), w.getMouseCol());
					if (n == 1 && board.getCard(r1, c1) != board.getCard(r2, c2)) {
						w.drawBoard();
						SimpleWindow.delay(2000);
						board.turnCard(r1, c1);
						board.turnCard(r2, c2);
					} n++;
				}
			}
			attempts++;
		}
		w.drawBoard();
		System.out.println("Du vann! Antal försök: " + attempts);
	}
}
