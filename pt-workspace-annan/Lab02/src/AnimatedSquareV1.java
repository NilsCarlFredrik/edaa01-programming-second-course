import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class AnimatedSquareV1 {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "AnimatedSquareV1");
		Square sq = new Square(250, 250, 100);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int sqX = sq.getX();
			int sqY = sq.getY();
			int mX = w.getMouseX();
			int mY = w.getMouseY();
			while (mX != sq.getX() && mY != sq.getY()) {
				int dx = (mX - sqX) / 15;
				int dy = (mY - sqY) / 15;
				sq.erase(w);
				if (Math.abs(dx) > Math.abs(mX - sq.getX()) || Math.abs(dy) > Math.abs(mY - sq.getY())) {
					sq.move(mX - sq.getX(), mY - sq.getY());
				} else {
					sq.move(dx, dy);
				}
				sq.draw(w);
				SimpleWindow.delay(10);
			}
		}
	}
}
