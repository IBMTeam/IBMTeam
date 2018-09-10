package com.tutorial.sample.authenticate;
/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */


import java.lang.NumberFormatException;
import java.lang.AssertionError;

/*
 * This class is supposed to authorise the user request sent from the browser
 * 
 */

public class AuthenticationService {
	
	DAO dataObj;
	
	//Dao can be supplied by either container or anyother utility
	public AuthenticationService(DAO dataAccessObject){
		
		dataObj = dataAccessObject;	
	}

	public Boolean autherise_user(UserInfo userInfo) throws Exception{
					
			String key = userInfo.getName()+userInfo.getDOB()+userInfo.getCountry();
			
			System.out.println("value of the key is "+key);
			
			System.out.println("size of the key is "+key.length());
			
			if(key.length()==0){
				NumberFormatException e= new NumberFormatException("User Info entered was empty");
				throw e;
				
			}
			
			//create DAO and use it here 
			// you are driving implementation of Authentication Service so 
			// other classes implementation will not be done.
			
			UserInfo stored_userinfo=dataObj.getUser_byName();
			System.out.println("value of the Name is "+stored_userinfo);
			System.out.println("value of the Name is "+stored_userinfo.getName());
			
			String key_fromstoreduser=stored_userinfo.getName()+stored_userinfo.getDOB()+stored_userinfo.getCountry();
			
			System.out.println("value of the key in Stored user "+key_fromstoreduser);
			
			//compare the keys
			if(key.equals(key_fromstoreduser)){
				return true;
			} else {
				return false;
			}
							
	}

	

}
