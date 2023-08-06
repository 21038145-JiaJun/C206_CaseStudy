import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OnlineAuctionShopTest {
	//prepare test data
	private ArrayList<Payment> paymentList;
	private ArrayList<Object> objectList;
	private ArrayList<Item> itemList;
	private ArrayList<User> userList;
	private ArrayList<Auction> auctionList;
	private ArrayList<Bid> bidList;
	
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private User u5;
	private User u6;
	
	private Auction a1;
	private Auction a2;
	private Auction a3;
	
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
		
		i1 = new Item("I1", "Pencil");
		i2 = new Item("I2", "Backpack");
		i3 = new Item("I3", "Calculator");
		
		p1 = new Payment(1, a1, i1, false);
		p2 = new Payment(2, a2, i2, false);
		p3 = null;
		p4 = new Payment(1, a1, i1, false);
		
		paymentList = new ArrayList<Payment>();
		objectList = new ArrayList<Object>();
		auctionList = new ArrayList<Auction>();
		itemList = new ArrayList<Item>();
		userList = new ArrayList<User>();
		bidList = new ArrayList<Bid>();
		
	}
	// ================================= Test Option 1: User (Cedric) =================================
	@Test
	public void OnlineAuctionShop_testAddUser() {
		//Add a new user
		  
		
		
		assertTrue("OnlineAuctionShop_SampleTest",true);
	}
	
	
	
	
	
	// ================================= Test Option 5: Payment (Ivan) =================================
	
	@Test
	public void OnlineAuctionShop_testAddPayment() {
		
		//Payment list is not null, so that can add a new payment - boundary
		assertNotNull("Check if there is valid Payment arraylist to add to", paymentList);
		//The payment just added is the as same as the first payment of the list - normal
		OnlineAuctionShop.addPayment(paymentList, p1);
		assertEquals("Check that Payment arraylist size is 1", 1, paymentList.size());
		assertSame("Check that Payment is added", p1, paymentList.get(0));
		
		//Add another payment. Test that the size of the list is 2 -normal
		//The payment just added is as same as the second payment of the list
		OnlineAuctionShop.addPayment(paymentList, p2);
		assertEquals("Check that Payment arraylist size is 2", 2, paymentList.size());
		assertSame("Check that Payment is added", p2, paymentList.get(1));
		
		//Test that adding payment with no fields to the list fails - error
		assertNull("Check that payment in list, and the payment to add is the same", p3);
		OnlineAuctionShop.addPayment(paymentList, p3);
		//The Payment list size does not change, and the payment is not added
		assertEquals("Check that Payment arraylist size is 2", 2, paymentList.size());
		
	}
	
	
	@Test
	public void OnlineAuctionShop_testViewAllPayment() {
		//Test if Payment list is not null but empty - boundary
		assertNotNull("Test if there is valid Payment arraylist to retrieve item", paymentList);
		
		//Test if the list of Payment retrieved from the OnlineAuctionShop is empty - boundary
		String allPayment = OnlineAuctionShop.retrieveAllPayment(paymentList);
		String testOutput = "";
		assertEquals("Test that ViewAllPayment is empty", testOutput, allPayment);
		
		//Given an empty list, after adding 2 payments, test if the size of the list is 2 - normal
		OnlineAuctionShop.addPayment(paymentList, p1);
		OnlineAuctionShop.addPayment(paymentList, p2);
		assertEquals("Test that Payment arraylist size is 2", 2, paymentList.size());
		
		//Test if the expected output string is the same as the list of payments retrieved from the OnlineAuctionShop	
		allPayment = OnlineAuctionShop.retrieveAllPayment(paymentList);
		testOutput = String.format("%-12d %-12d %-15s %-25s %-10.2f %-10s\n", 1, 1, "I1", "Pencil", 100.50, "No");
		testOutput += String.format("%-12d %-12d %-15s %-25s %-10.2f %-10s\n", 2, 2, "I2", "Backpack", 20.00, "No");
	
		assertEquals("Test that ViewAllPayment matches", testOutput, allPayment);
		
	}
	
	
	@Test
	public void OnlineAuctionShop_testDeletePayment() {
		
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
		
		i1 = null;
		i2 = null;
		i3 = null;
		
		p1 = null;
		p2 = null;
		p3 = null;
		
		auctionList = null;
		itemList = null;
		paymentList = null;
		userList = null;
	}
}
