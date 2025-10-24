
public class AbsentMindedTurtle extends RaceTurtle{
	private int nbr;
	private int absentMindedness;
	
	public AbsentMindedTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		this.nbr = nbr;
		absentMindedness = rand.nextInt(100) + 1;
		
	}
	
	public void raceStep() {
		if (rand.nextInt(100) < absentMindedness) {
			return;
		} else {
			super.raceStep();
		} 
	}
	
	public int getAbsentMindedness() {
		return absentMindedness;
	}
	
	public String toString() {
		return "Nummer : " + nbr + " - AbsentMindedTurtle (" + absentMindedness + "% Frånvarande)";
	}

}
