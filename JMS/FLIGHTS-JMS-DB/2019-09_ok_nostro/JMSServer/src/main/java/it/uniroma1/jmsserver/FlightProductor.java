/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.jmsserver;

import java.util.Properties;
import java.util.Random;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.lang3.RandomStringUtils;


/**
 *
 * @author biar
 */
public class FlightProductor {
    Properties properties = null;
    Context jndiContext = null;
    private ConnectionFactory connectionFactory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;
    
    public String hasLanded(boolean x){
        if(x) return "landed";
        else return "in flight";
        
    }
    
    public String generateFlight(){
        Random r = new Random();
        String country = RandomStringUtils.randomAlphabetic(2).toUpperCase();
        String flightNum = ""; 
        for(int i=0; i<3; i++) flightNum += Integer.toString(r.nextInt(10));
        return country+flightNum;
    }
    
    
    public void start() throws NamingException, JMSException {
        try {
            properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            properties.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            jndiContext = new InitialContext(properties);
        } catch (NamingException e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        
        connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
        destination = (Destination)jndiContext.lookup("dynamicTopics/Flights");

        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        producer = session.createProducer(destination);

        
        String text;
        String status;
        String id;
        int item = 0;
        boolean statusbool;
        
        // Item 11 >> flight AZ742 has landed : true
        TextMessage message = session.createTextMessage();
        while (true) {
            
            item++;
            
            statusbool = new Random().nextBoolean();
            status = hasLanded(statusbool);
            id = generateFlight();
            message.setStringProperty("flight", id);
            message.setStringProperty("status", status);
            
            text = "Item #" + Integer.toString(item) + " >> flight " + id + " has landed: " + statusbool;
            message.setText(text);

            this.producer.send(message);
            System.out.println(text);
            

            try {
                Thread.sleep(3000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
