package threadtrain;

public class UncaughtExceptionInThread {

    public static void main(String[] args){

        CatchAllThreadExceptionHandler handler = new CatchAllThreadExceptionHandler();
        // Set an uncaught exception handler for main thread
        Thread.currentThread().setUncaughtExceptionHandler(handler);

        // Throw an exception
        throw new RuntimeException();
    }
}
