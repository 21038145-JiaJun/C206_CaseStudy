import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();

	}
	
	private static void launch() {
		int option = -99;
		
		while (option != 3) {
			loginMenu();
			
			option = Helper.readInt("Enter an option > ");
			
		}
	}
	
	private static void loginMenu() {
		Helper.line(80, "=");
		System.out.println("CAMPUS ONLINE AUCTION SHOP (COAS)");
		Helper.line(80, "=");
		System.out.println("1. Register a user");
		System.out.println("2. Login");
		System.out.println("3. Exit");
	}
	
}
