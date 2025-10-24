package mountain;

public class Side {
	public Point a, b;
	
	public Side(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public boolean equals(Object side) {
		Side s = (Side) side;
		if(a == s.a && b == s.b || a == s.b && b == s.a) {
			return true;
		} else {
		return false;
		}
	}
	
	@Override
	public int hashCode() {
		return a.hashCode() + b.hashCode();
	}
}
