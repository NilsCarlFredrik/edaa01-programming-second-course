import java.util.ArrayList;

public class Bajsbajs {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("bajs");
		strings.add("kiss");
		strings.add(1, "röv");
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
		

	}

}
