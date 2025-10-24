package cardreader;


public class UserTest {

	public static void main(String[] args) {
		
		UserTable ut = new UserTable();
		
		
		User u1 = ut.find(24073);
		User u2 = ut.find(24074);
		User u3 = ut.findByName("Jens Holmgren");
		User u4 = new User(1234, "Hej");
		ut.add(u4);
		
		System.out.println(u1 + " " + u2 + " " + u3 + " " + u4);
		
	}

}
