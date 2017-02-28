package src;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
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
public class Notas {

    public static void main(String[] args) throws IOException {
        /*
         socket(cliente),
         serversocket(servidor),
         datagramsocket(cliente/servidor)
        
         InputStream (lee del socket)
         OutputStream (escribe en el socket)
        
         Con Scanner se puede leer texto directamente en lugar de solo bytes
         */

        Scanner leeTeclado = new Scanner(System.in);
        System.out.println("Nombre del servidor destino: ");
        String servidor = leeTeclado.nextLine();
        System.out.println("Introduce puerto: ");
        int pto = leeTeclado.nextInt();

        Socket sc = new Socket("www.upv.es", 80); // Direccion ip de tipo InetAddress
        Scanner entrada = new Scanner(sc.getInputStream()); // Leer del servidor
        entrada.next();

        // Acepta segundo paremetro true para no tener que usar flush
        PrintWriter salida = new PrintWriter(sc.getOutputStream()); //Enviar al servidor
        salida.printf("GET / HTTP/1.0" + "\r\n");
        salida.flush(); // vacia y envia datos de buffer

        sc.close();
    }
}
