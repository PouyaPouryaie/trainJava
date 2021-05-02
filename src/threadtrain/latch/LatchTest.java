package threadtrain.latch;

import java.util.concurrent.CountDownLatch;

public class LatchTest {

    public static void main(String[] args){
        CountDownLatch countDownLatch = new CountDownLatch(2);

        LatchMainService latchMainService = new LatchMainService(countDownLatch);
        latchMainService.start();

        for(int i = 1; i <=2 ; i++){
            LatchHelperService latchHelperService = new LatchHelperService(i, countDownLatch);
            latchHelperService.start();
        }
    }
}
