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

            Socket socket = ss.accept();
            System.out.println("Cliente Conectado:");

            socket.setSoLinger(true, 1000);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream());

            String message = input.readLine();
            output.println(message);
            output.flush();

            socket.close();
            ss.close();
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
