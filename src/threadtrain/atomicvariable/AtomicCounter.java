package threadtrain.atomicvariable;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private AtomicInteger value = new AtomicInteger();

    public void increment(){
        value.incrementAndGet();
    }

    public void decrement(){
        value.decrementAndGet();
    }

    public synchronized int get(){
        return value.get();
    }
}
