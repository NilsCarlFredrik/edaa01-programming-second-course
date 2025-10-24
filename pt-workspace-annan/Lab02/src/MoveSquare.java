import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class MoveSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "MoveSquare");
		Square sq = new Square(250, 250, 100);
		while (true){
			w.waitForMouseClick();
			sq.erase(w);
			int dx = w.getMouseX() - sq.getX() - sq.getSide()/2;
			int dy = w.getMouseY() - sq.getY() - sq.getSide()/2;
			sq.move(dx, dy);
			sq.draw(w);
		}
	}
}
