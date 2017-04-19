package com.sviatlana.web.inout;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sviatlana.web.model.Constants;

public class LoginLogic {
	
	private static final Logger logger = LogManager.getLogger("LoginLogic");

	public static boolean checkLogin(String enterLogin, String enterPass) {

		String username = null;
		String password = null;
		DataSource ds = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		boolean result = false;
		
		try {

			Properties props = new Properties();
			props.load(Login.class.getClassLoader().getResourceAsStream(Constants.getDBproperties()));
	
			String driver = props.getProperty("jdbc.driver");
			if (driver != null) {
			    Class.forName(driver) ;
			}

			username = props.getProperty("jdbc.username");
			password = props.getProperty("jdbc.password");	
			
			result = username.equals(enterLogin) && password.equals(enterPass);
			
			if (result) {
				// Get DataSource
				Context initContext = new InitialContext();
				Context envContext = (Context)initContext.lookup("java:/comp/env");
				ds = (DataSource)envContext.lookup("jdbc/javadb");
				con = ds.getConnection();

				st = con.createStatement();
				String query = "select * from book";
				rs = st.executeQuery(query);
				while (rs.next()) {
					logger.log(Level.INFO, rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
				}
			}
			
		} catch (FileNotFoundException e) {
			logger.log(Level.ERROR, "File not found:" + Constants.getDBproperties() + ". " + e);
		} catch (ClassNotFoundException e) {
			logger.log(Level.ERROR, "Class not found:" + e);
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException" + e);
		} catch (NamingException e) {
			logger.log(Level.ERROR, "NamingException:" + e);
		} catch (IOException e) {
			logger.log(Level.ERROR, "IOException:" + e);			
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (st != null) {st.close();}
				if (con != null) {con.close();}
			} catch (SQLException e) {
				logger.log(Level.ERROR, "Cannot close connection:" + e);
			} 
		}
		
		return result; 
	}
}
