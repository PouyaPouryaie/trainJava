package threadtrain.atomicvariable;

public class UpdateThread extends Thread {

    private Counter counter;
    private SyncCounter syncCounter;
    private LockCounter lockCounter;
    private AtomicCounter atomicCounter;

    public UpdateThread(Counter counter) {
        this.counter = counter;
    }

    public UpdateThread(AtomicCounter atomicCounter) {
        this.atomicCounter = atomicCounter;
    }


    public UpdateThread(SyncCounter syncCounter) {
        this.syncCounter = syncCounter;
    }

    public UpdateThread(LockCounter lockCounter) {
        this.lockCounter = lockCounter;
    }

    public void run(){
        try{
            Thread.sleep(100);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        if(counter != null)
            counter.increment();
        else if(syncCounter != null)
            syncCounter.increment();
        else if(lockCounter != null)
            lockCounter.increment();
        else if(atomicCounter != null)
            atomicCounter.increment();
    }
}
