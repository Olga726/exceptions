package multi;

public class Counter {
    public int counter4 = 0;
    public synchronized void increment(){
        counter4++;
    }

    public int getCounter4() {
        return counter4;
    }
}
