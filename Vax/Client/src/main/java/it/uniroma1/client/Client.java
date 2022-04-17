package it.uniroma1.client;

import it.uniroma1.generatedsource.*;
import javax.xml.bind.JAXB;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Client {
    private static final String BASE_URL = "http://localhost:8080/vaccinations/";
    private static final WSImplService service = new WSImplService();
    private static final WSInterface port = service.getWSImplPort();
    
     public static void main(String[] args) throws IOException {

      /*  // GET all vaccinations
        Vaccinations vaccinations = getVaccinationList();
        for (Vaccination elem : vaccinations.getVaccinations()) {
            System.out.println(elem.toString());
        } */

        //GET persons details
        String person = getPerson("1");
        System.out.println(person);
        

       
    }

    private static String getPerson(String i) throws IOException {
        
        	Person personsoap = (Person) port.getPersonDetails(i);   
        	if(personsoap != null) {
	        	String details = "DETAILS ABOUT PERSON " + i + "\n";
	            details += "Name: " + personsoap.getName() + "\n";
	            details += "Birthdate: " + personsoap.getBirthdate() + "\n";
	            details += "Address: " + personsoap.getAddress();
	            return details;
        	}
            else return "Person with id " + i + " not found\n";

        }


    

    private static Vaccinations getVaccinationList() throws IOException {
        final URL url = new URL(BASE_URL + "list");
        final InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Vaccinations.class);
    }
}
