import java.net.*;
import java.io.*;
import java.util.*;
public class UdpEchoServer extends Thread
{
    private DatagramSocket ds;
    public UdpEchoServer(DatagramSocket ds)
    {
        this.ds = ds;
    }

    public void run () {
        try {
            byte[] buffer = new byte[100];

            DatagramPacket dp = new DatagramPacket(buffer, 100, 
                    InetAddress.getByName("localhost"),7777);

            DatagramPacket dp2;    
            while(true){
                ds.receive(dp);
                String salida = new String(dp.getData(),0,dp.getLength());
                
                dp2 = new DatagramPacket(salida.getBytes(), salida.getBytes().length, 
                    dp.getAddress(), dp.getPort());
                ds.send(dp2);
            }
        } catch (Exception e){}
    }
}

