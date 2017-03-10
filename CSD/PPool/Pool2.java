// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool {   //no kids alone
    int ki, cap, kids, inst;
    
    public void init(int ki, int cap){
        this.ki = ki;
        this.cap = cap;
        kids = inst = 0;
    }
    public synchronized void kidSwims(){
        while(inst == 0 || (inst*ki) <= kids){
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
        while((inst == 1 && kids != 0) 
        || ((inst*ki-ki) <= kids && (inst*ki-ki) != 0)){
            
            log.waitingToRest();
            try{wait();}catch(Exception e){}
        }
        inst--;
        notifyAll();
        log.resting(); 
    }
}
