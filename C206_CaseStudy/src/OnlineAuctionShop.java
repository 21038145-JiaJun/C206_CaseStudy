import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class OnlineAuctionShop {
	private static final int MAX_USERS = 200;
	private static final String TITLE_HEADER = "%-12s %-15s %-25s %-10s\n";
	private static final int OPTION_DEFAULT = -99;
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

	private static final String ERROR_MSG_OPTION = "Invalid option";

	private static ArrayList<Payment> paymentList = new ArrayList<Payment>();
	private static ArrayList<Item> itemList = new ArrayList<Item>();
	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Auction> auctionList = new ArrayList<Auction>();
	private static ArrayList<Bid> bidList = new ArrayList<Bid>();

	public static void main(String[] args) {
		launch();
	}

	private static void launch() {

		Auction a1 = new Auction(1, "A beautiful description", 100.50);
		Auction a2 = new Auction(2, "A disgusting description", 201);
		Item i1 = new Item("I1", "Pencil");
		Item i2 = new Item("J2", "Backpack");
		Bid b1 = new Bid(1000, "Gavel", 50.40);
		Bid b2 = new Bid(1001, "Brush", 23.10);

		auctionList.addAll(Arrays.asList(a1, a2));
		itemList.addAll(Arrays.asList(i1, i2));
		bidList.addAll(Arrays.asList(b1, b2));

		int option = OPTION_DEFAULT;

		while (option != 6) {
			mainMenu();

			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_USER) {
				user();
			} else if (option == OPTION_AUCTION) {
				auction();
			} else if (option == OPTION_ITEM) {
				items();
			} else if (option == OPTION_BID) {
				bid();
			} else if (option == OPTION_PAYMENT) {
				payment();
			} else if (option == OPTION_QUIT) {
				
			} else {
				System.out.println(ERROR_MSG_OPTION);
			}

		}
	}
	
	public static int menu(String function) {
		OnlineAuctionShop.setHeader(String.format("%s MENU", function.toUpperCase()));
		System.out.println(String.format("1. Add a New %s", function));
		System.out.println(String.format("2. View All %ss", function));
		System.out.println(String.format("3. Delete an Existing %s", function));
		System.out.println("4. Exit");
		
		int option = Helper.readInt("Enter an option > ");
		return option;
	}
	
	// Display the main menu options
	private static void mainMenu() {
		OnlineAuctionShop.setHeader("CAMPUS ONLINE AUCTION SHOP (COAS)");
		System.out.println("1. Maintain Users");
		System.out.println("2. Maintain Auctions");
		System.out.println("3. Maintain Items");
		System.out.println("4. Maintain Bids");
		System.out.println("5. Maintain Payments");
		System.out.println("6. Exit");
	}

	// This is to set header for the menus
	public static void setHeader(String header) {
		Helper.line(120, "-");
		System.out.println(header);
		Helper.line(120, "-");
	}

	// ===== Option 1: Users (Cedric)
	// =====
	private static void user() {
		int option = OPTION_DEFAULT;
		
		while (option != EXIT) {
			option = menu("User");
			
			if (option == ADD) {
				// Add User
				addUser(userList);
			} else if (option == VIEW_ALL) {
				// View All Users
				viewAllUsers(userList);
			} else if (option == DELETE) {
				// Delete an existing user
				deleteUser(userList);
			}
			
        }
		
	}
	
	private static boolean isValidId(int id) { //validate id
	    return id >= 0;
	}

	public static void addUser(ArrayList<User> userList ) {
		    String name = Helper.readString("Enter the name: ");
		    int id = Helper.readInt("Enter the id ");
		    
		    if (!isValidId(id)) {
		        System.out.println("Invalid Id.");
		        return;
		    }
		    
		    if (isUserAlreadyExists(userList, name)) {
		        return;
		    }
		    
		        if (userList.size() >= MAX_USERS) {
		            System.out.println("Maximum number of users exceeded.");
		            return;
		        }
		    
		    String password = Helper.readString("Enter the password: ");
		    String email = Helper.readString("Enter the email: ");
		    
		    
		    User newUser = new User(name, id , password, email);
		    userList.add(newUser);
		    System.out.println("User added successfully.");
		}

		private static boolean isUserAlreadyExists(ArrayList<User> userList, String name) {
		for (User user : userList) {
			if (user.getName().equalsIgnoreCase(name)) {
				return true;
    }
    
		}
		
	return false;
		}
		

	public static void viewAllUsers(ArrayList<User> UserList) {
		String output = String.format(TITLE_HEADER, "Name", "Id", "Password", "Email");

		for (User user : userList) {
			output += String.format(TITLE_HEADER, user.getName(), user.getId(), user.getPw(),
					user.getEmail());

		}

		Helper.line(80, "=");
		System.out.println(output);
	}

	public static void deleteUser(ArrayList<User> userList ) {
	    if (userList.isEmpty()) {
            System.out.println("No users to delete.");
            return;
        }
		    String name = Helper.readString("Enter the name of the user to delete: ");
		    boolean isDeleted = deleteUserByName(userList, name);
		    
		    if (!isDeleted) {
		        System.out.println("User " + name + " not found.");
		    }
	}
		    private static boolean deleteUserByName(ArrayList<User> userList, String name) {
		    for (int i = 0; i < userList.size(); i++) {
		        User user = userList.get(i);
		        if (user.getName().equalsIgnoreCase(name)) {
		            userList.remove(i);
		            System.out.println("User " + name + " has been deleted.");
		            return true;
		        }
		    }
		    	return false;
		    }

	// ===== Option 4: Bids (Jia Jun)
	// =====

	public static void bid() {
		int option = OPTION_DEFAULT;

		while (option != EXIT) {
			option = menu("Bid");
			
			if (option == ADD) {
				addBid(bidList);
			} else if (option == VIEW_ALL) {
				// View All Bids
				viewAllBids(bidList);
			} else if (option == DELETE) {
				// Delete Bid
				deleteBid(bidList, 0);
			} else {
				System.out.println(ERROR_MSG_OPTION);
				bid();
			}
		}
	}

	public static void addBid(ArrayList<Bid> bidList) {
		boolean bidExist = false;

		int bidID = Helper.readInt("Enter Bid ID > ");

		for (Bid b : bidList) {
			if (b.getBidID() == bidID) {
				bidExist = true;
				if (bidExist == true) {
					double newBid = Helper.readDouble("Enter new bid > $");
					if (newBid > b.getBidding()) {
						b.setBidding(newBid);
						System.out.println("Bid successfully added");
						bid();
					} else {
						System.out.println("Bid is too low!");
						bid();
					}
				}
			} else {
				System.out.println("Invalid Bid ID!");
				bid();
			}
		}

	}

	public static String retrieveAllBids(ArrayList<Bid> bidList) {
		String output = "";

		for (Bid b : bidList) {
			output += String.format("%-15d %-15d %-25s $%-15.2f\n", (bidList.indexOf(b) + 1), b.getBidID(),
					b.getDescription(), b.getBidding());
		}
		return output;
	}

	public static void viewAllBids(ArrayList<Bid> bidList) {

		String output = String.format("%-15s %-15s %-25s %-15s\n", "Auction No.", "Auction ID", "Description",
				"Highest bid");
		String output1 = retrieveAllBids(bidList);

		System.out.println(output += output1);

		bid();

	}

	public static int retrieveBidID() {
		int bidID = Helper.readInt("Enter Bid ID to be deleted > ");
		return bidID;
	}

	public static void deleteBid(ArrayList<Bid> bidList, int bidID) {
		boolean bidExist = false;
		int bidIndex = 0;

		bidID = retrieveBidID();

		for (int i = 0; i < bidList.size(); i++) {
			if (bidID == bidList.get(i).getBidID()) {
				bidExist = true;
				bidIndex = i;
				break;
			}
		}

		if (bidExist == true) {
			char confirmation = Helper.readChar("Confirm deletion of bid? (Y/N) > ");

			if (confirmation == 'y' || confirmation == 'Y') {
				bidList.remove(bidIndex);
				System.out.println("Bid successfully deleted");
				bid();

			} else if (confirmation == 'n' || confirmation == 'N') {
				System.out.println("Bid not deleted");
				bid();
			} else {
				System.out.println(ERROR_MSG_OPTION);
				bid();
			}
		} else {
			System.out.println("Invalid Bid ID");
			bid();
		}

	}

	// ===== Option 5: Payment (Ivan)
	// =====

	public static void payment() {
		int option = OPTION_DEFAULT;

		while (option != EXIT) {
			
			option = menu("Payment");

			if (option == ADD) {
				// Add Payment
				Payment payment = inputAddPayment(auctionList, itemList);
				addPayment(paymentList, auctionList, itemList, payment);
			} else if (option == VIEW_ALL) {
				// View All Payment
				viewAllPayment(paymentList);
			} else if (option == DELETE) {
				// Delete Payment
				deletePayment(paymentList);
			} else {
				System.out.println(ERROR_MSG_OPTION);
			}
		}
	}

	// ===== Option 1: Add/Make Payment (Ivan)
	// =====
	public static Payment inputAddPayment(ArrayList<Auction> auctionList, ArrayList<Item> itemList) {

		Auction auction = null;
		Item item = null;
		int paymentID = Helper.readInt("Enter Payment ID > ");
		int auctionID = Helper.readInt("Enter Auction ID > ");
		String assetTag = Helper.readString("Enter Asset Tag > ");

		for (Auction a : auctionList) {
			if (auctionID == a.getAuctionID()) {
				auction = a;
				break;
			}
		}

		for (Item i : itemList) {
			if (assetTag.equals(i.getAssetTag())) {
				item = i;
				break;
			}
		}

		Payment payment = new Payment(paymentID, auction, item);
		return payment;

	}

	public static void addPayment(ArrayList<Payment> paymentList, ArrayList<Auction> auctionList,
			ArrayList<Item> itemList, Payment payment) {

		boolean auctionExist = false;
		boolean itemExist = false;

		for (Auction a : auctionList) {
			if (a.equals(payment.getAuction())) {
				auctionExist = true;
				break;
			}
		}

		for (Item i : itemList) {
			if (i.equals(payment.getItem())) {
				itemExist = true;
				break;
			}
		}

		if (itemExist == true && auctionExist == true) {
			for (Payment p : paymentList) {
				if (p.getAuction().equals(payment.getAuction()) && p.getItem().equals(payment.getItem())) {
					System.out.println("Payment already exists");
					return;
				}
			}

		} else {
			System.out.println("Invalid AuctionID or Item Assest Tag");
			return;
		}

		paymentList.add(payment);
		System.out.println("Payment added successfully");

	}

	// ===== Option 2: View All Payments (Ivan)
	// =====
	public static String retrieveAllPayment(ArrayList<Payment> paymentList) {
		String output = "";

		for (Payment payment : paymentList) {
			output += String.format("%-12d %-12d %-15s %-25s %-10.2f %-10s\n", payment.getPaymentID(),
					payment.getAuction().getAuctionID(), payment.getItem().getAssetTag(),
					payment.getItem().getDescription(), payment.getAuction().getCurrentBid(), payment.isPaid());
		}
		return output;
	}

	public static void viewAllPayment(ArrayList<Payment> paymentList) {

		String output = String.format("%-12s %-12s %-15s %-25s %-10s %-10s\n", "PaymentID", "AuctionID", "ItemAssetTag",
				"Description", "Price", "Paid");
		String output1 = retrieveAllPayment(paymentList);

		setHeader("LIST OF PAYMENTS");
		System.out.println(output += output1);
	}

	// ===== Option 3: Delete Payments (Ivan)
	// =====
	
	public static void deletePayment(ArrayList<Payment> paymentList) {
		viewAllPayment(paymentList);
		int paymentID = Helper.readInt("Enter Payment ID to be deleted > ");
		boolean paymentExist = false;

		for (Payment p : paymentList) {
			if (paymentID == p.getPaymentID()) {
				paymentExist = true;
				break;
			}
		}

		if (paymentExist == true) {
			char confirmation = Helper.readChar("Confirm deletion of payment? (Y/N) > ");

			if (confirmation == 'y' || confirmation == 'Y') {
				removePayment(paymentList, paymentID);
			} else if (confirmation == 'n' || confirmation == 'N') {
				System.out.println("Deleting cancelled");
			} else {
				System.out.println(ERROR_MSG_OPTION);
			}
		} else {
			System.out.println("Invalid Payment ID");
		}
	}
	
	public static void removePayment(ArrayList<Payment> paymentList, int paymentID) {
		for (int i = 0; i < paymentList.size(); i++) {
			if (paymentList.get(i).getPaymentID() == paymentID) {
				paymentList.remove(i);
				System.out.println("Payment successfully deleted");
			}
		}
	}

	// ===== Option 1: [Auction] ([Wang tianqi])
	// =====

	public static void auction() {
		int auctionOption = OPTION_DEFAULT;

		while (auctionOption != 4) {

			auctionOption = menu("Auction");

			if (auctionOption == ADD) {
				addAuction(auctionList, null);
			} else if (auctionOption == VIEW_ALL) {
				viewAllAuctions(auctionList);
			} else if (auctionOption == DELETE) {
				deleteAuction(auctionList, auctionOption);
			} else if (auctionOption == EXIT) {

			} else {
				System.out.println(ERROR_MSG_OPTION);
			}
		}
	}

	public static void deleteAuction(ArrayList<Auction> auctionList, int i) {
		int auctionID = Helper.readInt("Enter Auction ID > ");

		Iterator<Auction> iterator = auctionList.iterator();
		while (iterator.hasNext()) {
			Auction auction = iterator.next();
			if (auction.getAuctionID() == auctionID) {
				iterator.remove();
				System.out.println("Auction with ID " + auctionID + " has been deleted.");
				return;
			}
		}
		System.out.println("Auction with ID " + auctionID + " not found.");
	}

	public static void viewAllAuctions(ArrayList<Auction> auctionList) {
		System.out.println("All Auctions:");
		for (Auction auction : auctionList) {
			System.out.println("Auction ID: " + auction.getAuctionID());
			System.out.println("Description: " + auction.getDescription());
			System.out.println("Starting Bid: $" + auction.getStartingBid());
			System.out.println();
		}
	}

	public static void addAuction(ArrayList<Auction> auctionList, Auction auction) {
		int auctionID = Helper.readInt("Enter Auction ID > ");
		String description = Helper.readString("Enter Description > ");
		double startingBid = Helper.readDouble("Enter Starting Bid > ");

		Auction auction1 = new Auction(auctionID, description, startingBid);
		auctionList.add(auction1);

		System.out.println("Auction added successfully");
	}



// Option 3: Maintain Items (Le Young)
public static void items() {
	int option = OPTION_DEFAULT;

	while (option != EXIT) {
		option = menu("Item");

		if (option == ADD) {
			// Add Item
			Item item = inputAddItem(itemList);
			addItem(itemList, item);
		} else if (option == VIEW_ALL) {
			// View All 
			viewAllItems(itemList);
		} else if (option == DELETE) {
			// Delete 
			deleteItem(itemList);
		} else {
			System.out.println(ERROR_MSG_OPTION);
		}
	}
}

// Add item (Option 3.1, Le Young)

public static Item inputAddItem(ArrayList<Item> itemList) {


	Item item = null;
	
	String assetTag = Helper.readString("Enter Item ID > ");
	String description = Helper.readString("Enter Description > ");
	


	for (Item i : itemList) {
		if (assetTag.equals(i.getAssetTag())) {
			item = i;
			break;
		}
	}

	item = new Item(assetTag, description);
	return item;

}

public static void addItem(ArrayList<Item> itemList, Item item) {

	itemList.add(item);
	System.out.println("Item added successfully");

}


// ================================= Option 3.2: View All Items (LY)
// =================================
public static String retrieveAllItem(ArrayList<Item> itemList) {
	String output = "";

	for (Item item : itemList) {
		output += String.format("%-12s %-12s\n", item.getAssetTag(), item.getDescription());
	}
	return output;
}

public static void viewAllItems(ArrayList<Item> itemList) {

	String output = String.format("%-12s %-12s\n", "Item ID", "Description");
	String output1 = retrieveAllItem(itemList);

	setHeader("LIST OF ITEMS");
	System.out.println(output += output1);
}


// ================================= Option 3: Delete Item (LY)
// =================================

public static void deleteItem(ArrayList<Item> itemList) {
	viewAllItems(itemList);
	String assetTag = Helper.readString("Enter Item ID to be deleted > ");
	boolean itemExist = false;

	for (Item i : itemList) {
		if (i.getAssetTag().equals(i.getAssetTag())) {
			itemExist = true;
			break;
		}
	}

	if (itemExist == true) {
		char confirmation = Helper.readChar("Confirm deletion of item? (Y/N) > ");

		if (confirmation == 'y' || confirmation == 'Y') {
			removeItem(itemList, assetTag);
		} else if (confirmation == 'n' || confirmation == 'N') {
			System.out.println("Deleting cancelled");
		} else {
			System.out.println(ERROR_MSG_OPTION);
		}
	}
}


	public static void removeItem(ArrayList<Item> itemList, String assetTag) { 
		  for (int i = 0; i < itemList.size(); i++) { 
		   if (itemList.get(i).getAssetTag().equals(assetTag)) { 
			   itemList.remove(i); 
		    System.out.println("Item successfully deleted"); 
		   } 
		  } 
		 }

}



