import java.net.*;
import java.io.*;
import java.util.*;

public class TcpEchoText extends Thread
{
    private Socket s;
    public TcpEchoText(Socket s){
        this.s = s;
    }

    public void run(){
        
        try {
            Scanner lee = new Scanner(s.getInputStream());
            PrintWriter escribe = new PrintWriter(s.getOutputStream());
            
            while(true){
                while(lee.hasNextLine()) {
                    String frase = lee.nextLine();
                    
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
