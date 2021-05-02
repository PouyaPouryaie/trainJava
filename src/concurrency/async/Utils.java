package concurrency.async;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

public class Utils {

    private static final Random random = new Random();
    private static final DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

    public static void delay(){
        int delay = 1000;

        try {
            Thread.sleep(delay);
        }catch (InterruptedException e){
            System.out.println("thread wake up");
            throw new RuntimeException(e);
        }
    }
    public static void randomDelay() {
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static double format(double number){
        synchronized (formatter){
            return new Double(formatter.format(number));
        }
    }
}
