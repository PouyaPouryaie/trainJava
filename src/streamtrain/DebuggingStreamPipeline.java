package streamtrain;

import java.util.stream.Stream;

public class DebuggingStreamPipeline {

    public static void main(String[] args){

        int sum = Stream.of(1,2,3,4,5)
                .peek(e -> System.out.println("Taking integer: " + e))
                .filter(n -> n % 2 == 1)
                .peek(e -> System.out.println("filter integer: " + e))
                .map(n -> n * n)
                .peek(e -> System.out.println("Map integer: " + e))
                .reduce(0, Integer::sum);

        System.out.println("sum is " + sum);
    }
}
