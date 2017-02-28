import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ClienteChat {

    public static void main(String argv[]) throws UnknownHostException, IOException {
    
           try {
            Socket s = new Socket("rdc00.redes.upv.es", 7777);
            System.out.println("Conectado\r\n");
            
            EnviarChat ec = new EnviarChat(s);
            RecibirChat rc = new RecibirChat(s);
            rc.start();
            ec.start();
            while(true){} // si termina el main antes q los hilos no ocurrira nada
            //s.close();
            //System.out.println("Desconectado");
        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor desconocido");
        } catch (IOException e) {
            System.out.println("No es posible establecer la conexion");
        }
    }
    
    }
