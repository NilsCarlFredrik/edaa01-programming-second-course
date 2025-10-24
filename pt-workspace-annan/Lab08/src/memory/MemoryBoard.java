package memory;
import java.util.Random;
import pair.*;


public class MemoryBoard {
	private int size;
	Random rand = new Random();
	MemoryCardImage[][] board;
	boolean[][] boardLog;
	
	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		board = new MemoryCardImage[size][size];
		boardLog = new boolean[size][size];
		this.size = size;
		createCardsV2(backFileName, frontFileNames);

	}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {
		MemoryCardImage[] cards = new MemoryCardImage[size*size/2];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new MemoryCardImage(frontFileNames[i], backFileName);
			int n = 0;
			while (n < 2) {
				int r = rand.nextInt(size);
				int c = rand.nextInt(size);
				if (board[r][c] == null) {
					board[r][c] = cards[i];
					n++;
				}
			}
		}
	}
	
	private void createCardsV2(String backFileName, String[] frontFileNames) {
		MemoryCardImage[] cards = new MemoryCardImage[size*size/2];
		PairSequence cardLoc = new PairSequence(size, size);
		for (int i = 0; i < cards.length; i++) {
			cards[i] = new MemoryCardImage(frontFileNames[i], backFileName);
			for (int j = 0; j < 2; j++){
				Pair p = cardLoc.pick();
				board[p.first()][p.second()] = cards[i];
			}
			
			
		}
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		return board[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if (boardLog[r][c]) {
			boardLog[r][c] = false;
		} else boardLog[r][c] = true;

	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return boardLog[r][c];
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		return board[r1][c2] == board[r2][c2];
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for (int i = 0; i < boardLog.length; i++) {
			for (int j = 0; j < boardLog[i].length; j++) {
				if (!boardLog[i][j]) return false;
			}
		}
		return true;
	}	
}
