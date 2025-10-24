
public class DizzyTurtle extends RaceTurtle {
	private int nbr;
	private int dizziness;
	
	public DizzyTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		this.nbr = nbr;
		dizziness = rand.nextInt(5) + 1;
		
	}
	
	public void raceStep() {
		int n = rand.nextInt(2);
		if (n==0) n = -1;
		left(n*dizziness);
		super.raceStep();
	}
	
	public int getDizziness() {
		return dizziness;
	}
	
	public String toString() {
		return "Nummer : " + nbr + " - DizzyTurtle (Yrsel: " + dizziness + ")";
	}

}
