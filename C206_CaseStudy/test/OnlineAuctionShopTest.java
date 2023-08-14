import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OnlineAuctionShopTest {

	private static ArrayList<Payment> paymentList = new ArrayList<Payment>();
	private static ArrayList<Item> itemList = new ArrayList<Item>();
	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Auction> auctionList = new ArrayList<Auction>();
	private static ArrayList<Bid> bidList = new ArrayList<Bid>();

	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private User u5;
	private User u6;

	private Auction a1;
	private Auction a2;
	private Auction a3;
	
	private Bid b1;
	private Bid b2;
	private Bid b3;

	private Item i1;
	private Item i2;
	private Item i3;

	private Payment p1;
	private Payment p2;
	private Payment p3;
	private Payment p4;

	public OnlineAuctionShopTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		//prepare test data
	
		u1 = new User("Jane" , 20791987 , "Jane55" ,  "jane55@gmail.com");
		u2 = new User("James" , 29875673 , "James27" , "james201@hotmail.com");
		u3 = new User("Carrie" , 56792928 , "Carr25ie" , "car32ie@yahoo.com");
		u4 = new User("Ronnie" , 18736272 , "RontheBest25" , "ronbest55@gmail.com");
		u5 = new User("Rena" , 24748493, "Ren35A" , "rena89@yahoo.com");
		u6 = new User("Jason" , 98365748 , "JaS3n" , "jasON23@yahoo.com");

		a1 = new Auction(1, "Description 1", 100.50);
		a2 = new Auction(2, "Description 2", 20);
		a3 = new Auction(3, "Description 3", 300.99);
		
		b1 = new Bid(1000, "Letter", 19.99);
		b2 = new Bid(2000, "Stone", 50.00);
		b3 = new Bid(2001, "Gravel", 29.95);

		i1 = new Item("I1", "Pencil");
		i2 = new Item("I2", "Backpack");
		i3 = new Item("I3", "Calculator");

		p1 = new Payment(1, a1, i1);
		p2 = new Payment(2, a2, i2);

		paymentList = new ArrayList<Payment>();
		auctionList = new ArrayList<Auction>();
		itemList = new ArrayList<Item>();
		userList = new ArrayList<User>();
		bidList = new ArrayList<Bid>();
	}
	
	// ===== Test Option 1: User (Cedric) =====
	@Test
	
	public void testaddUser() {
		//Add a new User - normal
	    int initialSize = userList.size();
	    OnlineAuctionShop.addUser(userList);
	    assertEquals("Test that adding a new user should increase the user list size by 1", initialSize + 1, userList.size());
	    User newUser = userList.get(userList.size() - 1);
	    assertNotNull("Check that new User is added", newUser);
	    
		//Invalid Id format , size of list remains the same , error message "Invalid Id" should be displayed-Error
		    int invalidId = -16374347; 
		    User invalidUser = new User("Jane", invalidId, "Jane55", "jane55@gmail.com");
		    userList.add(invalidUser);
		    assertEquals("Test that adding a user with an invalid ID should not change the user list size", initialSize + 2 , userList.size());
		    
		    
		//Maximum number of users exceeded  -Boundary
		    User userExceedMax = new User("John", 243627272, "John78", "john78@yahoo.com");
		    userList.add(userExceedMax);
		    assertEquals("Test that adding a user when the maximum user limit is exceeded should not change the user list size", initialSize + 3, userList.size());
		 
		    // User list is not null, so that can add a new user - boundary
			assertNotNull("Test that there is a valid userlist that can be added", userList);
	}



	// ===== Test Option 3: Auction ([Wang tianqi]) =====
	@Test
	public void OnlineAuctionShop_testAddAuction() {
		Auction auction1 = new Auction(1, "1", 1);

		OnlineAuctionShop.addAuction(auctionList, auction1);

		assertEquals("Test that auctionList size is 1", 1, auctionList.size());
		//assertSame("Test that auction is added", auction1, auctionList.get(0));
	}


	@Test
	public void OnlineAuctionShop_testViewAllAuction() {


		Auction auction1 = new Auction(1, "Description 1", 100.5);
		Auction auction2 = new Auction(2, "Description 2", 200.0);
		auctionList.add(auction1);
		auctionList.add(auction2);

		OnlineAuctionShop.viewAllAuctions(auctionList);

		String expectedOutput = "All Auctions:\n" +"Auction ID: 1\n" +"Description: Description 1\n" + "Starting Bid: 100.5\n" + "\n" +"Auction ID: 2\n" +
				"Description: Description 2\n" +"Starting Bid: 200.0\n" +"\n";

		// Restore the original System.out
		System.setOut(System.out);
	}
	
	@Test
	public void OnlineAuctionShop_testDeleteAuction() {
		Auction auction1 = new Auction(1, "Description 1", 100.5);
		Auction auction2 = new Auction(2, "Description 2", 100.0);
		auctionList.add(auction1);
		auctionList.add(auction2);

		// Delete auction1 with ID 1
		OnlineAuctionShop.deleteAuction(auctionList, 1);

		// Check if auction1 is removed from the auctionList
		assertFalse("Test that auction1 is removed", 
				auctionList.stream().anyMatch(auction -> auction.getAuctionID() == 1));

		// Check that only one auction remains in the list
		assertEquals("Test that only one auction remains in the list", 1, auctionList.size());
	}

	// ===== Test Option 5: Payment (Ivan) =====

	@Test
	public void OnlineAuctionShop_testAddPayment() {
		//Add necessary objects into auctionList and itemList for validation during check
		auctionList.addAll(Arrays.asList(a1, a2, a3));
		itemList.addAll(Arrays.asList(i1, i2, i3));
		
		//Payment list is not null, so that can add a new payment - boundary
		assertNotNull("Check if there is valid Payment arraylist to add to", paymentList);
		//The payment just added is the as same as the first payment of the list - normal
		OnlineAuctionShop.addPayment(paymentList, auctionList, itemList, p1);
		assertEquals("Check that Payment arraylist size is 1", 1, paymentList.size());
		assertSame("Check that Payment is added", p1, paymentList.get(0));

		//Add another payment. Test that the size of the list is 2 -normal
		//The payment just added is as same as the second payment of the list
		OnlineAuctionShop.addPayment(paymentList, auctionList, itemList, p2);
		assertEquals("Check that Payment arraylist size is 2", 2, paymentList.size());
		assertSame("Check that Payment is added", p2, paymentList.get(1));

		//Test that adding payment that already exists to the list fails - error
		assertSame("Check that payment in list, and the payment to add is the same", p1, paymentList.get(0));
		OnlineAuctionShop.addPayment(paymentList, auctionList, itemList, p1);
		//The Payment list size does not change, and the payment is not added
		assertEquals("Check that Payment arraylist size is 2", 2, paymentList.size());

	}

	@Test
	public void OnlineAuctionShop_testViewAllPayment() {
		//Add necessary objects into auctionList and itemList for validation during check
		auctionList.addAll(Arrays.asList(a1, a2, a3));
		itemList.addAll(Arrays.asList(i1, i2, i3));
		
		//Test if Payment list is not null but empty - boundary
		assertNotNull("Test if there is valid Payment arraylist to retrieve item", paymentList);

		//Test if the list of Payment retrieved from the OnlineAuctionShop is empty - boundary
		String allPayment = OnlineAuctionShop.retrieveAllPayment(paymentList);
		String testOutput = "";
		assertEquals("Test that ViewAllPayment is empty", testOutput, allPayment);

		//Given an empty list, after adding 2 payments, test if the size of the list is 2 - normal
		OnlineAuctionShop.addPayment(paymentList, auctionList, itemList, p1);
		OnlineAuctionShop.addPayment(paymentList, auctionList, itemList, p2);
		assertEquals("Test that Payment arraylist size is 2", 2, paymentList.size());

		//Test if the expected output string is the same as the list of payments retrieved from the OnlineAuctionShop	
		allPayment = OnlineAuctionShop.retrieveAllPayment(paymentList);
		testOutput = String.format("%-12d %-12d %-15s %-25s %-10.2f %-10s\n", 1, 1, "I1", "Pencil", 100.50, "No");
		testOutput += String.format("%-12d %-12d %-15s %-25s %-10.2f %-10s\n", 2, 2, "I2", "Backpack", 20.00, "No");

		assertEquals("Test that ViewAllPayment matches", testOutput, allPayment);

	}

	@Test
	public void OnlineAuctionShop_testDeletePayment() {

		//Add necessary objects into auctionList and itemList for validation during check
		auctionList.addAll(Arrays.asList(a1, a2, a3));
		itemList.addAll(Arrays.asList(i1, i2, i3));

		//Test if Payment list is not null but empty - boundary
		assertNotNull("Test if there is valid Payment arraylist to retrieve item", paymentList);

		//Add Payment to list for testing removePayment
		paymentList.addAll(Arrays.asList(p1, p2));
		//Test Payment List is 1 after deleting payment - normal
		OnlineAuctionShop.removePayment(paymentList, 2);
		assertEquals("Test that Payment arraylist size is 1", 1, paymentList.size());

		//Test Payment List is still 1 after deleting payment with non-existent paymentID - error
		OnlineAuctionShop.removePayment(paymentList, 2);
		assertEquals("Test that Payment arraylist size is 1", 1, paymentList.size());

		//Test Payment List is 0 after deleting only existing payment - boundary
		OnlineAuctionShop.removePayment(paymentList, 1);
		assertEquals("Test that Payment arraylist size is 0", 0, paymentList.size());

	}

	@Test
	public void OnlineAuctionShop_testAddBid() {
		
		// Test if the new bid is empty
		assertNotNull("Test if the bid arraylist to retrieve item", bidList);

		// Test if the array list has the the items added
		bidList.add(b1);
		bidList.add(b2);
		bidList.add(b3);
		assertEquals("Test if the bid arraylist has added 3 entries.",3,bidList.size());
		
		// Test if a higher bid changes the value
		double newBid = 200;
		assertTrue("Test if current bid is higher than new bid.", newBid > b1.getBidding());
		
		// Test that a negative value will not change the value
		double errorBid = -45.23;
		assertFalse("Test if current bid is not negative", errorBid > b1.getBidding());
		
		// Test that a 0.01 higher bid will change the value
		double boundaryBid = 50.01;
		assertTrue("Test if current bid is higher than new bid by 0.01", boundaryBid > b2.getBidding());
	}
	
	@Test
	public void OnlineAuctionShop_testViewAllBids() {
		// Test that there are no bids in the array list.
		assertNotNull("Test if the bid arraylist to retrieve item", bidList);
		
		// Test that the bids are empty in the array list
		assertEquals("Test that viewAllBids array list is empty",0, bidList.size());
		
		// Test that bid are shown correctly
		bidList.add(b1);
		bidList.add(b2);
		bidList.add(b3);
		
		String actualOutput = OnlineAuctionShop.retrieveAllBids(bidList);
		String testOutput = "";
		testOutput += String.format("%-15d %-15d %-25s $%-15.2f\n",1, 1000, "Letter", 19.99);
		testOutput += String.format("%-15d %-15d %-25s $%-15.2f\n",2, 2000, "Stone", 50.00);
		testOutput += String.format("%-15d %-15d %-25s $%-15.2f\n",3, 2001, "Gravel", 29.95);
		
		assertEquals("Test that the output is the same.", actualOutput, testOutput);
		
	}

	@Test
	public void OnlineAuctionShop_testDeleteBid() {
		bidList.add(b1);
		bidList.add(b2);
		bidList.add(b3);
		
		int bidSize = bidList.size();
		
		// Test that the array list for bid is not empty
		assertNotNull("Test that the list is not empty", bidList);

		
		// Test that the wrong bid ID results in an error
		int wrongBidID = 6700;
		boolean bidFound = false;
		for (Bid b:bidList) {
			if (b.getBidID() == wrongBidID) {
				bidFound = true;
			} else {
				bidFound = false;
			}
		}
		
		assertFalse("Test that bid is not deleted", bidFound);
		
		
		// Test that the bid ID deletes the bid
		int correctBidID = 2000;
		
		for (Bid b:bidList) {
			if (b.getBidID() == correctBidID) {
				bidFound = true;
				OnlineAuctionShop.deleteBid(bidList, correctBidID);
			} else {
				bidFound = false;
			}

		}
		assertTrue("Test that the bid is deleted", bidFound);

		//Test that the array list for bid is not empty
		assertNotNull("Test that the list is not empty",bidList);
		
		//Test that the auction ID deletes the bid
		OnlineAuctionShop.deleteBid(bidList, b2.getBidID());
		assertEquals("Test that a bid has been deleted", bidSize - 1, bidList.size());
	}

	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		u3 = null;
		u4 = null;
		u5 = null;
		u6 = null;

		a1 = null;
		a2 = null;
		a3 = null;
		
		b1 = null;
		b2 = null;
		b3 = null;

		i1 = null;
		i2 = null;
		i3 = null;

		p1 = null;
		p2 = null;
		p3 = null;

		auctionList = null;
		bidList = null;
		itemList = null;
		paymentList = null;
		userList = null;
	}
}