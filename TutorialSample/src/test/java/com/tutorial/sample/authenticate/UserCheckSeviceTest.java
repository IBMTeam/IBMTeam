/**
 * 
 */
package com.tutorial.sample.authenticate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author Admin
 *
 */
public class UserCheckSeviceTest {
	
	UserCheckSevice userCheckSevice;
	LDAPReturnService ldapreturnSer;
	userDetails userDetails;
	
	
	@Before
	public void setUp(){
		
		
	}
	@After
	public void cleanUp(){
		
		
		
	}
	@Test
	public void checkUser_Test_Present(){
		
		Boolean expected = true; 
		Boolean actual;
		createMocks();
		createUserNameStubs();
		userCheckSevice = new UserCheckSevice(ldapreturnSer);
		actual = userCheckSevice.checkUserName(userDetails);
		
		
		Mockito.verify(ldapreturnSer).getUserName();
		assertEquals(expected,actual);
		
	}
	private void createUserNameStubs() {
		
		userDetails = new userDetails();
		
		userDetails.setUserName("Sandip");
		
		
		
	}
	
	private void createMocks(){
		
		ldapreturnSer=mock(LDAPReturnService.class);
		when(ldapreturnSer.getUserName()).thenReturn("Sandip");
		//when(dataObj.getUser_byName()).thenReturn((UserInfo) storeduserinfo);
						
	}
	
	
	
}
