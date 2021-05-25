package normaltrain.javacore.gc;

public class GarbageCollenctionSample {

    public static void main(String[] args) {
        long m1,m2,m3;

        Runtime rt = Runtime.getRuntime();

        try{
            for (int i = 0; i < 3; i++) {
                // Get free memory
                m1 = rt.freeMemory();
                // Create some objects
                createObjects(20000);
                // Get free memory
                m2 = rt.freeMemory();
                // Invoke garbage collection
                System.out.println("before gc");
                System.gc();
                // Get free memory
                Thread.sleep(1000);
                m3 = rt.freeMemory();
                System.out.println("m1 = " + m1 + ", m2 = " + m2 + ", m3 = "
                        + m3 + "\nMemory freed by gc() = " + (m3 - m2));
                System.out.println("-------------------------");
            }
        }catch (InterruptedException ie){
            System.out.println("interrupt");
        }


    }

    public static void createObjects(int number){
        for(int i=0; i < number; i++){
            // Do not store the references of new objects, so they become
            // eligible for garbage collection immediately.
            new RefObj(i, "pouya");
        }
    }
}
