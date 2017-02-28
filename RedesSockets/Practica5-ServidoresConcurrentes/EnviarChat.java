import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * Write a description of class EnviarChat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnviarChat  extends Thread
{
    private Socket s;
    public EnviarChat(Socket s)
    {
        this.s =s;
    }

    public void run(){
        try {
            Scanner lee = new Scanner(System.in);
            PrintWriter escribe = new PrintWriter(s.getOutputStream()); // segundo parametro autoFlussh(bool)

            while(true){
                escribe.println("Stronquens se conecto\n");
                escribe.flush(); 
                while(lee.hasNextLine()) {
                    String frase = lee.nextLine();
                    if (frase.equalsIgnoreCase("fin")){
                        escribe.println("Stronquens salio :(");
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

