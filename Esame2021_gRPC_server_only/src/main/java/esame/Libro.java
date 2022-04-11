

package esame;

import esame.Autore;

public class Libro {

    public String titolo;
    public String annoPubblicazione;
    public String id;
    
    Autore autore;
    
    
    
    public Libro (String titolo, Autore autore, String annoPubblicazione, String id){
     this.annoPubblicazione=annoPubblicazione;  
     this.titolo=titolo;
     this.id=id;
     this.autore=autore;
    }
    
    
    public String getTitolo() {
      return this.titolo;
              }
    public String getAutore() {
      return this.autore.getAutore();
              }
    public String getAnno() {
      return this.annoPubblicazione;
              }
    public String getAnnoNascita (){
      String annoNascita=this.autore.getAnnoNascita();
      return annoNascita;
              }
    
}
