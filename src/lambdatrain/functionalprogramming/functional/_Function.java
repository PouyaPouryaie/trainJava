package lambdatrain.functionalprogramming.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

/*        int a = 10;

        for(;;) {
            a = incrementBy1Function.apply(a);
            System.out.println(a);
        }*/

        // Function
        int increment = incrementBy1Function.apply(2);
        System.out.println(increment);

        int multiply = multiplyBy10Function.apply(5);
        System.out.println(multiply);

        //compose
        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementBy1Function.andThen(multiplyBy10Function);

        int addAndTheMultiply = addBy1AndThenMultiplyBy10.apply(6);
        System.out.println(addAndTheMultiply);

        // Bi Function
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(5, 8));
    }

    static Function<Integer, Integer> incrementBy1Function = a -> a + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) ->
                    (numberToIncrementByOne + 1) * numberToMultiplyBy;
}
