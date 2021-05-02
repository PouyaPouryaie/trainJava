package lambdatrain.functionalprogramming.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerSample {

    protected static int sum = 0;
    private static int fx = 0;
    private static String components = "";
    private static int bSum = 0;

    public static void main(String[] args) {

        //regular define
        Consumer <Integer> con = x -> sum += x;
        con.accept(20);
        con.accept(10);

        System.out.println(sum);

        //Consumer Chain
        Consumer<Integer> mul = x -> sum *= x;

        con.andThen(mul).accept(6);

        System.out.println(sum);

        //fx = 5x4 + 7x3 + 4x2 + 3x + 8
        Consumer<Integer> poly = x -> fx += 5 * (int)Math.pow(x, 4);
        poly.andThen(x -> fx += 7 * (int)Math.pow(x, 3))
                .andThen(x -> fx += 4 * (int)Math.pow(x, 2))
                .andThen(x -> fx += 3 * x)
                .andThen(x -> fx += 8)
                .andThen(x -> System.out.println(fx))
                .accept(2);


        //BiConsumer
        BiConsumer<Integer, String> bi = (x,y) -> {
            bSum += x;
            components += y;
        };

        bi.andThen( (x,y) -> System.out.println(x + " " + y))
                .accept(6, "Term 1");

        bi.andThen( (x,y) -> System.out.println("add " + x + " " + y
                + " result = " + bSum + " " + components))
                .accept(7, ",Term 2");
    }
}
