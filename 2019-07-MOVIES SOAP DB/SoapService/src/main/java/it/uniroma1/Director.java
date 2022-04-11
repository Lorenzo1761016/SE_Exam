/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author biar
 */
@XmlJavaTypeAdapter(DirectorAdapter.class)
public interface Director {
    public String getId();
    public String getName();
    public String getYear();
    public void setId(String id);
    public void setName(String name);
    public void setYear(String year);
}
