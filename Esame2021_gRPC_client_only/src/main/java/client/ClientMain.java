/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;



import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import proto.IdLibro;
import proto.DettagliLibro;


import proto.Ciao;
import proto.NumeroLibri;
//import proto.TuttiLibri;       
import proto.TuttoGrpc;
        
        
public class ClientMain {

    public static void main (String[] args){
        
   
     ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 420)  //apro canale di comunicazione all indirizzo IP localhost e porta 8080 per vedere che servizio (stub) c'� li
            .usePlaintext()  //sto usando stringhe e non binario
            .build();
    
     TuttoGrpc.TuttoBlockingStub interfaccia   //(stessa cosa anche in pythin) creo l oggetto stub localmente attraverso delle classi precompilate (nota nome classe = nome Servizio proto)
          = TuttoGrpc.newBlockingStub(channel);
    
     
     
     
     
      Ciao ciao= Ciao.newBuilder().setCliente("LEBON").build();
    
    
  
     System.out.println("Mando richiesta al Server");
    NumeroLibri risposta1 = interfaccia.damminumero(ciao);
     int numerolibri = Integer.parseInt(risposta1.getNumero());

     for (int j=0; j<numerolibri;j++){
         int h=j+1;
         System.out.println("LIBRO NUMERO "+ h );
         int indice = j+1;
         IdLibro ID= IdLibro.newBuilder().setId(Integer.toString(indice)).build();
    
     System.out.println("Mando richiesta al Server per vedere libro numero " + indice);
    DettagliLibro risposta2 = interfaccia.unlibro(ID);
    
     System.out.println("Risposta del Server per libro numero: " + indice+" NOME LIBRO " + risposta2.getTitolo() + " AUTORE: " + risposta2.getAutore() + " ANNO PUBBLICAZIONE: " + risposta2.getAnno() + " ANNO NASCITA AUTORE: "  +risposta2.getAnnonascita()          );
    
         
     }
     System.out.println("FINE LISTA");
     
     
     
     
    // We saluto = We.newBuilder().setNome("Fabio").setCognome("De Bellis").build();
    
    String id= "2";
    IdLibro ID= IdLibro.newBuilder().setId(id).build();
    
    
  
     System.out.println("Mando richiesta al Server");
    DettagliLibro risposta = interfaccia.unlibro(ID);
     System.out.println("Richeista mandata");
    System.out.println("Risposta del Server: NOME LIBRO " + risposta.getTitolo() + " AUTORE: " + risposta.getAutore() + " ANNO PUBBLICAZIONE: " + risposta.getAnno() + " ANNO NASCITA AUTORE: "  +risposta.getAnnonascita()          );
         
    
    
     channel.shutdown();
    
    
    } 

       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
