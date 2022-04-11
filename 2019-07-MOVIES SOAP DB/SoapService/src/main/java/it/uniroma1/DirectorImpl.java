/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author biar
 */
@XmlType(name = "Director")
public class DirectorImpl implements Director {
    private String id, name, year;
   
    public DirectorImpl() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Director{" + "id=" + id + ", name=" + name + ", year=" + year + '}';
    }

    public DirectorImpl(String id, String name, String year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }
    
}