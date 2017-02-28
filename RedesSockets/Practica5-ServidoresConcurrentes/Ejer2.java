import java.net.*;
import java.io.*;

public class Ejer2 extends Thread {
    public static void main(String argv[]) throws UnknownHostException, IOException {
        ServerSocket servidor=new ServerSocket(7777);

        while (true){
            Socket cliente = servidor.accept();

            Servicio cl = new Servicio(cliente);
            cl.start();
        }
    }

    
}
