package it.uniroma1.soapws;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;
import java.util.Objects;

@XmlRootElement
public class Person {
    private String pid;
    private String name;
    private String birthdate;
    private String address;

    

    public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
		this.pid = pid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBirthdate() {
		return birthdate;
	}



	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public int hashCode() {
		return Objects.hash(address, birthdate, name, pid);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(birthdate, other.birthdate)
				&& Objects.equals(name, other.name) && Objects.equals(pid, other.pid);
	}



	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", birthdate=" + birthdate + ", address=" + address + "]";
	}



	
}
