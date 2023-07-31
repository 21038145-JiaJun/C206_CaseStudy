//import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();

	}
	
	private static void launch() {
		int option = -99;
		
		while (option != 6) {
			mainMenu();
			
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				user();
			} else if (option == 2) {
				
			} else if (option == 3) {
				
			} else if (option == 4) {
				
			} else if (option == 5) {
				
			} else if (option == 6) {
				
			} else {
				System.out.println("Invalid option");
			}
			
		}
	}
	
	//Display the main menu options
	private static void mainMenu() {
		Helper.line(80, "=");
		System.out.println("CAMPUS ONLINE AUCTION SHOP (COAS)");
		Helper.line(80, "=");
		System.out.println("1. Maintain Users");
		System.out.println("2. Maintain Auctions");
		System.out.println("3. Maintain Items");
		System.out.println("4. Maintain Bids");
		System.out.println("5. Maintain Payments");
		System.out.println("6. Exit");
	}
	
	//================================= Option 1: Users (Cedric) =================================
	private static void user() {
		int option = -99; 
		userMenu();
		while (option != 1) {
			
		}
	}
	
	private static void userMenu() {
		Helper.line(80, "=");
		System.out.println("USER MENU");
		Helper.line(80, "=");
		System.out.println("1. Add a new user");
		System.out.println("2. View All Users");
		System.out.println("3. Delete an existing user");
		System.out.println("4. Exit");
	}
	
	//================================= Option 1-6: [Function] ([Name]) =================================
	
}
