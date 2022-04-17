package it.uniroma1.soapws;

import javax.xml.ws.Endpoint;

public class Server {

    public static void main(String args[]) {
        WSImpl implementor = new WSImpl();
        String address = "http://localhost:7070/WSInterface";
        Endpoint.publish(address, implementor);
        System.out.println("SOAPServer ready...");
    }
}
