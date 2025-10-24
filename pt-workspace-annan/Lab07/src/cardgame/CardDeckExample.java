package cardgame;

import pair.Pair;
import pair.PairSequence;

public class CardDeckExample {
	public static void main(String[] args) {
		
		// Skapa en kortlek och skriv ut alla kortens
		// värden i slumpmässig ordning
		
		PairSequence cardDeck = new PairSequence(2, 8);
		while (cardDeck.more()) {
			Pair p = cardDeck.pick();
			System.out.println(p);
		}
	}
}
