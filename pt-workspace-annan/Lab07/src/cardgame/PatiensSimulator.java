package cardgame;

import pair.*;

public class PatiensSimulator {
	private static final int NBR_ITERATIONS = 1000000;
	private static int nbr_completed = 0;
	private static PairSequence deck;
	
	public static void main(String[] args) {
		for (int i = 0; i < NBR_ITERATIONS; i++) {
			deck = new PairSequence(4, 13);
			if (patiens123()) {
				nbr_completed++;
			}
		}
		System.out.println(nbr_completed/(double)NBR_ITERATIONS);

	}
	
	private static boolean patiens123(){
		int n = 0;
		while (deck.more()) {
			Pair p = deck.pick();
			if (p.second() == n) {
				return false;
			} if (n == 2) {
				n = 0;
			} else {
				n++;
			}
		}
		return true;
	}

}
