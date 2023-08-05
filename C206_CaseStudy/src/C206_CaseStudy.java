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
	
	private static ArrayList<Payment> paymentList = new ArrayList<Payment>();
	private static ArrayList<Object> objectList = new ArrayList<Object>();
	private static ArrayList<Item> itemList = new ArrayList<Item>();
	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Auction> auctionList = new ArrayList<Auction>();
	private static ArrayList<Bid> bidList = new ArrayList<Bid>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

	private static void launch() {
		
		Auction a1 = new Auction(1, "A beautiful description", 100.50);
		Item i1 = new Item("I1", "Item is an Item");
		Payment p1 = new Payment(a1, i1, true);
		
		auctionList.add(a1);
		itemList.add(i1);
		paymentList.add(p1);
		
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
				payment();
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

	
	// ================================= Option 5: Payment (Ivan) =================================

	private static void paymentMenu() {
		C206_CaseStudy.setHeader("PAYMENT MENU");
		System.out.println("1. Add a New Payment");
		System.out.println("2. View All Payment");
		System.out.println("3. Delete an Existing Payment");
		System.out.println("4. Exit");
	}

	private static void payment() {
		int option = -99;
		
		while (option != EXIT) {
			
			paymentMenu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == ADD) {
				//Add Payment
				addPayment(paymentList);
			} else if (option == VIEW_ALL) {
				//View All Payment
				viewAllPayment(paymentList);
			} else if (option == DELETE) {
				// Delete Payment
				deletePayment(paymentList);
			}
		}
	}
	

	private static void addPayment(ArrayList<Payment> paymentList) {
//		String tag = Helper.readString("Enter asset tag > ");
//		double newBid = Helper.readDouble("Enter new bid > $");

//		for (int i = 0; i < paymentList.size(); i++) {
//			payment = paymentList.get(i);
//			if (payment.getAssetTag().equalsIgnoreCase(payment.getAssetTag()))
//				return;
//		}
//		if ((item.getAssetTag().isEmpty()) || (item.getDescription().isEmpty())) {
//			return;
//		}
//
//		itemList.add(item);
	}
	
	private static void viewAllPayment(ArrayList<Payment> paymentList) {
		
		String output = String.format("%-12s %-15s %-25s %-10s %-10s\n", "AuctionID", "ItemAssetTag", "Description", "Price", "Paid");
		
		for (Payment payment : paymentList) {
			output += String.format("%-12d %-15s %-25s %-10.2f %-10s\n", 
					payment.getAuction().getAuctionID(), payment.getItem().getAssetTag(), payment.getItem().getDescription(),
					payment.getAuction().getCurrentBid(), payment.isPaid());
		}
		Helper.line(80, "=");
		System.out.println(output);
	}
	
	private static void deletePayment(ArrayList<Payment> paymentList) {
		
	}
	
	
	// ================================= Option 1-6: [Function] ([Name]) =================================
	
	
	
}
