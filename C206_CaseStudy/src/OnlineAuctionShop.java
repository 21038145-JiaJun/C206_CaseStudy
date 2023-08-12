import java.util.ArrayList;
import java.util.Arrays;

public class OnlineAuctionShop {
	
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
		Auction a2 = new Auction(2, "A disgusting description", 201);
		Item i1 = new Item("I1", "Pencil");
		Item i2 = new Item("J2", "Backpack");
		Payment p1 = new Payment(1, a1, i1, false);
		
		auctionList.addAll(Arrays.asList(a1, a2));
		itemList.addAll(Arrays.asList(i1, i2));
		paymentList.add(p1);
		
		int option = OPTION_DEFAULT;

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
				System.out.println(ERROR_MSG_OPTION);
			}

		}
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

	// ================================= Option 1: Users (Cedric) =================================
	private static void user() {
		int option = OPTION_DEFAULT;
		userMenu();
		option = Helper.readInt("Enter an option >");
		while (option != EXIT) {
			if (option == ADD) {
				//Add User
				addUser(userList);
			} else if (option == VIEW_ALL) {
				//View All Users
				viewAllUsers(userList);
			} else if (option == DELETE) {
				// Delete an existing user
				deleteUser(userList);
			}
		}
	}


	private static void userMenu() {
		OnlineAuctionShop.setHeader("USER MENU");
		System.out.println("1. Add a new user");
		System.out.println("2. View All Users");
		System.out.println("3. Delete an existing user");
		System.out.println("4. Exit");
	}
	
	public static void addUser(ArrayList<User> UserList ) {
		    String name = Helper.readString("Enter the name: ");
		    int id = Helper.readInt("Enter the id ");
		    String password = Helper.readString("Enter the password: ");
		    String email = Helper.readString("Enter the email: ");

		    for (User user : userList) {
		        if (user.getName().equalsIgnoreCase(name)) {
		            return;
		        }
		    }
		    
		    User newUser = new User(name, id , password, email);
		    userList.add(newUser);
		    System.out.println("User added successfully.");
		}


	

	
	public static void viewAllUsers(ArrayList<User> UserList) {
			String output = String.format("%-12s %-15s %-25s %-10s\n", "Name", "Id", "Password", "Email");
			
			for (User user : userList) {
				output += String.format("%-12s %-15d %-25s %-10s\n", 
						user.getName(), user.getId() , user.getPw() , user.getEmail());
			 }
			Helper.line(80, "=");
			System.out.println(output);
		}
	
	public static void deleteUser(ArrayList<User> UserList ) {
		    String name = Helper.readString("Enter the name of the user to delete: ");
		    boolean found = false;

		    for (int i = 0; i < userList.size(); i++) {
		        User user = userList.get(i);
		        if (user.getName().equalsIgnoreCase(name)) {
		            userList.remove(i);
		            System.out.println("User " + name + " has been deleted.");
		            found = true;
		            break;
		        }
		    }

		    if (!found) {
		        System.out.println("User " + name + " not found.");
		    }
		}
	
	// ================================= Option 4: Bids (Jia Jun) =================================

	private static void bidMenu() {
		OnlineAuctionShop.setHeader("BID MENU");
		System.out.println("1. Add a New Bid");
		System.out.println("2. View All Bids");
		System.out.println("3. Delete an Existing Bid");
		System.out.println("4. Exit");
	}

	private static void bid() {
		int option = OPTION_DEFAULT;
		bidMenu();
		while (option != EXIT) {
			if (option == ADD) {
				
				
			} else if (option == VIEW_ALL) {
				//View All Bids
			} else if (option == DELETE) {
				// Delete Bid
			}
		}
	}
	

	private static void addBid(ArrayList<Item> itemList) {
//		OnlineAuctionShop.viewAllItems(itemList);
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

	public static void paymentMenu() {
		OnlineAuctionShop.setHeader("PAYMENT MENU");
		System.out.println("1. Add/Make Payment");
		System.out.println("2. View All Payment");
		System.out.println("3. Delete an Existing Payment");
		System.out.println("4. Exit");
	}

	public static void payment() {
		int option = OPTION_DEFAULT;
		
		while (option != EXIT) {
			
			paymentMenu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == ADD) {
				//Add Payment
				Payment payment = null;
				addPayment(paymentList, auctionList, itemList, payment);
			} else if (option == VIEW_ALL) {
				//View All Payment
				viewAllPayment(paymentList);
			} else if (option == DELETE) {
				// Delete Payment
				deletePayment(paymentList);
			} else {
				System.out.println(ERROR_MSG_OPTION);
			}
		}
	}
	

	public static void addPayment(ArrayList<Payment> paymentList, ArrayList<Auction> auctionList, ArrayList<Item> itemList, Payment payment) {
		
		String paymentType = Helper.readString("Would you like to add or make payment? (Add/Make) > ");
		
		if (paymentType.equalsIgnoreCase("add")) {
			
			boolean auctionExist = false;
			boolean itemExist = false;
			int paymentExist = -1;
			
			Auction auction = null;
			Item item = null;
			
			int auctionID = Helper.readInt("Enter Auction ID > ");
			String assetTag = Helper.readString("Enter Asset Tag > ");
			
			for (Auction a : auctionList) {
				if (a.getAuctionID() == auctionID) {
					auctionExist = true;
					auction = a;
					break;
				}
			}
			
			if (auctionExist == true) {
				for (Item i : itemList) {
					if (i.getAssetTag().equals(assetTag)) {
						itemExist = true;
						item = i;
						break;
					}
				}
			} else {
				System.out.println("Invalid Auction ID");
			}
			
			if (itemExist == true) {
				for (Payment payment : paymentList) {
					if (payment.getAuction().getAuctionID() == auctionID && payment.getItem().getAssetTag().equalsIgnoreCase(assetTag)) {
						paymentExist = 1;
						break;
					} else {
						paymentExist = 0;
					}
				}
			} else {
				System.out.println("Invalid Item Assest Tag");
			}
			
			if (paymentExist == 0) {
				paymentList.add(new Payment(paymentList.size() + 1, auction, item, false));
				System.out.println("Payment added successfully");
			} else if (paymentExist == 1) {
				System.out.println("Payment already exists");
			}
			
		} else if (paymentType.equalsIgnoreCase("make")) {
			
			viewAllPayment(paymentList);
			int paymentID = Helper.readInt("Enter Payment ID > ");
			boolean paymentExist = false;
			
			for (Payment payment : paymentList) {
				if (payment.getPaymentID() == paymentID) {
					
					paymentExist = true;
					double amount = Helper.readDouble("Enter amount to pay > ");
					
					if (amount >= payment.getAuction().getCurrentBid()) {
						
						payment.makePayment();
						double change = amount - payment.getAuction().getCurrentBid();
						System.out.println(String.format("Your change is $%.2f", change));
						
					} else {
						System.out.println("Insufficient amount to pay");
					}
					break;
				}
			}
			
			if (paymentExist == false) {
				System.out.println("Invalid Payment ID");
			}
			
		} else {
			System.out.println(ERROR_MSG_OPTION);
		}
		
		
	}
	
	public static void viewAllPayment(ArrayList<Payment> paymentList) {
		
		String output = String.format("%-12s %-12s %-15s %-25s %-10s %-10s\n", "PaymentID", "AuctionID", "ItemAssetTag", "Description", "Price", "Paid");
		
		for (Payment payment : paymentList) {
			output += String.format("%-12d %-12d %-15s %-25s %-10.2f %-10s\n", 
					payment.getPaymentID(), payment.getAuction().getAuctionID(), payment.getItem().getAssetTag(),
					payment.getItem().getDescription(), payment.getAuction().getCurrentBid(), payment.isPaid());
		}
		Helper.line(120, "=");
		System.out.println("LIST OF PAYMENTS");
		Helper.line(120, "=");
		System.out.println(output);
	}
	
	public static void deletePayment(ArrayList<Payment> paymentList) {
		
		viewAllPayment(paymentList);
		boolean paymentExist = false;
		
		int paymentID = Helper.readInt("Enter Payment ID to be deleted > ");
		
		for (Payment p : paymentList) {
			if (paymentID == p.getPaymentID()) {
				paymentExist = true;
				break;
			}
		}
		
		if (paymentExist == true) {
			char confirmation = Helper.readChar("Confirm deletion of payment? (Y/N) > ");
			
			if (confirmation == 'y' || confirmation == 'Y') {
				paymentList.remove(paymentID - 1);
				System.out.println("Payment successfully deleted");
				
			} else if (confirmation == 'n' || confirmation == 'N') {
				System.out.println("Deleting cancelled");
			} else {
				System.out.println(ERROR_MSG_OPTION);
			}
		} else {
			System.out.println("Invalid Payment ID");
		}
	}
	
	
	// ================================= Option 1-6: [Function] ([Name]) =================================
	
	
	
}
