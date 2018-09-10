/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */

package com.tutorial.sample.dataaccess;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.tutorial.sample.authenticate.DAO;
import com.tutorial.sample.authenticate.UserInfo;

import static org.mockito.Mockito.when;

import java.sql.SQLException;

import static org.mockito.Mockito.mock;


/**
 * @author Puneet D
 *
 */
public class DAOTest {
	
	DAO dataObj;
	DBConnection db;
	DBConnection dbNew;
	UserInfo userInfo_stub;
	UserInfo userInfo_exception_stub;
	
	StringBuffer queryString;
	StringBuffer queryString_exception;
	
	public void userStub(){
		userInfo_stub = new UserInfo();
		userInfo_stub.setName("Puneet");
		userInfo_stub.setCountry("India");
		userInfo_stub.setDOB("10/10/10");
		
		String query = "Insert into User(Name,DOB,Country) VALUES (";
		String seperator = ",";
		queryString = new StringBuffer();
		queryString.append(query).append(userInfo_stub.getName()).append(seperator).
		append(userInfo_stub.getDOB()).append(seperator).append(userInfo_stub.getCountry())
		.append(")");
		
		System.out.println("value of the query is "+queryString);
		
	}
	
	
	
	
	public void createMock() throws SQLException{
		db= mock(DBConnection.class);
		Mockito.doNothing().when(db).getConnection();
		when(db.excuteQuery(queryString.toString())).thenReturn(1);
	}
	
	public void userStub_Exception(){
		userInfo_exception_stub = new UserInfo();
		userInfo_exception_stub.setName("Vineet");
		userInfo_exception_stub.setCountry("10/10/10");
		userInfo_exception_stub.setDOB("India");
		
		String query = "Insert into User(Name,DOB,Country) VALUES (";
		String seperator = ",";
		queryString_exception = new StringBuffer();
		queryString_exception.append(query).append(userInfo_exception_stub.getName()).append(seperator).
		append(userInfo_exception_stub.getDOB()).append(seperator).append(userInfo_exception_stub.getCountry())
		.append(")");
		
		System.out.println("Inside userStub_exception : value of the query is "+queryString_exception);
	
	}
	
	public void createMock_dbNew() throws SQLException{
		dbNew= mock(DBConnection.class);
		Mockito.doNothing().when(dbNew).getConnection();
		when(dbNew.excuteQuery(queryString_exception.toString())).thenReturn(0);
	}

	
	
	@Test 
	public void saveUserInfoTest() {
		
		
		
		try {
			
			userStub();
			createMock();
			//DAO class is initiated with database reference
			dataObj = new DAO(db);
			//what will you mock ?
			//
			dataObj.setUserInfo(userInfo_stub);
			
			Mockito.verify(db).getConnection();
			Mockito.verify(db).excuteQuery(queryString.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	@Test(expected=Exception.class)
	public void saveUserInfoTest_Exception() throws Exception{
		
			userStub_Exception();
			createMock_dbNew();
			
			dataObj = new DAO(dbNew);
			dataObj.setUserInfo(userInfo_exception_stub);
						
			Mockito.verify(dbNew).getConnection();
			Mockito.verify(dbNew).excuteQuery(queryString_exception.toString());
				
	}
	
	
	
	
}
