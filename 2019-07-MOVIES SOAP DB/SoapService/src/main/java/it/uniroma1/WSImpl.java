package it.uniroma1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;



@WebService(endpointInterface = "it.uniroma1.WSInterface")
public class WSImpl implements WSInterface {
    private Movies movies = new Movies();
    private Map<String,Director> directors = new LinkedHashMap<String,Director>();

    private Connection conn;
    
    // Connect to DB
    public void setConnection(String pos) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {}
            conn = DriverManager.getConnection("jdbc:sqlite:"+pos);
        } catch (SQLException ex) {}
    }
    
    public WSImpl() {
        this.setConnection("/home/biar/movieDB.db");  //path database (da modificare sempre) 
    }
        
    @Override
    public Map<String,Director> getDirectors() {
        
    	PreparedStatement stat = null;
        Director d = null;
       
        try {
            stat = conn.prepareStatement("select * from directors");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                d = new DirectorImpl();
                d.setId(rs.getString("directorId"));
                d.setName(rs.getString("name"));
                d.setYear(rs.getString("yearOfBirth"));
                directors.put(d.getId(), d);
            }
            rs.close();
        } catch (SQLException ex) {}
        
        return directors;
    }
    
    @Override
    public Movies getMovies(){
        PreparedStatement stat = null;
      
        try{
            stat = conn.prepareStatement("select * from movies");
            ResultSet rs = stat.executeQuery();
            rs = stat.executeQuery();
            while (rs.next()){
                Movie m = new Movie();
                m.setId(rs.getString("movieId"));
                m.setTitle(rs.getString("title"));
                m.setYear(rs.getString("year"));
                m.setDirector(rs.getString("directorId"));
                movies.addMovie(m);
            }    
            rs.close();
          
        } catch (SQLException ex) {}
        
        
        return movies;
    }
}
