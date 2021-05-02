package reactivetrain.pushbased;

public class PushBaseApp {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("I am in main Thread");
        new PushBaseApp().asyncMessage(new CallBack() {
            @Override
            public void pushData(String s) {
                new PushBaseApp().sleep(1000);
                System.out.println("push data is: "+ s);
            }

            @Override
            public void pushComplete() {
                System.out.println("push complete");
            }

            @Override
            public void pushError(Exception e) {
                System.out.println("Push Error " + e.getMessage());
            }
        });

        Thread.sleep(3000);
        System.out.println("Main Thread is done");
    }

    private void asyncMessage(CallBack callback){
        System.out.println("I am in async method");
        sleep(1000);
        callback.pushData("100");
        callback.pushData("200");
        callback.pushData("300");
        callback.pushData("400");
        callback.pushComplete();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
