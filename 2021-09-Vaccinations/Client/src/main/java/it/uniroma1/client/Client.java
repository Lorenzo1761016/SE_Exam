package it.uniroma1.client;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.bind.JAXB;

import it.uniroma1.generatedsource.*;

public class Client {
	// Needed for REST
    private static final String BASE_URL = "http://localhost:8080/vaccinations/";
    
    // Needed for SOAP
    private static final WSImplService service = new WSImplService();
    private static final WSInterface port = service.getWSImplPort();

    public static void main(String[] args) throws IOException {

        
	// GET all vaccinations
        System.out.println("\n");
        System.out.println("******* Getting all the vaccinations from REST service... *********");
        Vaccinations vaccinations = getVaccinationList();
        for (Vaccination elem : vaccinations.getVaccinations()) {
            System.out.println(elem.toString());
        }
        System.out.println("\n");
        
        
        // SOAP a person
        String id = "00000001";
        System.out.println("******* Getting details about person with id " +  id + " from SOAP service... *********");
        String person = getPerson(id);
        System.out.println(person);

    }

    private static String getPerson(String i) throws IOException {
    	Person personsoap = (Person) port.getPersonDetails(i);   
        String details = "DETAILS ABOUT PERSON " + i + "\n";
        details += "Name: " + personsoap.getName() + "\n";
        details += "Surname: " + personsoap.getSurname() + "\n";
        details += "Birthdate: " + personsoap.getBirthdate() + "\n";
        details += "Address: " + personsoap.getAddress();
       
        if(personsoap != null) return details;
        else return "Person with id " + i + " not found\n";

    }

    private static Vaccinations getVaccinationList() throws IOException {
        final URL url = new URL(BASE_URL + "list"); 
        final InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Vaccinations.class);
    }
}
