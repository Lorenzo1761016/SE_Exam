
package it.uniroma1.generatedsource;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSImplService", targetNamespace = "http://soapws.uniroma1.it/", wsdlLocation = "http://localhost:7070/WSInterface?wsdl")
public class WSImplService
    extends Service
{

    private final static URL WSIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException WSIMPLSERVICE_EXCEPTION;
    private final static QName WSIMPLSERVICE_QNAME = new QName("http://soapws.uniroma1.it/", "WSImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:7070/WSInterface?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSIMPLSERVICE_WSDL_LOCATION = url;
        WSIMPLSERVICE_EXCEPTION = e;
    }

    public WSImplService() {
        super(__getWsdlLocation(), WSIMPLSERVICE_QNAME);
    }

    public WSImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSIMPLSERVICE_QNAME, features);
    }

    public WSImplService(URL wsdlLocation) {
        super(wsdlLocation, WSIMPLSERVICE_QNAME);
    }

    public WSImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSIMPLSERVICE_QNAME, features);
    }

    public WSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSInterface
     */
    @WebEndpoint(name = "WSImplPort")
    public WSInterface getWSImplPort() {
        return super.getPort(new QName("http://soapws.uniroma1.it/", "WSImplPort"), WSInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSInterface
     */
    @WebEndpoint(name = "WSImplPort")
    public WSInterface getWSImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soapws.uniroma1.it/", "WSImplPort"), WSInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSIMPLSERVICE_EXCEPTION!= null) {
            throw WSIMPLSERVICE_EXCEPTION;
        }
        return WSIMPLSERVICE_WSDL_LOCATION;
    }

}
