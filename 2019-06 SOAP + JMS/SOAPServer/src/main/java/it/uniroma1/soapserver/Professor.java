/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.soapserver;

/**
 *
 * @author biar
 */

public class Professor {
    private String name, surname, id;

    public Professor(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;  
    }

    public Professor() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Professor{" + "name=" + this.name + ", surname=" + this.surname + ", id=" + this.id + '}';
    }
    
}
