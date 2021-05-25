package streamtrain;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntroStream {

    public static void main(String[] args){

        //Using the Stream.iterate() Method

        System.out.println("Creates a stream of natural numbers ");
        Stream.iterate(1, n -> n + 1).limit(10).forEach(System.out::println);

        System.out.println("Creates a stream of odd numbers ");
        Stream<Integer> naturalNumber = Stream.iterate(1, n -> n + 2).limit(10);
        naturalNumber.forEach(System.out::println);

        System.out.println("first way for Prime number is ");
        Stream.iterate(2L, PrimeUtil::next)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("second way for Prime number is ");
        Stream.iterate(2L, n -> n + 1)
                .filter(PrimeUtil::isPrime)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("third way for Prime number is ");
        Stream.iterate(2L, PrimeUtil::next)
                .skip(100)
                .limit(5)
                .forEach(System.out::println);

        //Using the generate() Method

        System.out.println("generate random number is ");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("generate prime number is ");
        Stream.generate(new PrimeUtil()::next)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Streams from Arrays :");
        Stream<String> names = Arrays.stream(new String[]{"ken","tom"});
        names.forEach(System.out::println);


        //Stream with character
        String str = "5 apples and 25 oranges";
        System.out.println("before change : " + str);
        System.out.print("after change : ");
        str.chars().filter( n -> !Character.isDigit((char) n) && !Character.isWhitespace((char) n)).forEach(n -> System.out.print((char) n));
    }
}
