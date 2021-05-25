package streamtrain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelTest {

    public static void main(String[] args){


        //sequential
        String names = Person.persons()
                .stream()
                .filter(Person::isMale)
                .map(n -> n.getName())
                .collect(Collectors.joining(", "));

        System.out.println(names);

        //parallel
        String namesp = Person.persons()
                .parallelStream()
                .filter(Person::isMale)
                .map(Person::getName)
                .collect(Collectors.joining(", "));

        System.out.println(namesp);

        //second way
        String namesp2 = Person.persons()
                .stream()
                .filter(Person::isMale)
                .parallel()
                .map(p -> p.getName())
                .collect(Collectors.joining(", "));

        System.out.println(namesp2);

        //compare parallel with sequential
        // Process the stream in serial
        long count = IntStream.rangeClosed(2, Integer.MAX_VALUE/10)
                .filter(PrimeUtil::isPrime)
                .count();

        System.out.println(count);

        // Process the stream in parallel
        long counts = IntStream.rangeClosed(2, Integer.MAX_VALUE/10)
                .parallel()
                .filter(PrimeUtil::isPrime)
                .count();

        System.out.println(counts);
    }


}
