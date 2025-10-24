
public class MoleTurtle extends RaceTurtle {
	private int nbr;
	
	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		this.nbr = nbr;
	}
	
	public void raceStep() {
		if (rand.nextBoolean()) penDown();
		else penUp();
		super.raceStep();
	}
	
	public String toString() {
		return "Nummer : " + nbr + " - MoleTurtle";
	}
}
