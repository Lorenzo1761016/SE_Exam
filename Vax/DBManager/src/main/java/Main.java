import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:" + args[0]);
        Statement stat = conn.createStatement();

        if (args[1].equals("create")) {
            stat.executeUpdate("drop table if exists vaccinations;");
            stat.executeUpdate("drop table if exists persons;");
            stat.executeUpdate("create table vaccinations (id, personid, date, type);");
            stat.executeUpdate("create table persons (pid, name, birthdate, address);");
            System.out.println("Created " + args[0]);
            
            //Add Persons
            PreparedStatement prepPeople = conn.prepareStatement("insert into persons values (?, ?, ?, ?);");

            prepPeople.setString(1, "1");
            prepPeople.setString(2, "Lorenzo Scarlino");
            prepPeople.setString(3, "02/03/1998");
            prepPeople.setString(4, "via Imera, 10");
            prepPeople.addBatch();
            conn.setAutoCommit(false);
            prepPeople.executeBatch();
            conn.setAutoCommit(true);
            
            prepPeople.setString(1, "2");
            prepPeople.setString(2, "Axel Hedfords");
            prepPeople.setString(3, "04/10/1985");
            prepPeople.setString(4, "Stockholm");
            prepPeople.addBatch();
            conn.setAutoCommit(false);
            prepPeople.executeBatch();
            conn.setAutoCommit(true);
            
            prepPeople.setString(1, "3");
            prepPeople.setString(2, "Josè Mourinho");
            prepPeople.setString(3, "18/07/1970");
            prepPeople.setString(4, "Porto");
            prepPeople.addBatch();
            conn.setAutoCommit(false);
            prepPeople.executeBatch();
            conn.setAutoCommit(true);
            
            prepPeople.setString(1, "4");
            prepPeople.setString(2, "Daniele Michelori");
            prepPeople.setString(3, "25/04/1997");
            prepPeople.setString(4, "Roma");
            prepPeople.addBatch();
            conn.setAutoCommit(false);
            prepPeople.executeBatch();
            conn.setAutoCommit(true);
            
            prepPeople.setString(1, "5");
            prepPeople.setString(2, "Mario Draghi");
            prepPeople.setString(3, "12/10/1964");
            prepPeople.setString(4, "Stockholm");
            prepPeople.addBatch();
            conn.setAutoCommit(false);
            prepPeople.executeBatch();
            conn.setAutoCommit(true);

            
            // Add Vax
            PreparedStatement prep = conn.prepareStatement("insert into vaccinations values (?, ?, ?, ?);");

            prep.setString(1, "1");
            prep.setString(2, "Lorenzo Scarlino");
            prep.setString(3, "07/12/2021");
            prep.setString(4, "Pfizer");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);

            prep.setString(1, "2");
            prep.setString(2, "Daniele Michelori");
            prep.setString(3, "13/02/2022");
            prep.setString(4, "AstraZeneca");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "3");
            prep.setString(2, "Daniele Michelori");
            prep.setString(3, "21/10/2021");
            prep.setString(4, "Pfizer");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);


            prep.setString(1, "4");
            prep.setString(2, "Mario Draghi");
            prep.setString(3, "01/02/2022");
            prep.setString(4, "Moderna");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);

            prep.setString(1, "5");
            prep.setString(2, "Josè Mourinho");
            prep.setString(3, "18/12/2021");
            prep.setString(4, "Pfizer");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "6");
            prep.setString(2, "Axel Hedfords");
            prep.setString(3, "24/11/2021");
            prep.setString(4, "Moderna");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);

            prep.setString(1, "7");
            prep.setString(2, "Lorenzo Scarlino");
            prep.setString(3, "05/04/2022");
            prep.setString(4, "Pfizer");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "8");
            prep.setString(2, "Axel Hedfords");
            prep.setString(3, "02/03/2022");
            prep.setString(4, "AstraZeneca");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            

        } else if (args[1].equals("all")) {
            ResultSet rs = stat.executeQuery("select * from vaccinations, persons where vaccinations.personid = persons.name");
            while (rs.next()) {
                System.out.print("Vaccination id:" + rs.getString("id") + " person: ");
                System.out.print(rs.getString("name")+ " ");
                System.out.print(" pid:"+rs.getString("pid")+ " ");
                System.out.print(rs.getString("birthdate")+ " ");
                System.out.print(rs.getString("address")+ " ");
                System.out.print(" vaccine: " + rs.getString("type") + " when: ");
                System.out.println(rs.getString("date"));
            }
            rs.close();
        } else {
        	ResultSet rs = stat.executeQuery("select * from vaccinations");
            while (rs.next()) {
                System.out.print("Vaccination = " + rs.getString("id") + " person: ");
                System.out.print(rs.getString("personid"));
                System.out.print(" pid: "+rs.getString("pid"));
                System.out.print(" vaccine: " + rs.getString("type") + " when: ");
                System.out.println(rs.getString("date"));
            }
            rs.close();
        }
        conn.close();

    }
}
