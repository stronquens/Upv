
import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ServerUdp
{
    public static void main(String argv[]) {
        try {
            
                // Crea hilo udp
                DatagramSocket ds = new DatagramSocket(7777);
                System.out.println("llego 1");

                ClientTcp udp = new ClientTcp(ds);
                udp.start();

            while(true){}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
}
