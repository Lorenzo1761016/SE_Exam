/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.softeng.clientexam;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author studente
 */
public class ProfessorListener implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        try {
            String idReceived = msg.getStringProperty("id");

            try { // Call Web Service Operation
                it.sapienza.softeng.exam.InterfaceImplService service = new it.sapienza.softeng.exam.InterfaceImplService();
                it.sapienza.softeng.exam.Interface port = service.getInterfaceImplPort();
                it.sapienza.softeng.exam.Professor result = port.getDetails(idReceived);

                String name = result.getName();
                String surname = result.getSurname();
                String course = result.getCourse();

                System.out.println("Professor id: " + idReceived + ", name: " + name + ", surname: " + surname + ", course: " + course);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }

        } catch (JMSException ex) {
            Logger.getLogger(ProfessorListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
