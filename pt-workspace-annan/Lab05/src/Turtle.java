import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private double x;
	private double y;
	private SimpleWindow w;
	private double alpha = 90;
	private boolean isPenDown = false;
	

	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		this.x = (double) x;
		this.y = (double) y;
		this.w = w;
	}

	/** Sänker pennan. */
	public void penDown() {
		isPenDown = true;

	}
	
	/** Lyfter pennan. */
	public void penUp() {
		isPenDown = false;
		
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.moveTo(getX(),getY());
		this.x = x + n * Math.cos(Math.toRadians(alpha));
		this.y = y - n * Math.sin(Math.toRadians(alpha));
		if (isPenDown) w.lineTo(getX(), getY());

	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		this.alpha += beta;
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		this.alpha = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(this.x);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(this.y);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return (int) Math.round(this.alpha);
	}
}
