import java.net.*;
import java.io.*;
import java.util.*;

public class Server
{
    public static void main(String args[]) {
        try{
            ServerSocket ss=new ServerSocket(7777);
            while(true) {
                Socket s = ss.accept(); // espera una conexión de un cliente

                PrintWriter envia=new PrintWriter(s.getOutputStream());    
                Scanner recibe = new Scanner(s.getInputStream());

                Calendar now = Calendar.getInstance();
                int h = now.get(Calendar.HOUR_OF_DAY); 
                int m = now.get(Calendar.MINUTE);
                int se = now.get(Calendar.SECOND); 

                envia.printf("Hora Actual: " + h + ":" + m + ":"+ se +"\r\n");

                envia.flush();
                s.close();
            }
        }catch(IOException e) {
            System.out.println(e);
        } //catch
    } // main

    public static void main2(String args[]) {
        try{
            ServerSocket ss=new ServerSocket(7777);
            while(true) {
                Socket s = ss.accept(); // espera una conexión de un cliente

                PrintWriter envia=new PrintWriter(s.getOutputStream());    
                Scanner recibe = new Scanner(s.getInputStream());

                envia.printf("HTTP/1.0 200 OK \r\n");
                envia.printf("Content-Type: text/plain \r\n\r\n");

                while(recibe.hasNextLine()){
                    String linea = recibe.nextLine();
                    if("".equalsIgnoreCase(linea)){
                        break;
                    }
                    envia.printf(linea + "\r\n");

                }

                envia.flush();
                s.close();
            }
        }catch(IOException e) {
            System.out.println(e);
        } //catch
    } // main
}
