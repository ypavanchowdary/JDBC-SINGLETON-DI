package com.dao.singletondi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/* 
 * This shows the use of the static keyword on variable and method and what a static block is too.
 * This is also very useful to achieve a singleton design pattern.
 * This also shows the use of the DAO(Data Access Object).
 * This also help us to use the basic principle of JAVA Reduce and Reuse of the JAVA Code Blocks where ever Necessary 
*/

public class DBCONNECTION {
	
	static Connection connection;
	public static Connection createConnection(){
		
		try{
			String driver = "oracle.jdbc.OracleDriver";
			Class.forName(driver);
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "system";
			String password = "oracle";
			connection = DriverManager.getConnection(url, username, password);
		
		}catch (Exception e) {e.printStackTrace();}
		
		return connection;
	}

}



