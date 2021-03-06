
package it.uniroma1.generatedsource;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WSInterface", targetNamespace = "http://soapws.uniroma1.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSInterface {


    /**
     * 
     * @param arg0
     * @return
     *     returns it.uniroma1.generatedsource.Person
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPersonDetails", targetNamespace = "http://soapws.uniroma1.it/", className = "it.uniroma1.generatedsource.GetPersonDetails")
    @ResponseWrapper(localName = "getPersonDetailsResponse", targetNamespace = "http://soapws.uniroma1.it/", className = "it.uniroma1.generatedsource.GetPersonDetailsResponse")
    public Person getPersonDetails(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
