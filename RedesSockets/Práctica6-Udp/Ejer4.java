import java.net.*;
import java.io.*;
import java.util.*;
/**
 * Ejercicio 4 de la Practica 6
 */
public class Ejer4{
    public static void main(String[] args) throws Exception{
        String name = "Armando Maya Gomis";
        
        DatagramPacket dp = new DatagramPacket(name.getBytes(), name.getBytes().length, 
            InetAddress.getByName("rdc00.redes.upv.es"),7777);
        
        DatagramSocket ds = new DatagramSocket();
        ds.send(dp);
    }
}