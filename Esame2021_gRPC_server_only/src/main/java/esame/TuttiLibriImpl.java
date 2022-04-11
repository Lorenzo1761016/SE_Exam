

package esame;

import io.grpc.stub.StreamObserver;
//import proto.TuttiLibri;
import proto.DettagliLibro;
import proto.IdLibro;  
       
import proto.NumeroLibri;
import proto.Ciao;  

import esame.Libro;
import esame.Autore;        
        
import proto.TuttoGrpc.TuttoImplBase;
import proto.TuttoGrpc;




import java.util.*;





public class TuttiLibriImpl extends TuttoImplBase {


      public void unlibro( IdLibro idLibro, StreamObserver<DettagliLibro> osservatore){
   
        String id = idLibro.getId().toString();
       
        List<Libro> listaLibri= new ArrayList<Libro>();
        List indici = new ArrayList<>();       
        //Creazione Autore e Libro
        String nome1="Nome1";
        String cognome1="Cognome1";
        String annoNascita1="1998";
        Autore gianni = new Autore(nome1, cognome1, annoNascita1);
       
        
        String ID1="1";
        String titolo1="TITOLO1";
        String annoPubblicazione1 = "2020";
        Libro a = new Libro(titolo1, gianni, annoPubblicazione1, ID1);
        
        listaLibri.add(a);
        indici.add(ID1);
        
         String nome2="Nome2";
        String cognome2="Cognome2";
        String annoNascita2="1996";
        Autore carlo = new Autore(nome2, cognome2, annoNascita2);
       
        
        String ID2="2";
        String titolo2="FABIO tttttttttttttttttttt";
        String annoPubblicazione2 = "1111";
        Libro b= new Libro(titolo2, carlo, annoPubblicazione2, ID2);
        
        listaLibri.add(b);
        indici.add(ID2);
        
        Libro risultato=new Libro("2",carlo,"2","2");
        
        
        
        
        
        System.out.println("Ricevuto id libro dal client: " + id + " Tipo variabile: " + id.getClass().getName());
        for (int i=0; i<2;i++){
            String idd= indici.get(i).toString();
            Libro libro= listaLibri.get(i);
           
    
           
            int idclient = Integer.parseInt(id);
            int idlibro = Integer.parseInt(idd);
            
            System.out.println("provo uguaglianza con libro: " + idlibro );
            System.out.println("provo uguaglianza con IDCLIENT: " + idclient );
            
            
             System.out.println(" sto per entrare in if fino alla lunghezza di listaLibri.lenght() "  + listaLibri.size());
            if  (idclient==idlibro){
             System.out.println(" entrato in if id =2:  ");
                System.out.println("ID LIBRO TROVATO: " + idlibro);
       
                
                 DettagliLibro risposta2 = DettagliLibro.newBuilder().setTitolo(libro.getTitolo()).setAutore(libro.getAutore()).setAnno(libro.getAnno()).setAnnonascita(libro.getAnnoNascita()).build();
                 osservatore.onNext(risposta2);
                 osservatore.onCompleted();
                System.out.println("RISPOSTA SCRITTA");
       
            }
           // else  {System.out.println(" PROBLEMA!!!  ");}
            
        }
  /* if (risultato==null){
            DettagliLibro risposta = DettagliLibro.newBuilder().setTitolo(risultato.getTitolo()).setAutore(risultato.getAutore()).setAnno(risultato.getAnno()).setAnnonascita(risultato.getAnnoNascita()).build();
                 osservatore.onNext(risposta);
                 osservatore.onCompleted();
                System.out.println("RISPOSTA NULLA SCRITTA");
                
        System.out.println("LIBRO NON TROVATO");
      }
        */
        
        System.out.println("FINE RICERCA"); 
        
    }
    
    





///////////////////    SECONDO METODO   /////////////////////////////////


public void damminumero( Ciao ciao, StreamObserver<NumeroLibri> osservatore){





List<Libro> listaLibri= new ArrayList<Libro>();
        List indici = new ArrayList<>();

      
        //Creazione Autore e Libro
        String nome1="Nome1";
        String cognome1="Cognome1";
        String annoNascita1="1998";
        Autore gianni = new Autore(nome1, cognome1, annoNascita1);
       
        
        String ID1="1";
        String titolo1="Titolo1";
        String annoPubblicazione1 = "2020";
        Libro a = new Libro(titolo1, gianni, annoPubblicazione1, ID1);
        
        listaLibri.add(a);
        indici.add(ID1);
        
         String nome2="Nome2";
        String cognome2="Cognome2";
        String annoNascita2="1996";
        Autore carlo = new Autore(nome2, cognome2, annoNascita2);
       
        
        String ID2="2";
        String titolo2="FABIO tttttttttttttttttttt";
        String annoPubblicazione2 = "1111";
        Libro b= new Libro(titolo2, carlo, annoPubblicazione2, ID2);
        
        listaLibri.add(b);
        indici.add(ID2);
        

        

                 String grandezzalista =Integer.toString(listaLibri.size());


                NumeroLibri risposta = NumeroLibri.newBuilder().setNumero(grandezzalista).build();
                 osservatore.onNext(risposta);
                 osservatore.onCompleted();
                System.out.println("RISPOSTA SCRITTA");

}












}


