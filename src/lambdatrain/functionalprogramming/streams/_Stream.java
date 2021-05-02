package lambdatrain.functionalprogramming.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static lambdatrain.functionalprogramming.streams.Gender.*;

/**
 * imperative -> declarative
 *
 * stream ->
 * filter
 * sort
 * all match
 * non match
 * some match
 * group
 * max
 * min
 * and ...
 *
 */
public class _Stream {

    public static void main(String[] args) {

        List<Person> persons = getPersons();

        //imperative approach
        List<Person> females = new ArrayList<>();

        for(Person person : persons){
            if(FEMALE.equals(person.getGender())){
                females.add(person);
            }
        }

        females.forEach(System.out::println);

        //Declarative approach
        //filter
        System.out.println("Filter result");
        persons.stream().filter(person -> person.getGender().equals(FEMALE))
                .collect(Collectors.toList()).forEach(System.out::println);

        //sorted
        System.out.println("sorted result");
        persons.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getGender))
                .forEach(System.out::println);

        //allMatch - anyMatch - noneMatch
        System.out.println("match result");
        boolean allMatchAge = persons.stream()
                .allMatch(person -> person.getAge() > 15);

        System.out.println("condition for age : " + allMatchAge);

        //max - min
        System.out.println("max-min result");
        Optional result =persons.stream()
                .max(Comparator.comparing(Person::getAge));
        System.out.println(result);

        persons.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(person -> {
                    System.out.println(person);
                });

        //group
        System.out.println("Group result");
        Map<Gender, List<Person>> groupByGender = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people) -> {
            System.out.println(gender);
            people.forEach(System.out::println);
        });

        //recap
        System.out.println("recap result");
        persons.stream()
                .filter(person -> person.getGender().equals(FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName)
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("there is not female with max age"));


        System.out.println("simple train");
        persons.stream()
                .map(person -> person.getGender())
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("all of list is woman : " + persons.stream()
                .allMatch(person -> FEMALE.equals(person.getGender())));

        //use concise in stream
        persons.stream()
                .map(person -> person.getGender())
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        //without use concise in stream
        Function<Person, String> personStringFunction = person -> person.getGender().name();
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        persons.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);
    }

    private static List<Person> getPersons(){
        return List.of(new Person("pouya",20, MALE),
                new Person("ali",19, MALE),
                new Person("sina",18, MALE),
                new Person("parmida",22, FEMALE),
                new Person("nasima",21, FEMALE),
                new Person("atena",15, FEMALE));
    }

}
