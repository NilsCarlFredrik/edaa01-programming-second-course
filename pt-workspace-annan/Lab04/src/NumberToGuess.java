import java.util.Random;

public class NumberToGuess {
	private int min;
	private int max;
	private int number;
	
	
	/** Skapar ett objekt med ett slumpmässigt valt heltal i 
	    intervallet [min, max]. */
	public NumberToGuess(int min, int max) {
		this.min = min;
		this.max = max;
		this.number = new Random().nextInt(max-min+1) + min;
		
	}

	/** Tag reda på minsta möjliga värde talet kan ha. */
	public int getMin() {
		return this.min;
	}

	/** Tag reda på största möjliga värde talet kan ha. */
	public int getMax() {
		return this.max;
	}

	/** Tar reda på om talet är lika med guess. */
	public boolean isEqual(int guess) {
		return guess == this.number;
	}

	/** Tar reda på om talet är större än guess. */
	public boolean isBiggerThan(int guess) {
		return guess < this.number;
	}
}
