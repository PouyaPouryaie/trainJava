package threadtrain.atomicvariable;

public class ThreadTest {

    static final int NUMBER_THREADS = 999999;

    public static void main(String[] args) throws InterruptedException{

        Counter counter = new Counter();
        SyncCounter syncCounter = new SyncCounter();
        LockCounter lockCounter = new LockCounter();
        AtomicCounter atomicCounter = new AtomicCounter();

        System.out.println("Initial Counter = " + lockCounter.get());

        UpdateThread[] updateThreads = new UpdateThread[NUMBER_THREADS];

        long startTime = System.currentTimeMillis();
        for(int i = 0 ; i < NUMBER_THREADS; i++){
            updateThreads[i] = new UpdateThread(lockCounter);
            updateThreads[i].start();
        }

        for(int i = 0 ; i < NUMBER_THREADS ; i++){
            updateThreads[i].join();
        }

        System.out.println("final Counter = " + lockCounter.get());
        long endTime = System.currentTimeMillis();
        float sec = (endTime - startTime) / 1000f;
        System.out.println(sec);

    }
}
