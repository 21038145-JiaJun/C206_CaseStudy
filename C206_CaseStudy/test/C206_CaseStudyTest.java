import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//prepare test data
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private User u5;
	private User u6;
	
	private ArrayList<User> UserList;
	
	public C206_CaseStudyTest() {
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
	
		UserList= new ArrayList<User>();
	
	}

	@Test
	public void c206_testAddUser() {
		//Add a new user
		  


		assertTrue("C206_CaseStudy_SampleTest ",true);
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
