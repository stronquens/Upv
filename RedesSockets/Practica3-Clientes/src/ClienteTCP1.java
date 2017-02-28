package src;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Armado
 */
public class ClienteTCP1 {

    public static void main(String args[]) throws IOException {
        Ejer1();
        System.out.println("------------------------------------------");
        Ejer2();
        System.out.println("------------------------------------------");
        //clienteDayTume(); // NO conecta
        System.out.println("------------------------------------------");
        //clienteEcho(); // No conecta
    }

    public static void Ejer1() throws IOException {
        Socket s = new Socket("www.upv.es", 80);
        System.out.println("Conectado de nuevo!!!");
        s.close();
        System.out.println("Desconectado");
    }

    public static void Ejer2() {
        try {
            Socket s = new Socket("www.upv.es", 80);
            System.out.println("Conectado");
            s.close();
            System.out.println("Desconectado");
        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor desconocido");
        } catch (IOException e) {
            System.out.println("No es posible establecer la conexion");
        }
    }

    // Comprobar netcat, en casa no conecta
    public static void clienteDayTume() {
        try {
            Socket s = new Socket("ntp.upv.es", 13);
            System.out.println("Conectado");
            Scanner lee = new Scanner(s.getInputStream());
            System.out.println(lee.nextLine());
            s.close();
            System.out.println("Desconectado");
        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor desconocido");
        } catch (IOException e) {
            System.out.println("No es posible establecer la conexion");
        }
    }

    // Ejer 4 y 5
    public static void clienteEcho() {
        try {
            Socket s = new Socket("zoltar.redes.upv.es", 7);
            System.out.println("Conectado");
            Scanner lee = new Scanner(s.getInputStream());
            PrintWriter escribe = new PrintWriter(s.getOutputStream()); // segundo parametro autoFlussh(bool)
            escribe.flush(); // Opcional
            
            escribe.println("Hola Mundo!!!\n");
            System.out.println(lee.nextLine());  
            
            System.out.println(lee.nextLine());
            s.close();
            System.out.println("Desconectado");
        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor desconocido");
        } catch (IOException e) {
            System.out.println("No es posible establecer la conexion");
        }
    }
}
