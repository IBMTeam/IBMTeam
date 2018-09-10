/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */
package com.tutorial.sample.authenticate;

import com.tutorial.sample.dataaccess.DBConnection;
import com.tutorial.sample.dataaccess.MySqlConnection;

/**
 * @author Puneet D
 *
 */
public class DAO{

	//DBConnection db;
	DBConnection db;
	
	
	public DAO(DBConnection db2) {
		db = db2;
	}

	public UserInfo getUser_byName() {
		// TODO Auto-generated method stub
		
		
		System.out.println("method of the getUser_byName is called");
		return null;
	}

	public void setUserInfo(UserInfo userInfo_stub) throws Exception {
		
		String query = "Insert into User(Name,DOB,Country) VALUES (";
		String seperator = ",";
		StringBuffer queryString = new StringBuffer();
		queryString.append(query).append(userInfo_stub.getName()).append(seperator).
		append(userInfo_stub.getDOB()).append(seperator).append(userInfo_stub.getCountry())
		.append(")");
		
		System.out.println("Inside setUserInfo : value of the query is "+queryString);
		
		
		db.getConnection();
		int result = db.excuteQuery(queryString.toString());
		System.out.println("value of the result is "+result);
		if (result == 0) {
			System.out.println("issues with the database... ");
			throw new Exception("issue with the data base");
		} else {
			System.out.println("user is added successfully ");
		}
		
	}

	public Object getPF_byEmpId(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
