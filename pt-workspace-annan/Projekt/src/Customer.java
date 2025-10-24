

public class Customer {
	private String name;
	private long idNr;
	private int customerNr;
	private static int nextId = 101;
	
	/**
	 * Skapar en kund (kontoinnehavare) med namnet 'name' och id-nummer 'idNr'.
	 * Kunden tilldelas ochså ett unikt kundnummer.
	 */
	
	Customer (String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		this.customerNr = nextId;
		nextId++;
		
	}
	
	public String getName() {
		return name;
	}

	public long getIdNr() {
		return idNr;
	}
	
	public int getCustomerNr() {
		return customerNr;
	}
	
	public String toString() {
		return name + ", id " + idNr + ", kundnr " + customerNr;
	}
}

