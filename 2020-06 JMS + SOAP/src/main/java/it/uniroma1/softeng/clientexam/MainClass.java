/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.softeng.clientexam;

import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author studente
 */
public class MainClass {

    public static void main(String[] args) throws NamingException, JMSException {

        String destName = "dynamicTopics/professors";

        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");

        Context ctx = new InitialContext(props);
        ConnectionFactory connFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
        Destination dest = (Destination) ctx.lookup(destName);
        Connection connection = connFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        MessageConsumer consumer = session.createConsumer(dest);

        ProfessorListener listener = new ProfessorListener();
        consumer.setMessageListener((MessageListener) listener);
        connection.start();

    }

}
