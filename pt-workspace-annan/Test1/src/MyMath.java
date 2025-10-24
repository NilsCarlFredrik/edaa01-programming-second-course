
public class MyMath {
	
	public int factorial(int n) {
		int fact = 1;
		if (n == 0) return fact;
		else if (n > 0) {
			for(int i = 1; i <= n; i++) {
				fact *= i;
			}
			return fact;
		}
		
	}
}
