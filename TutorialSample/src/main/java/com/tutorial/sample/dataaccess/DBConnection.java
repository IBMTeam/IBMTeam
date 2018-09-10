/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */

package com.tutorial.sample.dataaccess;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {

	void getConnection() throws SQLException;

	public int excuteQuery(String string);

}
