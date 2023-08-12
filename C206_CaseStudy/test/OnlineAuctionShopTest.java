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
		Payment p1 = new Payment(1, a1, i1, true);
		
		auctionList.add(a1);
		itemList.add(i1);
		paymentList.add(p1);
	
	}
	// ================================= Test Option 1: User (Cedric) =================================
	@Test
	public void OnlineAuctionShop_testAddUser() {
		//Add a new user , size of list increased by 1 , which is 2?-Normal
		 int initialSize = userList.size();
	        User newUser = new User("Jane", 20791987, "Jane55", "jane55@gmail.com");
	        userList.add(newUser);
	        assertEquals("Test that adding a new user should increase the user list size by 1", initialSize + 1, userList.size());
		
		
		//Invalid Id format , size of list remains the same , error message "Invalid Id" should be displayed-Error
	        User invalidUser = new User("Jane", 225, "Jane55", "jane55d@gmail.com");
	        userList.add(invalidUser);
	        assertEquals("Test that adding a user with an invalid ID should not change the user list size", initialSize + 1, userList.size());

		//Maximum number of users exceeded  -Boundary
	        User userExceedMax = new User("John", 243627272, "John78", "john78@yahoo.com");
	        userList.add(userExceedMax);
	        assertEquals("Test that adding a user when the maximum user limit is exceeded should not change the user list size", initialSize + 1, userList.size());
	    }
	  
	
	public void OnlineAuctionShop_testViewUsers() {
		//View all users in userList -normal
		 assertNotNull("Test that userList should not be null", userList);
	     assertFalse("Test that userList should not be empty", userList.isEmpty());
	
		
		//View userList when userList is null -error/normal
	     ArrayList<User> nullUserList = null;
	     assertNull("Test that viewing null user list should result in null", nullUserList);
		
	}
	public void OnlineAuctionShop_testDeleteUser() {
		//Deleting an existing user , userList should decreased by 1 - Normal
		 	int initialSize = userList.size();
			assertTrue("Test that userList should contain u1 before deletion", userList.contains(u1));
		    userList.remove(u1);
		    assertFalse("Test that userList should not contain u1 after deletion", userList.contains(u1));
		    assertEquals("Test that deleting an existing user should decrease the userList size by 1", initialSize - 1, userList.size());
		
		  //Deleted User still displays in userList(ViewAllUsers) - error
	        assertFalse("Test that a deleted user e.g. u1 should not be in user list", userList.contains(u1));
		
		//Deletion is done twice - boundary
	        int newSize = userList.size(); //captures initialSize
	        boolean userWasRemoved = userList.remove(u1); //returns true if user was found and removed , returns false if user is not found
	        assertFalse("Test that  deleting the same user again should return false", userWasRemoved); //deleting the same user again should return false
	        assertEquals("Test that deleting a user again should not affect userList size", newSize, userList.size()); //size of list remains unchanged, comparing the size of newSize and userList 
	        
	     //UserList is empty after deletion of all users - normal
	        userList.clear();
	        assertTrue("Test that userList should be empty after deleting all users" , userList.isEmpty());
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
		userList = null;
		
	}
}
