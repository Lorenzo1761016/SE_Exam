/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.client;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.sql.*;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author biar
 */
public class FlightListener implements MessageListener{
    private TopicConnection connection;
    
    public FlightListener() {
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            Context ctx = new InitialContext(props);

            ConnectionFactory connectionFactory = (ConnectionFactory)ctx.lookup("ConnectionFactory");
            connection = (TopicConnection)connectionFactory.createConnection();
            TopicSession session = (TopicSession)connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = (Destination)ctx.lookup("dynamicTopics/Flights");
            TopicSubscriber subscriber = session.createSubscriber((Topic)destination);
            subscriber.setMessageListener(this);
        } catch (JMSException err) {
            err.printStackTrace();
        } catch (NamingException err) {
            err.printStackTrace();
        }
    }
    
    public void updateFlightsDb(String flightId, String status){
        
        Connection connection;
        
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/biar/flights.db");
            Statement statement = connection.createStatement();
            //statement.setQueryTimeout(30);  
            // Add Movies
            PreparedStatement prep = connection.prepareStatement("insert into flights values (?, ?);");

            prep.setString(1, flightId); // Flight ID
            prep.setString(2, status); // status
            prep.addBatch();
            connection.setAutoCommit(false);
            prep.executeBatch();
            connection.setAutoCommit(true);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
    public void onMessage(Message msg) {
        try {
            String flightId = msg.getStringProperty("flight");
            String status = msg.getStringProperty("status");
            
            updateFlightsDb(flightId,status);
            System.out.println("Recived >> Flight: " + flightId + " Status: " + status);   
            
        } catch (JMSException err) {
            err.printStackTrace();
        }
    }
    
    public void start() {
        try {
            connection.start();
        } catch (JMSException err) {
            err.printStackTrace();
        }
    }
    
    public void stop() {
        try {
            connection.stop();
        } catch (JMSException err) {
            err.printStackTrace();
        }
    }
}
