

public class BankAccount {
	private Customer holder;
	private double amount;
	private int account;
	private static int nextId = 1001;
	
	/**
	 * Skapar ett nytt bankkonto åt en innehavare med namn 'holderName' och
	 * id 'holderId'. Kontot tilldelas ett unikt kontonummer och innehåller
	 * inledningsvis 0kr.
	 */
	
	BankAccount (String holderName, long holderId) {
		holder = new Customer(holderName, holderId);
		account = nextId;
		nextId++;
		
	}
	
	/**
	 * Skapar ett nytt bankkonto med innehavare 'holder'. Kontot tilldelas
	 * ett unikt kontonummer och innegåller inledningsvis 0kr.
	 * 
	 */
	BankAccount (Customer holderName) {
		holder = holderName;
		account = nextId;
		nextId++;
	}
	
	public Customer getHolder() {
		return holder;
	}
	
	public int getAccountNumber() {
		return account;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void deposit(double amount) {
		this.amount += amount;
	}
	
	public void withdraw(double amount) {
		this.amount -= amount;
	}
	
	public String toString() {
		return "konto " + account + " (" + holder.toString() + "): " + amount; 
	}

}
