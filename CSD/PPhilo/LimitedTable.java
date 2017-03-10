// CSD Mar 2013 Juansa Sendra

public class LimitedTable extends RegularTable { //max 4 in dinning-room
    private int cont;
    public LimitedTable(StateManager state) {
        super(state);
        cont = 0;
    }

    public synchronized void enter(int id) throws InterruptedException {
        while(cont > 3) wait();
        cont++;
    }

    public synchronized void exit(int id)  {
        cont--;
        notifyAll();
    }
}
