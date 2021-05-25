package normaltrain.javacore.gc;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class CorrectSoftRef {

    static Runtime rt = Runtime.getRuntime();

    public static void main(String[] args) {

        Thread t1 = new Thread(CorrectSoftRef::run);
        t1.start();
        long count = 100;

        try{
            RefObj refObj = new RefObj(10, "pouya");
            WeakReference<RefObj> refObjSoftReference = new WeakReference<>(refObj);
            List<WeakReference<RefObj>> refObjs = new ArrayList<>();
            refObj = null;

            while (true){
                RefObj refObjInWhile = new RefObj(count,"puff");
                WeakReference<RefObj> refObjSoftRef = new WeakReference<>(refObjInWhile);
                refObjs.add(refObjSoftRef);
                refObjInWhile = null;
                count++;
            }

        }catch (OutOfMemoryError e){
            System.out.println("counter is " + count);
            t1.interrupt();
        }

        System.out.println("good bye");
    }


    public static void run(){
        while (true){
            try{
                Thread.sleep(5000);
                System.out.println(rt.freeMemory());
            }catch (InterruptedException ie){
                System.out.println("last memory : " + rt.freeMemory() / (1024.0 * 1024.0));
                return;
            }
        }
    }
}
