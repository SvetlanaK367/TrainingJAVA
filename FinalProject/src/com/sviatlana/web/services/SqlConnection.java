package com.sviatlana.web.services;

import java.sql.Connection;

public class SqlConnection {
    private Connection connection;
    private boolean isFree = true;

    public Connection getConnection() {
        return this.connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean getFree() {
        return this.isFree;
    }

    public void setFree(boolean flag) {
        this.isFree = flag;
    }
}

/*
public void releaseConnevtion() {
	for (int i = 0; i< POOL_SIZE; i++) {
		ProxyConnection connection = connectionQueue.take();
		connection.closeConnection();
	}
	// деригистрация драйверов
	
	
}



try {
 Enumeration<Driver> drivers = DriverManager.getDrivers();
 while (drivers.hasMoreElements()) {
 Driver driver = drivers.nextElement();
 DriverManager.deregisterDriver(driver);
 }
 } catch (SQLException e) {
// log
 }
 
 
*/
