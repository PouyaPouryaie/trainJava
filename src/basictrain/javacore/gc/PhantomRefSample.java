package basictrain.javacore.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomRefSample {
    public static void main(String[] args) {
        final ReferenceQueue<RefObj> q = new ReferenceQueue<>();
        RefObj bigObject1 = new RefObj(101,"hh");
        RefObj bigObject2 = new RefObj(102,"ho");
        RefObj bigObject3 = new RefObj(103,"hi");
        PhantomReference<RefObj> pr1 =
                new PhantomReference<RefObj>(bigObject1, q);
        PhantomReference<RefObj> pr2 =
                new PhantomReference<RefObj>(bigObject2, q);
        PhantomReference<RefObj> pr3 =
                new PhantomReference<RefObj>(bigObject3, q);

        /* This method will start a thread that will wait for the arrival of new
        phantom references in reference queue q
        */
        startThread(q);

        /* You can use bigObject1, bigObject2 and bigObject3 here */

        // Set the bigObject1, bigObject2 and bigObject3 to null,
        // so the objects they are referring to may become phantom reachable.
        bigObject1 = null;
        bigObject2 = null;
        bigObject3 = null;

        /* Let us invoke garbage collection in a loop. One garbage collection will
        just finalize the three big objects with ids 101, 102 and 103. They may
        not be placed in a reference queue. In another garbage collection run,
        they will become phantom reachable and they will be placed in a queue
        and the waiting thread will remove them from the queue and will clear
        their referent's reference. Note that we exit the application when all
        three objects are cleared inside run() method of thread. Therefore, the
        following infinite loop is ok for demonstration purpose. If System.gc()
        does not invoke the garbage collector on your machine, you should replace
        the following loop with a loop which would create many big objects keeping
        their references, so the garbage collector would run.
        */
        while (true) {
            System.gc();
        }
    }

    public static void startThread(final ReferenceQueue<RefObj> q) {
        /* Create a thread and wait for the reference object's arrival in the queue */
        Thread t = new Thread(() ->{
            try{
                for(int i = 0; i < 3; i++){
                    Reference r = q.remove();
                    r.clear();
                }

                System.out.println("All three objects have been queued and cleared.");
                /*
                you can disconnect any resource bind to objects in queue.
                 */

                System.exit(1);
            }catch (Exception ie){
                System.out.println(ie.getMessage());
            }
        });

        // Start the thread, which will wait for three phantom
        // references to be queued
        t.start();
    }
}
