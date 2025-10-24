import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a minimum and a maximum value: ");
		int min = scan.nextInt();
		int max = scan.nextInt();
		NumberToGuess n = new NumberToGuess(min, max);
		System.out.println("Guess a number: ");
		int guess = scan.nextInt();
		while (!n.isEqual(guess)) {
			if (n.isBiggerThan(guess)) System.out.println("Number too small, guess again: ");
			else System.out.println("Number too big, guess again: ");
			guess = scan.nextInt();
		}
		System.out.println("Correct!");
	}

	
}
