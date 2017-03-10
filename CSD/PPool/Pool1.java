// CSD feb 2015 Juansa Sendra

public class Pool1 extends Pool {   //no kids alone
    //niños por instructor
    //int ki;
    //aforo maximo
    //int cap;
    int ki, cap, kids, inst;
    
    public void init(int ki, int cap){
        this.ki = ki;
        this.cap = cap;
        kids = inst = 0;
    }
    public synchronized void kidSwims(){
        while(inst == 0){
            log.waitingToSwim();
            try{wait();}catch(Exception e){}
        }
        kids++;
        log.swimming();
    }
    public synchronized void kidRests(){
        kids--;
        notifyAll();
        log.resting(); 
    }
    public synchronized void instructorSwims(){
        inst++;
        notifyAll();
        log.swimming();
    }
    public synchronized void instructorRests(){
        while(inst == 1 && kids != 0){
            log.waitingToRest();
            try{wait();}catch(Exception e){}
        }
        inst--;
        log.resting(); 
    }
}
