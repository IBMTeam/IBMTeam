/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */

package com.tutorial.sample.storage;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.answers.*;

import com.tutorial.sample.authenticate.DAO;
import com.tutorial.sample.authenticate.UserInfo;
import com.tutorial.sample.storage.StorageService;

/**
 * @author Puneet D
 *
 */
public class StorageServiceTest {
	
	UserInfo userInfo_stub;
	UserInfo userInfoEmpty_stub;
	UserInfo userInfoBackEndIssue_stub;
	DAO dataObj;
	
	private void createMocks() {
		
		dataObj=mock(DAO.class);
		try {
			Mockito.doNothing().when(dataObj).setUserInfo(userInfo_stub);
			Mockito.doNothing().when(dataObj).setUserInfo(userInfoEmpty_stub);
			Mockito.doThrow(Exception.class).when(dataObj).setUserInfo(userInfoBackEndIssue_stub);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Before
	public void setUp(){
		userInfo_stub = new UserInfo();
		userInfo_stub.setName("Puneet");
		userInfo_stub.setDOB("10/10/10");
		userInfo_stub.setCountry("India");
		
		
		userInfoEmpty_stub = new UserInfo();
		userInfoEmpty_stub.setName("");
		userInfoEmpty_stub.setDOB("");
		userInfoEmpty_stub.setCountry("");
		
		userInfoBackEndIssue_stub = new UserInfo();
		userInfoBackEndIssue_stub.setName("Puneet");
		userInfoBackEndIssue_stub.setDOB("10/10/11");
		userInfoBackEndIssue_stub.setCountry("India");
		
	}
	
	@Test
	public void storeUserTest_Valid(){
		createMocks();
		//instance of DAO is provided by either container or utility
		StorageService storeService = new StorageService(dataObj);
		try {
			storeService.setUserInfo(userInfo_stub);
			Mockito.verify(dataObj).setUserInfo(userInfo_stub);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected=NumberFormatException.class)
	public void storeUserTest_EmptyInput() throws Exception{
		createMocks();
		StorageService storeService = new StorageService(dataObj);
	
		storeService.setUserInfo(userInfoEmpty_stub);
		
			Mockito.verify(dataObj).setUserInfo(userInfoEmpty_stub);
	
	}
	
	@Test(expected=Exception.class)
	public void storeUserTest_BackEndIssue() throws Exception {
		createMocks();
		StorageService storeService = new StorageService(dataObj);
		
		storeService.setUserInfo(userInfoBackEndIssue_stub);
	
			Mockito.verify(dataObj).setUserInfo(userInfoBackEndIssue_stub);
	
		
	
	}
	

}
