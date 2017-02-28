import java.net.*;
import java.io.*;
import java.util.*;

public class Servicio extends Thread {
    public Servicio(Socket s){
        try {
            System.out.println("Conectado");
            Scanner lee = new Scanner(s.getInputStream());
            PrintWriter escribe = new PrintWriter(s.getOutputStream()); // segundo parametro autoFlussh(bool)

            while(true){
                escribe.println("Escribe\n");
                escribe.flush(); 
                while(lee.hasNextLine()) {
                    String frase = lee.nextLine();
                    if (frase.equalsIgnoreCase("fin")){
                        escribe.println("GoodBye!");
                        escribe.flush(); 
                        s.close();
                    }
                    escribe.println(frase);
                    escribe.flush(); 
                }            
            }

        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor desconocido");
        } catch (IOException e) {
            System.out.println("No es posible establecer la conexion");
        }
    }

}