package basictrain.javacore.gc;

import java.lang.ref.Cleaner;

public class CleanBigObject implements AutoCloseable {

    // Declare a big array of 20KB.
    private final long[] anArray = new long[20480];
    // Have an id to track the object
    private final long id;

    // Let us use a Cleaner
    public static Cleaner cleaner = Cleaner.create();
    // Keep a reference of its cleaning action as a Cleanable
    private final Cleaner.Cleanable cleanable;

    private static class RefObjCleaner implements Runnable{

        private final long id;

        RefObjCleaner(long id){this.id = id;}

        @Override
        public void run() {
            System.out.println("Cleaning up CleanBigObject: id = " + this.id);
        }
    }

    public CleanBigObject(long id) {
        this.id = id;

        // Register this object with the cleaner
        this.cleanable = cleaner.register(this, new RefObjCleaner(id));
    }

    @Override
    public void close() throws InterruptedException {

        // Clean the object explicitly or as part of a try-with-resources block
        cleanable.clean();
    }

    @Override
    public String toString() {
        return "CleanBigObject: id = " + id;
    }
}
