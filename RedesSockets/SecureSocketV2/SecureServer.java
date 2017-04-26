import java.net.*;
import java.io.*;
import java.util.*;

import javax.net.*;
import javax.net.ssl.*;
import javax.net.ssl.SSLServerSocketFactory;

public class SecureServer extends Thread {

    private int port;

    public SecureServer(int port){
        this.port = port;
    }

    public void run() {
        try{
            ServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            ServerSocket ss = ssf.createServerSocket(port);

            //while(true){
            Socket socket = ss.accept();
            System.out.println("Cliente Conectado:");

            Scanner lee = new Scanner(socket.getInputStream());
            PrintWriter escribe = new PrintWriter(socket.getOutputStream());

            while(lee.hasNextLine()) {
                String frase = lee.nextLine();
                if (frase.equalsIgnoreCase("fin")){
                    escribe.println("GoodBye!");
                    escribe.flush(); 
                    socket.close();
                }
                escribe.println("Server: "+frase);
                escribe.flush(); 
            }   
            //}
            ss.close();
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
