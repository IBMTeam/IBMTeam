/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */

package com.tutorial.sample.storage;

import javax.sql.rowset.CachedRowSet;

import com.tutorial.sample.authenticate.DAO;
import com.tutorial.sample.authenticate.UserInfo;

/**
 * @author Puneet D
 *
 */
public class StorageService {

	DAO dataAccessObj;
	
	public StorageService(DAO dataObj) {
		dataAccessObj = dataObj;
	}

	
	//DAO is not available and you are unit testing StorageService so Mock others
	public void setUserInfo(UserInfo userInfo_stub) throws Exception {
		System.out.println("Inside setUserInfo method");
		
		if (userInfo_stub.getName().length()==0){ 
			System.out.println("empty name before throwing exception");
			throw new NumberFormatException("Empty name");
		} else if (userInfo_stub.getDOB().length()==0){
			throw new NumberFormatException("Empty DOB");
		} else if (userInfo_stub.getCountry().length()==0) {
			throw new NumberFormatException("Empty Country");
		}
		
				
		dataAccessObj.setUserInfo(userInfo_stub);
		
	}

}
