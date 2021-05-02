package effectivejava.ch9;

import java.util.Random;

public class LocalScope {

    public static void main(String[] args) {

        for(int i=0, n = new Random().nextInt(30); i < n; i++){
            System.out.println(i);
        }
    }
}
