/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;


import esame.Libro;
import java.util.*;

/**
 *
 * @author giann
 */
public class Autore {
    public String nome;
    public String cognome;
    public String annoNascita;
    public List<Libro> libriScritti;
           
           
            
            
            
    public Autore (String nome, String cognome, String annoNascita){
        this.nome=nome;
        this.cognome=cognome;
        this.annoNascita=annoNascita;
    }

    
    public String getNome(){
        return this.nome;
    }
    
     public String getCognome(){
        return this.cognome;
    }
    
    
     public String getAutore(){
         String autore="";
         autore = autore + this.nome + " "+ this.cognome;
         return autore;
         
     }
    public String getAnnoNascita(){
        return this.annoNascita;
    }
    
    
    
//    public void ScriviLibro(String nomeLibro, String ){}
    
    
}
