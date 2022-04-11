package it.uniroma1;
import javax.xml.ws.Endpoint;

public class SoapServer {

    public static void main(String args[]) {
        WSImpl implementor = new WSImpl();
        String address = "http://0.0.0.0:7070/WSInterface";
        Endpoint.publish(address, implementor);
        System.out.println("SOAP Webservice ready...\n");
    }
}
