import java.util.Random;
import pair.*;
import memory.*;

public class kiss {
	private Random rand = new Random();
	
	public static void main(String[] args) {
		testBoard();
		
	}
	
	private static void testLength() {
		int[] a = null;
		System.out.println(a.length);
	}
	
	private static void testDivision() {
		int a = 5;
		int b = 2;
		System.out.println(a/(double)b);
	}
	
	private static void testRandom() {
		for (int i = 0; i < 100; i++) System.out.println(rand.nextInt(1));
	}
	
	private static void testBoolean() {
		boolean[] bajs = new boolean[5];
		for (int i = 0; i < bajs.length; i++) System.out.println(bajs[i]);
	}
	
	private static void testBoard() {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		
		MemoryBoard board = new MemoryBoard(4, "back.jpg", frontFileNames);
		System.out.println(board);
		
	}
	
}
