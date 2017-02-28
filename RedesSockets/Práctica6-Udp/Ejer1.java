import java.net.*;
import java.io.*;
import java.util.*;
/**
 * Ejercicio 1 de la Practica 6
 */
public class Ejer1{
    public static void main(String[] args) throws Exception{
        InetAddress Ipdir = InetAddress.getByName("rdc15.redes.upv.es");
        
        System.out.println("Dirección del host: " + Ipdir.toString());
    }
}