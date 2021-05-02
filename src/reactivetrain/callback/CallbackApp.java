package reactivetrain.callback;

public class CallbackApp {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("I am in main thread");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                new CallbackApp().AsyncMessage(() -> System.out.println("I am CallBack"));
            }
        };

        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();

        Thread.sleep(2000);

        System.out.println("Main thread is Done");
    }

    public void AsyncMessage(Callback callback){
        System.out.println("I am in async message");
        sleep(1000);
        callback.call();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
