package streamtrain;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");

        Stream.iterate(2, n -> n+1).skip(100).limit(5).forEach(System.out::println);

        Stream<Integer> limitedNumber = Stream.iterate(2, n -> n + 1).limit(10);

        Optional<String> str = Optional.of("hello");
        String nullable = "";
        Optional<String> str2 = Optional.of(nullable);
        System.out.println("this is not null : " + str.get());
        System.out.println("this is not null : " + str2.get());

        if(str.isPresent()){
            String value = str.get();
            System.out.println("optional contain " + value);
        }
        else{
            System.out.println("optional empty");
        }

        //Mapping
        System.out.println("intStream numbers");
        IntStream.range(1,10).map(n -> n * n).forEach(n -> System.out.println("the number is " + n));

        System.out.println("map person to name");
        Person.persons().stream().map(Person::getName).forEach(System.out::println);

        //Flat Mapping
        System.out.println("map one to many");
        Stream.of(1,2,3)
                .map(n -> Stream.of(n, n*n))
                .forEach(n -> n.forEach(System.out::println));

        //concise way for flat map
        Stream.of(1,2,3)
                .flatMap(n -> Stream.of(n, n*n))
                .forEach(System.out::println);



        //count of specific character in list
        long result = Stream.of("ken","ellen","jeff")
                .map(name -> name.chars())
                .flatMap(IntStream -> IntStream.mapToObj(n -> (char)n))
                .filter(ch -> ch == 'E' || ch == 'e')
                .count();


        System.out.println("count of e is " + result);

        // concise way for count character in string
        long resultC = Stream.of("ken","ellen","jeff")
                .flatMap(name -> IntStream.range(0, name.length()).mapToObj(name::charAt))
                .filter(ch -> ch == 'E' || ch == 'e')
                .count();

        System.out.println("count of e is " + resultC);

    }
}
