import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 6;
	private static final int OPTION_USER = 1;
	private static final int OPTION_AUCTION = 2;
	private static final int OPTION_ITEM = 3;
	private static final int OPTION_BID = 4;
	private static final int OPTION_PAYMENT = 5;

	private static final int ADD = 1;
	private static final int VIEW_ALL = 2;
	private static final int DELETE = 3;
	private static final int EXIT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();

	}

	private static void launch() {

		ArrayList<Object> objectList = new ArrayList<Object>();

		int option = -99;

		while (option != 6) {
			mainMenu();

			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_USER) {
				user();
			} else if (option == OPTION_AUCTION) {

			} else if (option == OPTION_ITEM) {

			} else if (option == OPTION_BID) {
				bid();
			} else if (option == OPTION_PAYMENT) {

			} else if (option == OPTION_QUIT) {

			} else {
				System.out.println("Invalid option");
			}

		}
	}

	// Display the main menu options
	private static void mainMenu() {
		C206_CaseStudy.setHeader("CAMPUS ONLINE AUCTION SHOP (COAS)");
		System.out.println("1. Maintain Users");
		System.out.println("2. Maintain Auctions");
		System.out.println("3. Maintain Items");
		System.out.println("4. Maintain Bids");
		System.out.println("5. Maintain Payments");
		System.out.println("6. Exit");
	}

	// This is to set header for the menus
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// ================================= Option 1: Users (Cedric) =================================
	private static void user() {
		int option = -99;
		userMenu();
		option = Helper.readInt("Enter an option >");
		while (option != EXIT) {
			if (option == ADD) {
				//Add a new user
				
				
			} else if (option == VIEW_ALL) {
				//View All Users
				
			} else if (option == DELETE) {
				//Delete an existing user
				
			}
		}
	}


	private static void userMenu() {
		C206_CaseStudy.setHeader("USER MENU");
		System.out.println("1. Add a new user");
		System.out.println("2. View All Users");
		System.out.println("3. Delete an existing user");
		System.out.println("4. Exit");
	}
	
	public static void addUser(ArrayList<User> UserList , User u) {
		User user;
		for(int i = 0; i < UserList.size(); i++) {
			user = UserList.get(i);
			if (user.getName().equalsIgnoreCase(user.getName()) )
				return;
		}
		if ((u.getName().isEmpty()) || (u.getPw().isEmpty()) ) {
			return;
		}
		
		UserList.add(u);
	}
	
	public static void ViewAllUsers(ArrayList<User> UserList , User u) {
		
		
	}
	
	public static void deleteUser(ArrayList<User> UserList , User u) {
		
	}
	
	

	// ================================= Option 4: Bids (Jia Jun) =================================

	private static void bidMenu() {
		C206_CaseStudy.setHeader("BID MENU");
		System.out.println("1. Add a New Bid");
		System.out.println("2. View All Bids");
		System.out.println("3. Delete an Existing Bid");
		System.out.println("4. Exit");
	}

	private static void bid() {
		int option = -99;
		bidMenu();
		while (option != EXIT) {
			if (option == ADD) {
				//Add Bid
				
			} else if (option == VIEW_ALL) {
				//View All Bids
			} else if (option == DELETE) {
				// Delete Bid
			}
		}
	}
	

	private static void addBid(ArrayList<Item> itemList) {
//		C206_CaseStudy.viewAllItems(itemList);
		String tag = Helper.readString("Enter asset tag > ");
		double newBid = Helper.readDouble("Enter new bid > $");

//		for (int i = 0; i < itemList.size(); i++) {
//			item = itemList.get(i);
//			if (item.getAssetTag().equalsIgnoreCase(item.getAssetTag()))
//				return;
//		}
//		if ((item.getAssetTag().isEmpty()) || (item.getDescription().isEmpty())) {
//			return;
//		}
//
//		itemList.add(item);
	}
	
	private static void viewAllBids(ArrayList<Item> itemList, Bid b) {
		
	}
	
	private static void deleteBid(ArrayList<Item> itemList, Bid b) {
		
	}
	// ================================= Option 1-6: [Function] ([Name]) =================================

}
