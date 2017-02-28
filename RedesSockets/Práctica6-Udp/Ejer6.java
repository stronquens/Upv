import java.net.*;
import java.io.*;
import java.util.*;
/**
 * Ejercicio 6 de la Practica 6
 */
public class Ejer6{
    public static void main(String[] args) throws Exception{
        byte[] buffer = new byte[100];
        
        DatagramPacket dp = new DatagramPacket(buffer, 100, 
            InetAddress.getByName("localhost"),7777);
            
        DatagramPacket dp2;    
        
        DatagramSocket ds = new DatagramSocket(7777);
        while(true){
            ds.receive(dp);
            
            
            
            Date now = new Date();
            String hora = now.toString() + "\n";
            
            dp2 = new DatagramPacket(hora.getBytes(), hora.getBytes().length, 
            dp.getAddress(), dp.getPort());
            ds.send(dp2);
        }
    }
}