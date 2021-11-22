package threadtrain.callabletask;

import java.util.concurrent.Callable;

public class BasicCallable implements Callable {

    private Integer a, b;
    private int delay;

    public BasicCallable(int delay, Integer a, Integer b) {
        this.a = a;
        this.b = b;
        this.delay = delay;
    }

    @Override
    public Integer call() throws Exception {

        Thread.sleep(delay);
        return a+b;
    }
}
