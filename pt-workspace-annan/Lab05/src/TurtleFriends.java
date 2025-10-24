import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class TurtleFriends {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleWalk");
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		Random rand = new Random();
		t1.penDown();
		t2.penDown();
		
		while (Math.sqrt(Math.pow(t1.getX()-t2.getX(),2) + Math.pow(t1.getY() -t2.getY(), 2)) >= 50){
			t1.forward(1 + rand.nextInt(10));
			t1.left(rand.nextInt(361) - 180);
			t2.forward(1 + rand.nextInt(10));
			t2.left(rand.nextInt(361) - 180);
			SimpleWindow.delay(1);
		}

	}

}
