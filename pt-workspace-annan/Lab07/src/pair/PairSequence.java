package pair;

import java.util.Random;


public class PairSequence {
	private int n;
	private Pair[] pairs;
	private static Random rand = new Random();
	
	
	/** Skapar en sekvens av alla talpar (a,b) sådana att
	    0 <= a < rows  och  0 <= b < cols */
	public PairSequence(int rows, int cols) {
		n = rows * cols;
		pairs = new Pair[n];
		int m = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				pairs[m] = new Pair(i,j);
				m++;
			}
		}
		
	}

	/** Undersöker om det finns fler par i sekvensen. */
	public boolean more() {
		if (pairs == null) {
			return false;
		}
		return pairs.length > 0;
	}

	/** Hämtar ett slumpmässigt valt talpar ur sekvensen. Sekvensen
    	blir ett element kortare. Om sekvensen är tom returneras null. */
	public Pair pick() {
		int m = rand.nextInt(n);
		Pair p = pairs[m];
		pairs[m] = pairs[n-1];
		n--;
		if (n==0) pairs = null;
		return p;
	}
}
