
import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class MultiprotocolEcho
{
    public static void main(String argv[]) throws UnknownHostException, IOException {
        try {
            // Crea hilo udp
            DatagramSocket ds = new DatagramSocket(7777);
            UdpEchoServer udp = new UdpEchoServer(ds);
            udp.start();
            // Crea hilo server tcp
            ServerSocket serverSocket = new ServerSocket(7777);
            while (true){
                Socket clientSocket = serverSocket.accept();
                TcpEchoText tcp = new TcpEchoText(clientSocket);
                tcp.start();
            }
            

        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor desconocido");
        } catch (IOException e) {
            System.out.println("No es posible establecer la conexion");
        }
    }
}
