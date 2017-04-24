import java.net.*;
import java.io.*;
import java.util.*;

public class Main extends Thread {
    public static void main(String argv[]) throws Exception {
      /*
      Documentacion
      -------------
      http://chuwiki.chuidiang.org/index.php?title=Socket_SSL_con_Java
      http://stackoverflow.com/questions/4830253/where-is-the-keytool-application
      http://stackoverflow.com/questions/9761575/java-nosuchalgorithmexception-sunjsse-sun-security-ssl-sslcontextimpldefault
      https://github.com/chuidiang/chuidiang-ejemplos-google-code
      */
        
        
        
      System.setProperty("javax.net.ssl.keyStore", "certs/server/serverKey.jks");
      System.setProperty("javax.net.ssl.keyStorePassword","servpass");

      System.setProperty("javax.net.ssl.trustStore", "certs/client/clientTrustedCerts.jks");
      System.setProperty("javax.net.ssl.trustStorePassword", "clientpass");
      
      int port = 7776;
      
      SecureServer sc = new SecureServer(port);
      sc.start();
        
      SecureClient cl = new SecureClient(port);
      cl.start();
        
      cl.join();
      sc.join();
    }

}
