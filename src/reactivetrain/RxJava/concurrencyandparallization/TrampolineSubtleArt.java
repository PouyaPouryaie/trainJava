package reactivetrain.RxJava.concurrencyandparallization;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * help you run job on the same thread
 * and help you to prevent stack overflow
 *
 * ##### Schedule worker
 * Represents an isolated, sequential worker of a parent Scheduler for executing Runnable tasks
 * on an underlying task-execution scheme
 */
public class TrampolineSubtleArt {
    public static void main(String[] args) throws InterruptedException {

        Scheduler scheduler = Schedulers.trampoline(); //if use computation you need main thread sleep
        Scheduler.Worker worker = scheduler.createWorker();

        Runnable r1 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("start: r1");
            System.out.println("end: r1");
        };

        Runnable r2 = ()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("start: r2");
            worker.schedule(r1);
            System.out.println("end: r2");
        };

        worker.schedule(r2);

        //Thread.sleep(5000);
    }
}
