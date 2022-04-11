package it.uniroma1.soapws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.LinkedHashMap;
import javax.jws.WebService;



@WebService(endpointInterface = "it.uniroma1.soapws.WSInterface")
public class WSImpl implements WSInterface {
	
    /*private Map<String,Person> persons = new LinkedHashMap<String,Person>();
    
    public WSImpl() {
    	
    	Person p0 = new Person("00000000","Giorgio","Napolitano","01/01/1918","Via della Scrofa 12");
    	Person p1 = new Person("00000001","Daniele","Michelori","25/04/1997","Via Genzano 99");
    	Person p2 = new Person("00000010","Fabrizio","D'amore","13/02/1965","Piazza Euclide 76");
    	Person p3 = new Person("00000011","Damiano","Er Faina","23/05/1983","Via della Magliana 5");
    	Person p4 = new Person("00000100","Luca","Ravenna","19/06/1986","Viale Gottardo 2");
    	Person p5 = new Person("00000101","Ilaria","Ponzianelli","28/07/1997","Via di San Basilio 1144");
    	Person p6 = new Person("00000110","Gianmarco","Salvi","10/10/1997","Piazza filattiera 12");
    	Person p7 = new Person("00000111","Elisabetta","Canalis","12/09/1972","Via del Corso 113");
    	Person p8 = new Person("00001000","Belen","Rodriguez","01/06/1980","Piazza Sempione 19");
    	Person p9 = new Person("00001001","Samuele","Olivieri Pennesi","20/06/1997","Via Ottaviano 57");
    	
    	persons.put(p0.getId(), p0);
    	persons.put(p1.getId(), p1);
    	persons.put(p2.getId(), p2);
    	persons.put(p3.getId(), p3);
    	persons.put(p4.getId(), p4);
    	persons.put(p5.getId(), p5);
    	persons.put(p6.getId(), p6);
    	persons.put(p7.getId(), p7);
    	persons.put(p8.getId(), p8);
    	persons.put(p9.getId(), p9);
    	
    }

	@Override
	public Person getPersonDetails(String id) {
		Person p = null;
		p = persons.get(id);
		return p;
	}*/
        
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
    
    public WSImpl() {this.setConnection("/home/biar/vaccinations.db");}
        
    @Override
    public Person getPersonDetails(String id) {
    	PreparedStatement stat = null;
        Person p = null;
        try {
            stat = conn.prepareStatement("select * from persons where id = ?");
            stat.setString(1, id);
            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                p = new Person();
                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setSurname(rs.getString("surname"));
                p.setBirthdate(rs.getString("birthdate"));
                p.setAddress(rs.getString("address"));
            }
            rs.close();
        } catch (SQLException ex) {}
        return p;
    }

}