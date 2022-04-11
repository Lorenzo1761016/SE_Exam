
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

    private final static QName _Movie_QNAME = new QName("http://uniroma1.it/", "Movie");
    private final static QName _Movies_QNAME = new QName("http://uniroma1.it/", "Movies");
    private final static QName _GetDirectors_QNAME = new QName("http://uniroma1.it/", "getDirectors");
    private final static QName _GetDirectorsResponse_QNAME = new QName("http://uniroma1.it/", "getDirectorsResponse");
    private final static QName _GetMovies_QNAME = new QName("http://uniroma1.it/", "getMovies");
    private final static QName _GetMoviesResponse_QNAME = new QName("http://uniroma1.it/", "getMoviesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.uniroma1.generatedsource
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link Movies }
     * 
     */
    public Movies createMovies() {
        return new Movies();
    }

    /**
     * Create an instance of {@link GetDirectors }
     * 
     */
    public GetDirectors createGetDirectors() {
        return new GetDirectors();
    }

    /**
     * Create an instance of {@link GetDirectorsResponse }
     * 
     */
    public GetDirectorsResponse createGetDirectorsResponse() {
        return new GetDirectorsResponse();
    }

    /**
     * Create an instance of {@link GetMovies }
     * 
     */
    public GetMovies createGetMovies() {
        return new GetMovies();
    }

    /**
     * Create an instance of {@link GetMoviesResponse }
     * 
     */
    public GetMoviesResponse createGetMoviesResponse() {
        return new GetMoviesResponse();
    }

    /**
     * Create an instance of {@link DirectorMap }
     * 
     */
    public DirectorMap createDirectorMap() {
        return new DirectorMap();
    }

    /**
     * Create an instance of {@link DirectorEntry }
     * 
     */
    public DirectorEntry createDirectorEntry() {
        return new DirectorEntry();
    }

    /**
     * Create an instance of {@link Director }
     * 
     */
    public Director createDirector() {
        return new Director();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Movie }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Movie }{@code >}
     */
    @XmlElementDecl(namespace = "http://uniroma1.it/", name = "Movie")
    public JAXBElement<Movie> createMovie(Movie value) {
        return new JAXBElement<Movie>(_Movie_QNAME, Movie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Movies }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Movies }{@code >}
     */
    @XmlElementDecl(namespace = "http://uniroma1.it/", name = "Movies")
    public JAXBElement<Movies> createMovies(Movies value) {
        return new JAXBElement<Movies>(_Movies_QNAME, Movies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirectors }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDirectors }{@code >}
     */
    @XmlElementDecl(namespace = "http://uniroma1.it/", name = "getDirectors")
    public JAXBElement<GetDirectors> createGetDirectors(GetDirectors value) {
        return new JAXBElement<GetDirectors>(_GetDirectors_QNAME, GetDirectors.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDirectorsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDirectorsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://uniroma1.it/", name = "getDirectorsResponse")
    public JAXBElement<GetDirectorsResponse> createGetDirectorsResponse(GetDirectorsResponse value) {
        return new JAXBElement<GetDirectorsResponse>(_GetDirectorsResponse_QNAME, GetDirectorsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovies }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMovies }{@code >}
     */
    @XmlElementDecl(namespace = "http://uniroma1.it/", name = "getMovies")
    public JAXBElement<GetMovies> createGetMovies(GetMovies value) {
        return new JAXBElement<GetMovies>(_GetMovies_QNAME, GetMovies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoviesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMoviesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://uniroma1.it/", name = "getMoviesResponse")
    public JAXBElement<GetMoviesResponse> createGetMoviesResponse(GetMoviesResponse value) {
        return new JAXBElement<GetMoviesResponse>(_GetMoviesResponse_QNAME, GetMoviesResponse.class, null, value);
    }

}
