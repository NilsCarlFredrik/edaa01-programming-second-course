import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	Bank(){
		
		
	}
	
	public int addAccount(String holderName, long idNr) {
		Customer newCustomer = findHolder(idNr);
		if (newCustomer == null) {
			newCustomer = new Customer(holderName, idNr);
			if (customers.size() == 0) {
				customers.add(newCustomer);
			} else {
				for (int i = 0; i < customers.size(); i++) {
					if (newCustomer.getName().compareTo(customers.get(i).getName()) < 0) {
						customers.add(i, newCustomer);
						break;
					} else if (i == customers.size() - 1) {
						customers.add(newCustomer);
						break;
					}
				}
			}
			
		} 
		BankAccount newAccount = new BankAccount(newCustomer);
		accounts.add(newAccount);
		return newAccount.getAccountNumber();
	}
	
	public BankAccount findAccount(int accountNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				return accounts.get(i);
			}
		} return null;
	}
	
	public Customer findHolder(long idNr) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getIdNr() == idNr) {
				return customers.get(i);
			} 
		} return null;
	}
	
	public boolean removeAccount(int number) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == number) {
				accounts.remove(i);
				return true;
			}
		} return false;
	}
	
	public ArrayList<BankAccount> getAllAccounts() {
		return accounts;
	}
	
	public ArrayList<Customer> getAllCustomers() {
		return customers;
	}
	
	public BankAccount findByNumber(int accountNumber) {
		return accounts.get(0);
	}
	
	public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> holderAccounts = new ArrayList<BankAccount>();
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getHolder().getIdNr() == idNr) {
				holderAccounts.add(accounts.get(i));
			}
		}
		return holderAccounts;
	}
	
	public ArrayList<Customer> findByPartOfName(String namePart) {
		ArrayList<Customer> soughtCustomers = new ArrayList<Customer>();
		for (Customer customer : customers) {
			if (customer.getName().matches(".*(?i)"+namePart+".*")) {
				soughtCustomers.add(customer);
			}
		} return soughtCustomers;
	}
}
