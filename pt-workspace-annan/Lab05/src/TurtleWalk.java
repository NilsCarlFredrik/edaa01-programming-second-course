import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class TurtleWalk {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleWalk");
		Turtle t = new Turtle(w, 300, 300);
		Random rand = new Random();
		t.penDown();
		
		for (int i = 0; i<1000; i++) {
			t.forward(1 + rand.nextInt(10));
			t.left(rand.nextInt(361) - 180);
			SimpleWindow.delay(10);
		}

	}

}
