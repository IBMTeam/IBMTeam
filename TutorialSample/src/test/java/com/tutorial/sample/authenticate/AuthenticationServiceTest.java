/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */

package com.tutorial.sample.authenticate;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import com.tutorial.sample.authenticate.AuthenticationService;
import com.tutorial.sample.authenticate.UserInfo;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * @author Puneet D
 * 
 * 
 * 
 * write the authentication service , which should be able to receive 
 * userInfo and varify if user is autherized or not against the stored entity and let UI layer know 
 * if autherized or not autherized
 *  
 * 
 *
 */
public class AuthenticationServiceTest {
	
	AuthenticationService authService;
	UserInfo userInfo_stub;
	UserInfo userInfo_stub_null;
	DAO dataObj;
	UserInfo storeduserinfo;
	
	private void createinfoStoredStubs_autherised(){
		
		storeduserinfo = new UserInfo();
		storeduserinfo.setName("Puneet");
		storeduserinfo.setDOB("10/10/10");
		storeduserinfo.setCountry("India");
					
	}

	private void createMocks(){
		
		dataObj=mock(DAO.class);
		when(dataObj.getUser_byName()).thenReturn((UserInfo) storeduserinfo);
						
	}
	
	
	

	private void createinfoStoredStubs_unautherised_DOB_Different(){
		
	
		storeduserinfo = new UserInfo();
		storeduserinfo.setName("Puneet");
		storeduserinfo.setDOB("10/10/11");
		storeduserinfo.setCountry("India");
			
	}
	
	private void createinfoStoredStubs_unautherised_Name_Different(){
		
		
		storeduserinfo = new UserInfo();
		storeduserinfo.setName("Vineet");
		storeduserinfo.setDOB("10/10/10");
		storeduserinfo.setCountry("India");
			
	}
	
	
	@Before
	public void setUp(){
		userInfo_stub = new UserInfo();
		userInfo_stub.setName("Puneet");
		userInfo_stub.setDOB("10/10/10");
		userInfo_stub.setCountry("India");

		userInfo_stub_null = new UserInfo();
		userInfo_stub_null.setName("");
		userInfo_stub_null.setDOB("");
		userInfo_stub_null.setCountry("");
	}
	
	@After
	public void tearDown(){
		authService=null;
	}
	
	
	
	
	//Assuming that user entered is already present in the database, so it is 
	// autherized
	@Test
	public void checkUser_Test_Autherized() throws Exception{
		Boolean expected=true;
		Boolean actual;
		
		createinfoStoredStubs_autherised();
		createMocks();
		//assuming that this class will get dataObject from container
		
		authService= new AuthenticationService(dataObj);
		
		//clean coding is expected so encapsulating in the userinfo class
		//userInfo is created at setUp
		actual=authService.autherise_user(userInfo_stub);
		
		Mockito.verify(dataObj).getUser_byName();
		assertEquals(expected,actual);
		
	}
	
	//Assuming that user entered is not present in the database, so user is  
	// not autherized
	@Test
	public void checkUser_Test_UnAutherized_DOB_Diff() throws Exception{
		Boolean expected=false;
		Boolean actual;

		createinfoStoredStubs_unautherised_DOB_Different();
		createMocks();
		authService= new AuthenticationService(dataObj);
		
		//clean coding is expected so encapsulating in the info class
		//userInfo_stub is created in setUp
		actual=authService.autherise_user(userInfo_stub);
		Mockito.verify(dataObj).getUser_byName();
		assertEquals(expected,actual);

	}
	
	//Assuming that user entered is not present in the database, so user is  
	// not autherized
	@Test
	public void checkUser_Test_UnAutherized_Name_Diff() throws Exception{
		Boolean expected=false;
		Boolean actual;

		createinfoStoredStubs_unautherised_Name_Different();
		createMocks();
		authService= new AuthenticationService(dataObj);

		//clean coding is expected so encapsulating in the info class
		//userInfo_stub is created in setUp
		actual=authService.autherise_user(userInfo_stub);
		Mockito.verify(dataObj).getUser_byName();
		assertEquals(expected,actual);

	}
	
	
	//Empty values is not supposed to be sent from UI 
	//if passed then null pointer exception should not be caught 
	@Test(expected=NumberFormatException.class)
	public void emptyCheckTest() throws Exception{
		
		createinfoStoredStubs_unautherised_Name_Different();
		createMocks();
		authService= new AuthenticationService(dataObj);

		//clean coding is expected so encapsulating in the info class
		//userInfo_stub_null is created inside setUp method
		authService.autherise_user(userInfo_stub_null);
		//System.out.println("Message received from the implementation "+thrown.toString());
		//thrown.expectMessage("User Info entered was empty");
	
	}
	
	/*
	
	//Empty values is not supposed to be sent from UI 
	//if passed then null pointer exception should not be caught 
	@Test(expected=NumberFormatException.class)
	public void emptyCheckReturnMessageTest() throws Exception{
			
		try {
			createinfoStoredStubs_unautherised_Name_Different();
			createMocks();
			authService= new AuthenticationService(dataObj);

			//clean coding is expected so encapsulating in the info class
			//userInfo_stub_null is created inside setUp method
			authService.autherise_user(userInfo_stub_null);
			//System.out.println("Message received from the implementation "+thrown.toString());
			//thrown.expectMessage("User Info entered was empty");

			
		}catch(NumberFormatException exp) {
			System.out.println("cause of failure : "+exp.getCause());
			throw exp;
		}
		
					
		 
		
	}*/
	
	

	
	
}
