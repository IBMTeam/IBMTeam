/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */
package com.tutorial.sample.dataaccess;

import java.sql.Connection;

/**
 * @author Puneet D
 *
 */
public class PostGresSQL implements DBConnection {

	@Override
	public void getConnection() {
		System.out.println("Inside PostGresSQL connection ");
		
	}



	@Override
	public int excuteQuery(String queryString) {
		// TODO Auto-generated method stub
		System.out.println("inside the execute method of PostGresSql Connection");
		return 10;
	}





}
