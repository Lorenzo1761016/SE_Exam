
package it.uniroma1.generatedsource;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.uniroma1.generatedsource package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPersonDetails_QNAME = new QName("http://soapws.uniroma1.it/", "getPersonDetails");
    private final static QName _GetPersonDetailsResponse_QNAME = new QName("http://soapws.uniroma1.it/", "getPersonDetailsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.uniroma1.generatedsource
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPersonDetails }
     * 
     */
    public GetPersonDetails createGetPersonDetails() {
        return new GetPersonDetails();
    }

    /**
     * Create an instance of {@link GetPersonDetailsResponse }
     * 
     */
    public GetPersonDetailsResponse createGetPersonDetailsResponse() {
        return new GetPersonDetailsResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonDetails }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersonDetails }{@code >}
     */
    @XmlElementDecl(namespace = "http://soapws.uniroma1.it/", name = "getPersonDetails")
    public JAXBElement<GetPersonDetails> createGetPersonDetails(GetPersonDetails value) {
        return new JAXBElement<GetPersonDetails>(_GetPersonDetails_QNAME, GetPersonDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonDetailsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPersonDetailsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soapws.uniroma1.it/", name = "getPersonDetailsResponse")
    public JAXBElement<GetPersonDetailsResponse> createGetPersonDetailsResponse(GetPersonDetailsResponse value) {
        return new JAXBElement<GetPersonDetailsResponse>(_GetPersonDetailsResponse_QNAME, GetPersonDetailsResponse.class, null, value);
    }

}
