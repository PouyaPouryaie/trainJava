package threadtrain.atomicvariable;

public class SyncCounter {

    private int value;

    public synchronized void increment(){
        value++;
    }

    public synchronized void decrement(){
        value--;
    }

    public synchronized int get(){
        return value;
    }
}
