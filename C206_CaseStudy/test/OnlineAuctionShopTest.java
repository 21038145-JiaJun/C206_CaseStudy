import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OnlineAuctionShopTest {
	//prepare test data
	private static ArrayList<Payment> paymentList = new ArrayList<Payment>();
	private static ArrayList<Object> objectList = new ArrayList<Object>();
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
		
		userList.addAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
		
		Auction a1 = new Auction(1, "A beautiful description", 100.50);
		Item i1 = new Item("I1", "Item is an Item");
		Payment p1 = new Payment(a1, i1, true);
		
		auctionList.add(a1);
		itemList.add(i1);
		paymentList.add(p1);
	
	}

	@Test
	public void OnlineAuctionShop_testAddUser() {
		//Add a new user
		  


		assertTrue("OnlineAuctionShop_SampleTest",true);
	}
	
	
	
	
	
	// ================================= Test Option 5: Payment (Ivan) =================================
	@Test
	public void OnlineAuctionShop_testAddPayment() {
		//Add a new user
		  
		
		
		assertTrue("OnlineAuctionShop_SampleTest",true);
	}
	
	
	
	
	
	
	
	
	
	
	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		u3 = null;
		u4 = null;
		u5 = null;
		u6 = null;
		UserList = null;
		
	}
}
