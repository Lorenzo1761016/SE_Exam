package it.uniroma1.client;

//import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Vaccination")
public class Vaccination {
    private String id;
    private String person;
    private String date;
    private String type;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Vaccination [id=" + id + ", person=" + person + ", date=" + date + ", type=" + type + "]";
	}
    
    
}
