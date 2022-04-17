package it.uniroma1.soapws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jws.WebService;


@WebService(endpointInterface = "it.uniroma1.soapws.WSInterface")
public class WSImpl implements WSInterface {

	private Connection conn;

    
    // Connect to DB
    public void setConnection() {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {}
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/lol-l/Desktop/Vaccinations.db");
            System.out.println("Connected");
        } catch (SQLException ex) {
        	System.out.println("ERRORRRR");
        	ex.printStackTrace();
        }
    }
    
    public WSImpl() {this.setConnection();}
    
    @Override
    public Person getPersonDetails(String pid) {
    	PreparedStatement stat = null;
        Person p = null;
        System.out.println("P created");
        try {
            stat = conn.prepareStatement("select * from persons where pid=?");
            stat.setString(1, pid);
            System.out.println("PID SET");
            ResultSet rs = stat.executeQuery();
            System.out.println("QUERY EXECUTED");

            if (rs.next()) {
                p = new Person();
                p.setPid(rs.getString("pid"));
                p.setName(rs.getString("name"));
                p.setBirthdate(rs.getString("birthdate"));
                p.setAddress(rs.getString("address"));
            }
            rs.close();
        } catch (SQLException ex) {}
        return p;
    }
}
   