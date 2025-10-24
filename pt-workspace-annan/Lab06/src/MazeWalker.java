import java.util.Scanner;

import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a maze (1-5): ");
		int nr = scan.nextInt();
		
		SimpleWindow w = new SimpleWindow(370, 370, "Mazewalker");
		Maze m = new Maze(nr);
		m.draw(w);
		Turtle t = new Turtle(w, m.getXEntry(), m.getYEntry());
		t.penDown();
		int n = 0;
		while (!m.atExit(t.getX(), t.getY())) {
			if (m.wallAtLeft(t.getDirection(), t.getX(), t.getY())){
				if (m.wallInFront(t.getDirection(), t.getX(), t.getY())){
					t.left(-90);
					t.forward(1);	
				} else t.forward(1);
			} else {
				t.left(90);
				t.forward(1);
			} 
			n++;
			SimpleWindow.delay(1);
		}
		System.out.println("Antal steg: " + n);
	}

}
