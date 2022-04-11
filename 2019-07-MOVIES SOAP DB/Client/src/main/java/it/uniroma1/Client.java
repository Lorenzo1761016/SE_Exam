package it.uniroma1;

import it.uniroma1.generatedsource.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class Client {
    // Needed for SOAP
    private static final WSImplService service = new WSImplService();
    private static final WSInterface port = service.getWSImplPort();

    public static void main(String[] args) throws IOException {
        // SOAP MOVIES
        Movies movies = port.getMovies();
        List<DirectorEntry> directors = port.getDirectors().getEntry();
        
        List<Movie> m_list = movies.getMovies();
        StringBuilder str = new StringBuilder();
       
        LinkedHashMap<String,Director> dir_map = new LinkedHashMap<String,Director>();
        
        for(int i=0; i<directors.size(); i++){
            Director d = directors.get(i).getDirector();
            String id = directors.get(i).getId();
            dir_map.put(id,d);
        }
        
        for(int i=0; i<m_list.size(); i++){
            Movie m = m_list.get(i);
            Director d = dir_map.get(m.getDirector());
            String movie = "MOVIE - Id: " + m.getId() + "  Title: " + m.getTitle() + " Year: " + m.getYear() + " DirectorId: " + m.getDirector();
            String director = " ************ DIRECTOR - Id: " + d.getId() + " Name: " + d.getName() + " YearOfBirth: " + d.getYear() + "\n";
            str.append(movie).append(director);
        }
        
        System.out.print(str.toString());
    }
}
