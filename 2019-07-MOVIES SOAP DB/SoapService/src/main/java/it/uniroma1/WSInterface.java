package it.uniroma1;
import java.util.Map;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@WebService
public interface WSInterface {
    public Movies getMovies();
    
    @XmlJavaTypeAdapter(DirectorMapAdapter.class)
    public Map<String,Director> getDirectors();
}
