import java.net.*;
import java.io.*;
import java.util.*;
/**
 * Ejercicio 2 de la Practica 6
 */
public class Ejer2{
    public static void main(String[] args) throws Exception{
        InetAddress[] Ipdirs = InetAddress.getAllByName("www.google.es");
        
        System.out.println("Direcciones de los hosts: " + Arrays.toString(Ipdirs));
    }
}