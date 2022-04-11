/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1.soapserver;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author biar
 */
public class Professors {
    private static Map<String,Professor> professors = new LinkedHashMap<String,Professor>();
      

    public static Map<String, Professor> getProfessors() {
        return professors;
    }

    public static void setProfessors(Map<String, Professor> professors) {
        professors = professors;
    }
    
    public static Professor getProfessor(String id){
        return professors.get(id);
    }
    
    public static void addProfessor(Professor p){
        professors.put(p.getId(), p);
    }
    
}
