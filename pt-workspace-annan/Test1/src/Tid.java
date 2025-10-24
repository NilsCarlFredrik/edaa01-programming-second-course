import java.util.Scanner;

public class Tid {

	public static void main(String[] args) {
		String h = "";
		System.out.println("Skriv starttid [hh mm]: ");
		Scanner scan = new Scanner(System.in);
		int startH = scan.nextInt();
		int startM = scan.nextInt();
		System.out.println("Skriv sluttid [hh mm]: ");
		int slutH = scan.nextInt();
		int slutM = scan.nextInt();
		int diff = slutH * 60 + slutM - (startH * 60 + startM);
		//System.out.println("Tidskillnaden är " + diff + " minuter");
		int diffH = diff / 60;
		int diffM = diff % 60;
		if (diffH == 1) {
			h = " timme";
		} else {
			h = " timmar";
		}
		System.out.println("Tidskillnaden är " + diffH + h + " och " + diffM + " minuter.");
	}

}
