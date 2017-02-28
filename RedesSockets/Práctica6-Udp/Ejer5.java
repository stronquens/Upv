import java.net.*;
import java.io.*;
import java.util.*;
/**
 * Ejercicio 5 de la Practica 6
 */
public class Ejer5{
    public static void main(String[] args) throws Exception{
        
        
        // Cliente
        String name = "Marta Torres Garsia";
        
        DatagramPacket dp = new DatagramPacket(name.getBytes(), name.getBytes().length, 
            InetAddress.getByName("rdc15.redes.upv.es"),7777);
        
        DatagramSocket ds = new DatagramSocket();
        ds.send(dp);
        
        
        // Servidor
        byte[] buffer = new byte[512];
        DatagramPacket mensaje = new DatagramPacket(buffer, buffer.length -1);
        
        ds.receive(mensaje);
     
        
        String salida = new String(mensaje.getData(),0,mensaje.getLength());
        System.out.println(salida);
    }
}