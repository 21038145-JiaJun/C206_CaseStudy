import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();

	}
	
	private static void launch() {
		int option = -99;
		
		while (option != 6) {
			loginMenu();
			
			option = Helper.readInt("Enter an option > ");
			
		}
	}
	
	private static void loginMenu() {
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
	
}
