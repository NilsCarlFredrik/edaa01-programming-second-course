package test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String hej = "hej ";
		String hejRep = hej.repeat(2);
		System.out.println(hejRep);
		String[] asdf = new String[6];
		asdf[0] = "hej";
		asdf[1] = "Hejsan";
		asdf[2] = "dsaf";
		asdf[3] = "fdsaffd";
		asdf[4] = "fdsfdsfbs";
		asdf[5] = "sdagfdsfd";
		
		StringBuilder sb = new StringBuilder();
		String a = " ";
		for (String str : asdf ) {
			sb.append(str);
			sb.append(a.repeat(15-str.length()));
		}
		
		System.out.println(sb.toString());
		
		System.out.println((int) Math.log10(12));
	}

}
