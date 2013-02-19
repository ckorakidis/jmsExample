/*
 * 
 */
package com.jmschat.helper;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;


/**
 * The Class JMSConnection.
 */
public class JMSConnection {

    /**
     * The Constant URL.
     */
    private static final String URL = "tcp://localhost:61616";

    /**
     * The connection.
     */
    private static Connection connection = null;

    /**
     * The connection factory.
     */
    private static ConnectionFactory connectionFactory = null;

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public static Connection getConnection() {

        try {
            // Create the connection.
            connectionFactory = new ActiveMQConnectionFactory(URL);
            connection = connectionFactory.createConnection();
            connection.start();

        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Close connection.
     */
    public static void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the connection factory.
     *
     * @return the connection factory
     */
    public static ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    /**
     * Sets the connection factory.
     *
     * @param connectionFactory the new connection factory
     */
    public static void setConnectionFactory(ConnectionFactory connectionFactory) {
        com.jmschat.helper.JMSConnection.connectionFactory = connectionFactory;
    }

    /**
     * Sets the connection.
     *
     * @param connection the new connection
     */
    public static void setConnection(Connection connection) {
        com.jmschat.helper.JMSConnection.connection = connection;
    }


}	
