import java.net.*;
import javax.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class SecureClient extends Thread {
    private String host = "localhost";
    private int port;

    public SecureClient(int port){
        this.port = port;
    }

    public void run(){
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            Socket socket = factory.createSocket(host, port);

            PrintWriter output = new PrintWriter(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            output.println("Hola que tal!!!");
            output.flush();

            System.out.println("Cliente envia: Hola que tal!!!");

            String received = input.readLine();
            System.out.println("Cliente recibe : " + received);

            socket.close();
            
        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor desconocido");
        } catch (IOException e) {
            System.out.println("No es posible establecer la conexion");
        }catch(Exception e){
            System.out.println(e);
        }
    }

}