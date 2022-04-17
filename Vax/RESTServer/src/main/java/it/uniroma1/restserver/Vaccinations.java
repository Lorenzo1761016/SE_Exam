package it.uniroma1.restserver;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Vaccinations")
public class Vaccinations {
    private List<Vaccination> vaccinations;

    public Vaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }
    public Vaccinations() {
        this.vaccinations = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Vaccinations{" +
                "vaccinations=" + vaccinations.toString() +
                '}';
    }

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }
}