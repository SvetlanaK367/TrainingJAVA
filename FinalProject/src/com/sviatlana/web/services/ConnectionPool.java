package com.sviatlana.web.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static DBConnectionManager instance;
    private static ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean isInitialized = new AtomicBoolean(false);

    private static final int CONNECTIONS_COUNT = 5;

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/cinema";

    private static final String USER = "admin";
    private static final String PASS = "1234";

    private ArrayList<MySQLConnection> connections;
    // create blocked queue and synchronized set to save busy connections

    private DBConnectionManager() {
        connections = new ArrayList<>();
        Class.forName(JDBC_DRIVER);
        
        for (int i = 0; i < CONNECTIONS_COUNT; i++) {
            MySQLConnection conn = new MySQLConnection();

            try {

                System.out.println("Connecting to database...");
                conn.setConnection(DriverManager.getConnection(DB_URL, USER, PASS));
            } catch (Exception e) {
                e.printStackTrace();
            }

            connections.add(conn);
        }
    }

    public static DBConnectionManager getInstance() {
        if (!isInitialized.get()) {
            lock.lock();

            try {
                if (instance == null) {
                    instance = new DBConnectionManager();
                    isInitialized.GetAndSet(true);
                }
            } finally {
                lock.unlock();
            }
        }

        return instance;
    }

    public Connection getConnection() {
        // залочить / разлочить потом
    	for (MySQLConnection conn: connections) {
            if (conn.getFree()) {
                conn.setFree(false);
                // use take 
                return conn.getConnection();
            }
        }

        return null;
    }

    public void returnConnection(Connection conn) {
        // тем же локом 
    	for (MySQLConnection connection: connections) {
            if (conn == connection.getConnection()) {
                connection.setFree(true);
                return;
            }
        }
    }
    // destroy pool
    // close connections
    // close drivers
    //proxy connection
    
}