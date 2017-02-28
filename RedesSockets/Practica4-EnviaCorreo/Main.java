import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.net.ssl.SSLSocketFactory;
public class Main
{

    public Main()
    {
        try {
            Socket s = new Socket("smtp.upv.es", 25);
            System.out.println("Conectado");
            Scanner lee = new Scanner(s.getInputStream());
            PrintWriter escribe = new PrintWriter(s.getOutputStream()); // segundo parametro autoFlussh(bool)
            // Imprimimos primera linea
            System.out.println(lee.nextLine());  
            // Escribimos peticion
            escribe.println("HELO upv.es");
            escribe.flush(); 

            String salida = lee.nextLine();
            System.out.println(salida);
            if(!salida.startsWith("250",0)){
                escribe.println("quit");
                escribe.flush();
            }
            escribe.println("mail from: stronquens@gmail.com");
            escribe.flush(); 

            salida = lee.nextLine();
            System.out.println(salida);
            if(!salida.startsWith("250",0)){
                escribe.println("quit");
                escribe.flush();
            }

            escribe.println("rcpt to: stronquens@gmail.com");
            escribe.flush(); 

            salida = lee.nextLine();
            System.out.println(salida);
            if(!salida.startsWith("250",0)){
                escribe.println("quit");
                escribe.flush();
            }

            escribe.println("data");
            escribe.flush();
            salida = lee.nextLine();
            System.out.println(salida);
            if(!salida.startsWith("354",0)){
                escribe.println("quit");
                escribe.flush();
            }

            escribe.println("From: stronquens@gmail.com");
            escribe.flush(); 
            escribe.println("To: stronquens@gmail.com");
            escribe.flush(); 
            escribe.println("Subject: Prueba");
            escribe.flush(); 
            escribe.println("Este es un correo de prueba con texto en el cuerpo");
            escribe.flush(); 
            escribe.println(".");
            escribe.flush(); 
            salida =  lee.nextLine();
            System.out.println(salida);
            if(!salida.startsWith("250",0)){
                escribe.println("quit");
                escribe.flush();
            }
            
            escribe.println("quit");
            escribe.flush();
            salida =  lee.nextLine();
            System.out.println(salida);

            s.close();
            System.out.println("Desconectado");
        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor desconocido");
        } catch (IOException e) {
            System.out.println("No es posible establecer la conexion");
        }

    }

}
