package it.uniroma1.soapws;
import javax.jws.WebService;

@WebService
public interface WSInterface {
    public Person getPersonDetails(String id);
}
