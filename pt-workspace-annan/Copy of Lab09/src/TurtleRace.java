import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {
	private static Random rand = new Random();

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		//RaceTurtle[] r = new RaceTurtle[8];
		ArrayList<RaceTurtle> r = new ArrayList<RaceTurtle>();
		RaceTurtle[] winners = new RaceTurtle[8];
		int n = 0;
		for (int i = 0; i < 8; i++) {
			r.add(createTurtle(rand.nextInt(4), w, i+1));
		} 
		while(winners[7] == null) {
			for (int i = 0; i < r.size(); i++) {
				if (r.get(i).getX() >= RaceWindow.X_END_POS) {
					winners[n] = r.remove(i);
					n++;
				} else r.get(i).raceStep();
			} RaceWindow.delay(10);
			
		} for (int i = 0; i < 8; i++)System.out.println("På plats " + (i+1)+ " : " + winners[i]);
		

	}
	
	private static RaceTurtle createTurtle(int type, RaceWindow w, int nbr) {
		if (type == 0) return new RaceTurtle(w, nbr);
		if (type == 1) return new MoleTurtle(w, nbr);
		if (type == 2) return new AbsentMindedTurtle(w, nbr);
		else return new DizzyTurtle(w, nbr);
	}

}
