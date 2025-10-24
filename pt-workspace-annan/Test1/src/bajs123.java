import java.util.Random;
import java.util.Scanner;

public class bajs123 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		/*
		int b = Integer.MIN_VALUE;
		while (scan.hasNextInt()) {
			int a = scan.nextInt();
			if (a > b) {
				b = a;
			}
		}
		System.out.println(b);
		*/
		
		/* 
		int bigSum = 0;
		int smallSum = 0;
		int limit = scan.nextInt();
		for (int i = 1; i <= 10; i++){
			int n = scan.nextInt();
			if (n < limit) smallSum += n;
			else if (n > limit) bigSum += n; 
		}
		System.out.println(bigSum + "  " + smallSum); 
		*/
		
		/* 
		int dag = 1;
		int lon = 1;
		while (lon < 1000000){
			lon *= 2;
			dag += 1;
		}
		System.out.println("Antal dagar: " + dag); 
		*/
		
		/*
		Random rand = new Random();
		int r1 = 1 + rand.nextInt(99);
		int r2 = 1 + rand.nextInt(99);
		if (r1 < r2) System.out.println(r1 + " " + r2);
		else System.out.println(r2 + " " + r1);
		*/
		
		/*
		long a = Long.MAX_VALUE;
		System.out.println(a);
		while (a != 1) {
			if (a % 2 == 0) a = a/2;
			else a = 3*a +1;
			System.out.println(a);
		}
		*/
		
		
		
		
		
	}

}
