import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ClientTcp extends Thread
{

    private DatagramSocket ds;

    public ClientTcp(DatagramSocket ds){
        this.ds = ds;
    }

    public void run(){
        try {
            System.out.println("llego 2");
            byte[] buffer = new byte[100];

            DatagramPacket dp = new DatagramPacket(buffer, 100, 
                    InetAddress.getByName("localhost"),7777);

            DatagramPacket dp2;
            while(true){
                ds.receive(dp);
               
                // cliente tcp
                String fecha = peticionTCP();
                //
                System.out.println("llego 3");
                dp2 = new DatagramPacket(fecha.getBytes(), fecha.getBytes().length, 
                    dp.getAddress(), dp.getPort());
                ds.send(dp2);
            }
        } catch (Exception e){}

    }

    public String peticionTCP(){
        String result = "";
        try {
            Socket s = new Socket("ntp.upv.es", 13);
            Scanner lee = new Scanner(s.getInputStream());
            while(lee.hasNextLine()) {
                result += lee.nextLine();
            }    
            s.close();
        } catch (UnknownHostException e) {
            System.out.println("Nombre de servidor desconocido");
        } catch (IOException e) {
            System.out.println("No es posible establecer la conexion");
        }
        return result += "\n";
    }
}
