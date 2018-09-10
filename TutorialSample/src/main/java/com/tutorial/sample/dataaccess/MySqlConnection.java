/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */
package com.tutorial.sample.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Puneet D
 *
 */
public class MySqlConnection implements DBConnection {

	String connectionUrl;
	Connection conn;
	public MySqlConnection(String connectUrl) {
		
		connectionUrl=connectUrl;
		
		System.out.println("value of the connection url is "+connectionUrl);
		
	}


	public void getConnection() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Inside MySql connection ");
		try {
			conn=DriverManager.getConnection(connectionUrl);
			System.out.println("value of the connection"+conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}

	
	public int excuteQuery(String string) {
		// TODO Auto-generated method stub
		System.out.println("inside the execute method of MySql Connection");
		return 10;
	}

}
