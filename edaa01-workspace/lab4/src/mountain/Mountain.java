package mountain;

import fractal.*;
import java.util.HashMap;

public class Mountain extends Fractal {
	private Point a,b,c;
	private double dev;
	private int random;
	HashMap<Side, Point> sideMap= new HashMap<>();
	
	
	public Mountain(Point a, Point b, Point c, double dev) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
	}

	@Override
	public String getTitle() {
		return "Mountain";
	}

	@Override
	public void draw(TurtleGraphics turtle) {
		turtle.penDown();
		fractalTriangle(turtle, order, a, b, c, dev);
		turtle.penUp();
	}
	
	private void fractalTriangle(TurtleGraphics turtle, int order, Point A, Point B, Point C, double dev) {
		
		if (order == 0) {
			turtle.moveTo(A.getX(), A.getY());
			turtle.forwardTo(B.getX(), B.getY());
			turtle.forwardTo(C.getX(), C.getY());
			turtle.forwardTo(A.getX(), A.getY());
		} else {
			random = (int)RandomUtilities.randFunc(dev);
			Point a = newMidPoint(B,C);
			Point b = newMidPoint(A,C);
			Point c = newMidPoint(A,B);
			fractalTriangle(turtle, order - 1, A, b, c, dev/2);
			fractalTriangle(turtle, order - 1, a, B, c, dev/2);
			fractalTriangle(turtle, order - 1, a, b, C, dev/2);
			fractalTriangle(turtle, order -1, a, b, c, dev/2);
		}
	}
	
	private Point newMidPoint(Point a, Point b) {
		Side newSide = new Side(a,b);
		if(sideMap.containsKey(newSide)) {
			return sideMap.remove(newSide);
		} else {
			int x = a.getX() + (b.getX() - a.getX()) / 2;
			int y = (int) ((a.getY() + (b.getY() - a.getY()) / 2) + random);
			Point newPoint = new Point(x,y);
			sideMap.put(newSide, newPoint);
			
			return (newPoint);
		}
	}

}
