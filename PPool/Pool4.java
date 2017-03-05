// CSD feb 2015 Juansa Sendra

public class Pool4 extends Pool {   //no kids alone
    int ki, cap, kids, inst, instw;
    
    public void init(int ki, int cap){
        this.ki = ki;
        this.cap = cap;
        kids = inst = instw = 0;
    }
    public synchronized void kidSwims() throws InterruptedException{
        while(inst == 0 || (inst*ki) <= kids 
            || cap < (kids+inst+1) 
            || instw > 0){
            log.waitingToSwim();
            wait();
        }
        kids++;
        log.swimming();
    }
    public synchronized void kidRests(){
        kids--;
        notifyAll();
        log.resting(); 
    }
    public synchronized void instructorSwims() throws InterruptedException{
        while(cap < (kids+inst+1)){
            log.waitingToSwim();
            wait();
        }
        inst++;
        notifyAll();
        log.swimming();
    }
    public synchronized void instructorRests() throws InterruptedException{
        while((inst == 1 && kids != 0) 
            || (inst*ki-2) <= kids && (inst*ki-2) != 0){   
            instw++;
            log.waitingToRest();
            wait();
            instw--;
        }
        inst--;
        notifyAll();
        log.resting(); 
    }
}
