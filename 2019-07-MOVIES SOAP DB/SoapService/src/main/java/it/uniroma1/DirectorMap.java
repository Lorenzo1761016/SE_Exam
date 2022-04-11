/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author biar
 */
@XmlType(name = "DirectorMap")
public class DirectorMap {

    private List<DirectorEntry> entries = new ArrayList<DirectorEntry>();
    
    public DirectorMap() {}

    @XmlElement(nillable = false, name = "entry")
    public List<DirectorEntry> getEntries() {
        return entries;
    }

    @XmlType(name = "DirectorEntry")
    public static class DirectorEntry {

        private String id;
        private Director director;

        public String getId() { return id; }
        public Director getDirector () { return director; }
     
        public void setId(String i) { id = i; }
        public void setDirector(Director s) { director = s; }
        
    }
}
