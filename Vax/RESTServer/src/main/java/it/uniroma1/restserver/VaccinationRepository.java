package it.uniroma1.restserver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;

@Path("/vaccinations")
@Produces("text/xml")
public class VaccinationRepository {

    private Connection conn;

    
    
    public void setConnection(String pos) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VaccinationRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection("jdbc:sqlite:"+pos);
            System.out.println("Connected to "+pos);
        } catch (SQLException ex) {
            Logger.getLogger(VaccinationRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{vaccinationId}")
    public Vaccination getVaccination(@PathParam("vaccinationId") int vaccinationId) {
        return findById(vaccinationId);
    }

    @GET
    @Path("/list")
    public Vaccinations getVaccinations() {
        return findAll();
    }

    private Vaccinations findAll() {
        PreparedStatement stat = null;
        Vaccination fl = null;
        List<Vaccination> list = new ArrayList<>();
    	System.out.println("OK");
        try {
            stat = conn.prepareStatement("select * from vaccinations");
        	System.out.println("OK");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                fl = new Vaccination();
                fl.setId(rs.getString("id"));
                fl.setPersonid(rs.getString("personid"));
                fl.setDate(rs.getString("date"));
                fl.setType(rs.getString("type"));
                list.add(fl);
                Logger.getLogger(VaccinationRepository.class.getName()).log(Level.INFO, "Accessed : " + fl);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(VaccinationRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Vaccinations(list);
    }
    private Vaccination findById(int id) {
        PreparedStatement stat = null;
        Vaccination fl = null;
        try {
            stat = conn.prepareStatement("select * from vaccinations where id = ?");
            stat.setString(1, String.valueOf(id));
            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                fl = new Vaccination();
                fl.setId(rs.getString("id"));
                fl.setPersonid(rs.getString("personid"));
                fl.setDate(rs.getString("date"));
                fl.setType(rs.getString("type"));    
                Logger.getLogger(VaccinationRepository.class.getName()).log(Level.INFO, "Accessed : " + fl);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(VaccinationRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fl;
    }

}