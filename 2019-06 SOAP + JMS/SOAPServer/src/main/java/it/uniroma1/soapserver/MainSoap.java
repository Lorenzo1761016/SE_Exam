/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.soapserver;

import javax.xml.ws.Endpoint;

/**
 *
 * @author biar
 */
public class MainSoap {
    
    
    public static void main(String args[]) {
        
   
        Professors.addProfessor(new Professor("0","Massimo","Mecella"));
        Professors.addProfessor(new Professor("1","Camil","Demetrescu"));
        Professors.addProfessor(new Professor("2","Marco","Shaerf"));
        Professors.addProfessor(new Professor("3","Silvia","Bonomi"));
        Professors.addProfessor(new Professor("4","Tiziana","Catarci"));
        Professors.addProfessor(new Professor("5","Maurizio","Lenzerini"));
        Professors.addProfessor(new Professor("6","Checco","Zalone"));
        
        WSImpl implementor = new WSImpl();
        String address = "http://localhost:8080/ProfessorManagement";
        Endpoint.publish(address, implementor);
        System.out.println("SOAP Webservice ready...\n");
    }
}
