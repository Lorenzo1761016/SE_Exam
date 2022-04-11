

package esame;


import esame.Libro;
import esame.Autore;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
 
import esame.TuttiLibriImpl;




public class ServerMain {

    public static void main (String[] args) throws IOException, InterruptedException{
        
       
        
        
        
        //Server avviazione
        Server server_mio;
        server_mio= ServerBuilder.forPort(420).addService(new TuttiLibriImpl()).build();
                
        server_mio.start();
        System.out.println("SERVER PRONTO");
        server_mio.awaitTermination();
        
        
        
        
    }
    
    
    
}
