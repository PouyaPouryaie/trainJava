package threadtrain.atomicvariable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {

    private int value;
    private Lock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        value++;
        lock.unlock();
    }

    public void decrement(){
        lock.lock();
        value--;
        lock.unlock();
    }

    public synchronized int get(){
        return value;
    }
}
