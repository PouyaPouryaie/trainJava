package lambdatrain;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class MapperTest {

    public static void main(String[] args){


        //basic test
        tlambda ttest = (x,y) -> x+y; // tlambda ttest = (x,y) -> {return x+y;};
        int result = ttest.tm(5,10);
        System.out.println(result);

        // Map names using their length
        System.out.println("Mapping names to their lengths:");
        String[] names = {"David", "Li", "Doug"};
        int[] lengthMapping = Mapper.mapToInt(names, (String name) -> name.length());
        printMapping(names, lengthMapping);


        Mapper<String> mapCount = (String name) -> name.length();
        int nameLength = mapCount.map("pouya pouryaie");
        System.out.println("pouya pouryaie length is " + nameLength);

        System.out.println("\nMapping integers to their lengths:");
        Integer[] numbers = {7, 3, 6};
        int[] countMapping = Mapper.mapToInt(numbers, (Integer n) -> n * n);
        printMapping(numbers, countMapping);


        //example of build-in functional interface in java
        // Takes an int and returns its square
        Function<Integer, Integer> square1 = x -> x * x;
        IntFunction<Integer> square2 = x -> x * x;
        ToIntFunction<Integer> square3 = x -> x * x;
        UnaryOperator<Integer> square4 = x -> x * x;

        System.out.println(square1.apply(5));
        System.out.println(square2.apply(5));
        System.out.println(square3.applyAsInt(5));
        System.out.println(square4.apply(5));

    }

    public static void printMapping(Object[] from, int[] to) {
        for(int i = 0; i < from.length; i++) {
            System.out.println(from[i] + " mapped to " + to[i]);
        }
    }

    interface tlambda{
        int tm(int x, int y);
    }
}
