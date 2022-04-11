package it.uniroma1.restserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            conn
                    = DriverManager.getConnection("jdbc:sqlite:"+pos);
        } catch (SQLException ex) {
            Logger.getLogger(VaccinationRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("{vaccinationId}")
    @Produces("application/json")
    public Vaccination getVaccination(@PathParam("vaccinationId") String vaccinationId) {

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
        try {
            stat = conn.prepareStatement("select * from vaccinations");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                fl = new Vaccination();
                fl.setId(rs.getString("id"));
                fl.setPerson(rs.getString("person"));
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
    
    
    /*
    @PUT
    @Path("{vaccinationId}")
    @Consumes("application/json")
    public Response updateVaccination(@PathParam("vaccinationId") String vaccinationId, Vaccination vaccination) {
        Vaccination existing = findById(vaccinationId);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (existing.equals(vaccination)) {
            return Response.notModified().build();
        }
        update(vaccinationId, vaccination);
        return Response.ok().build();
    }*/

    private Vaccination findById(String id) {
        
        PreparedStatement stat = null;
        Vaccination vc = null;
        try {
            stat = conn.prepareStatement("select * from vaccinations where id = ?");
            stat.setString(1, String.valueOf(id));
        
        ResultSet rs = stat.executeQuery();
        if (rs.next()) {
            vc = new Vaccination();
            vc.setId(rs.getString("id"));
            vc.setPerson(rs.getString("person"));
            vc.setDate(rs.getString("date"));
            vc.setType(rs.getString("type"));
            Logger.getLogger(VaccinationRepository.class.getName()).log(Level.INFO, "Accessed : " + vc);
        }
        rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(VaccinationRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return vc;   
    }
    
    /*private void update(String vaccinationId, Vaccination vc)
    {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement("update vaccinations set person = ? set date = ? set type = ? where id = ?");
            stat.setString(1, vc.getId());
            stat.setString(2, vc.getPerson());
            stat.setString(3, vc.getDate());
            stat.setString(4, vc.getType());
            
        
        int affectedRow = stat.executeUpdate();
        if (affectedRow == 1) {
            Logger.getLogger(VaccinationRepository.class.getName()).log(Level.INFO, "Updated : " + vc);
            return;
        }    
        else throw new RuntimeException();
        }
        catch (Exception ex) {
            Logger.getLogger(VaccinationRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}