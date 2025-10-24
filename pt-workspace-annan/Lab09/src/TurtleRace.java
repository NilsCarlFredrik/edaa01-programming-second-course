
public class TurtleRace {

	public static void main(String[] args) {
		RaceWindow w = new RaceWindow();
		RaceTurtle[] r = new RaceTurtle[8];
		RaceTurtle[] winners = new RaceTurtle[3];
		int n = 0;
		for (int i = 0; i < 8; i++) {
			r[i] = new RaceTurtle(w, i+1);
		} 
		while(winners[2] == null) {
			for (int i = 0; i < 8; i++) {
				if (r[i].getX() >= RaceWindow.X_END_POS) {
					if (winners[0] != r[i] && winners[1] != r[i] && winners[2] != r[i]){
						winners[n] = r[i];
						n++;
					}
				} else r[i].raceStep();
			} RaceWindow.delay(10);
			
		} for (int i = 0; i < 3; i++)System.out.println("På plats " + (i+1)+ " : " + winners[i]);
		

	}

}
