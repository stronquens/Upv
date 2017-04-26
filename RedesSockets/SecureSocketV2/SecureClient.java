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
            Scanner lee = new Scanner(System.in);
            Scanner input = new Scanner(socket.getInputStream());

            while(lee.hasNextLine()) {

                String frase2 = lee.nextLine(); // Teclado
                output.println(frase2);
                output.flush(); 

                String frase1 = input.nextLine(); // Servidor
                System.out.println(frase1);

                if (frase1.equalsIgnoreCase("GoodBye!")){
                    break;
                }
            }   

            System.out.println("Cliente cerrado");
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