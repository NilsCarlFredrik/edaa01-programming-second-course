import java.util.Random;

public class RaceTurtle extends Turtle {
	private int nbr;
	public static Random rand = new Random();
	/**
	 * Skapar en sköldpadda som skall springa i fönstret w och som har start-
	 * nummer nbr. Sköldpaddan startar med pennan nere och nosen vänd åt höger.
	 */
	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		penDown();
		left(-90);
	}

	/**
	 * Låter sköldpaddan gå framåt ett steg. Stegets längd ges v ett
	 * sluptal (heltal) mellan 1 och 6.
	 */
	public void raceStep() {
		forward(rand.nextInt(6) + 1);
	}
	
	/**
	 * Returnerar en läsbar representation av denna RaceTurtle
	 * på formen "Nummer x" där x är sköldpaddans startnummer.
	 */
	public String toString(){
		return "Nummer " + nbr;
	}
}
