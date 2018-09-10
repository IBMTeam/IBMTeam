/**
 * @author Puneet Duneja
 * ©TRIOHATS Consulting Pvt Ltd
 *
 */
package com.tutorial.sample.dataaccess;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Puneet D
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MySqlConnection.class})
public class DataBaseConnectionTest {

	String connectUrl="jdbc:mysql://localhost/onlineBook?useSSL=false&"
			+ "user=Puneet&password=adventure";
	Connection conn;
	
	private void createMock() throws SQLException{
		
		
		
		PowerMockito.mockStatic(DriverManager.class);
		PowerMockito.when(DriverManager.getConnection(connectUrl)).thenReturn(null);
			
	}
	
	
	
	@Test
	public void getGetConnectionTest() throws SQLException{
	
	
			//String query = "Insert into User(NAME,DOB,COUNTRY) VALUES(\"Puneet\",\"10/10/10\",\"INDIA\")"; 
			createMock();
			// Note how we replay the class, not the instance!
			//PowerMock.replay(DriverManager.class);
			DBConnection db = new MySqlConnection(connectUrl);

			db.getConnection();
			// Note how we verify the class, not the instance!
			PowerMockito.verifyStatic();

		
		
	}
	
	
	
	
}