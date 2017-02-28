import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;
/**
 * Write a description of class RecibirChat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecibirChat  extends Thread
{
    private Socket s;
    public RecibirChat(Socket s)
    {
        this.s = s;
    }

    public void run(){
        try {
            Scanner lee = new Scanner(s.getInputStream());
            while(true){
                while(lee.hasNextLine()) {
                    String frase = lee.nextLine();
                    System.out.println(frase);
                }            
            }

        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor desconocido");
        } catch (IOException e) {
            System.out.println("No es posible establecer la conexion");
        }

    }

}
