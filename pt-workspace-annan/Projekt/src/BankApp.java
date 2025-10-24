import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {
	private static Scanner scan = new Scanner(System.in);
	private static Bank b = new Bank();
	private static boolean running = true;
	
	public static void main(String[] args) {
		runApp();
	}
	
	private static void runApp() {
		int choice;
		while (running) {
			printMenu();
			//try {
				choice = scan.nextInt();
				switch (choice) {
				case 1: findAccountById();
						break;
				
				case 2: findAccountByName();
						break;
				
				case 3: deposit();
						break;
						
				case 4: withdraw();
						break;
				
				case 5: transfer();
						break;
				
				case 6: createAccount();
						break;
				
				case 7: removeAccount();
						break;
						
				case 8: printAccounts();
						break;
						
				case 9: printCustomers();
						break;
				
				case 0: running = false;
				//}
			}
			
			//catch (Exception e) {
				//System.out.println(e);
			//}
		}
	}
	
	private static void printMenu() {
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("1. Hitta konto utifrån innehavare");
		System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
		System.out.println("3. Sätt in");
		System.out.println("4. Ta ut");
		System.out.println("5. Överföring");
		System.out.println("6. Skapa konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut alla konton");
		System.out.println("9. Skriv ut alla kontoinnehavare");
		System.out.println("0. Avsluta");
		System.out.println("val: ");
	}
	
	private static void findAccountById() {
		System.out.println("id: ");
		long idNr = scan.nextLong();
		ArrayList<BankAccount> holderAccounts = b.findAccountsForHolder(idNr);
		for (int i = 0; i < holderAccounts.size(); i++) {
			System.out.println(holderAccounts.get(i));
		}
	}
	
	private static void findAccountByName() {
		System.out.println("del av namn: ");
		String namePart = scan.next();
		if (b.findByPartOfName(namePart).size() == 0) {
			System.out.println("Det finns inga användare som matchar sökningen");
		} else {
			for (Customer customer : b.findByPartOfName(namePart)) {
				System.out.println(customer.toString());
			}
		}
		
	}
	
	private static void deposit() {
		System.out.println("konto: ");
		int accountNr = scan.nextInt();
		System.out.println("summa: ");
		long amount = scan.nextLong();
		BankAccount account = b.findAccount(accountNr);
		if (account == null) {
			System.out.println("kontot finns inte");
		} else {
			account.deposit(amount);
			System.out.println(amount + "kr insatt på konto " + account.getAccountNumber());
		}
		
	}
	
	private static void withdraw() {
		System.out.println("konto: ");
		int accountNr = scan.nextInt();
		BankAccount account = b.findAccount(accountNr);
		if (account == null) {
			System.out.println("kontot finns inte");
			return;
		} 
		System.out.println("summa: ");
		long amount = scan.nextLong();
		if (amount > account.getAmount()) {
			System.out.println("uttag misslyckades, endast " + account.getAmount() + " på kontot.");
			return;
		}
		account.withdraw(amount);
		System.out.println(amount + "kr uttaget från konto " + account.getAccountNumber());
		
	}
	
	private static void transfer() {
		System.out.println("från konto: ");
		int fromAccountNr = scan.nextInt();
		BankAccount fromAccount = b.findAccount(fromAccountNr);
		if (fromAccount == null) {
			System.out.println("kontot finns inte");
			return;
		}
		System.out.println("till konto: ");
		int toAccountNr = scan.nextInt();
		BankAccount toAccount = b.findAccount(toAccountNr);
		if (toAccount == null) {
			System.out.println("kontot finns inte");
			return;
		}
		System.out.println("summa: ");
		long amount = scan.nextLong();
		if (amount > fromAccount.getAmount()) {
			System.out.println("överföring misslyckades, endast " + fromAccount.getAmount() + " på kontot");
			return;
		}
		fromAccount.withdraw(amount);
		toAccount.deposit(amount);
		System.out.println(amount + "kr överfört från konto " + fromAccount.getAccountNumber() + "till konto " + toAccount.getAccountNumber());
		
	}
	
	
	private static void createAccount() {
		System.out.println("id: ");
		long id = scan.nextLong();
		scan.nextLine();
		System.out.println("namn: ");
		String name = scan.nextLine();
		int accountNr = b.addAccount(name, id);
		System.out.println("konto skapat: " + accountNr);
	}
	
	private static void removeAccount() {
		System.out.println("kontonummer: ");
		int account = scan.nextInt();
		if (b.removeAccount(account)) System.out.println("Kontot borttaget");
		else System.out.println("Detta kontot finns inte");
		
	}
	
	private static void printAccounts() {
		for (int i = 0; i < b.getAllAccounts().size(); i++) {
			System.out.println(b.getAllAccounts().get(i).toString());
		}
		
	}
	
	private static void printCustomers() {
		System.out.println(b.getAllCustomers().size());
		for (int i = 0; i < b.getAllCustomers().size(); i++) {
			System.out.println(b.getAllCustomers().get(i).toString());
		}
	}
	

}






















