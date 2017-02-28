public class Hilos_ejer1 extends Thread{
    
   int id;
   String texto;
   
   public Hilos_ejer1(int id, String texto){
       this.id = id;
       this.texto = texto;
    }
    
    public void run(){
        for(int i = 0; i<10; i++){
            System.out.println(texto);
            
            try{
                sleep(100);
            }
            catch(InterruptedException e){}
        }
    }
    
    public static void main(String[]args){
            Hilos_ejer1 h1 = new Hilos_ejer1(1,"Creado hilo: 1");
            Hilos_ejer1 h2 = new Hilos_ejer1(2, "Creado hilo: 2");
            Hilos_ejer1 h3 = new Hilos_ejer1(3, "Creado hilo: 3");
            h1.start();
            h2.start();
            h3.start();
            
        }
    }