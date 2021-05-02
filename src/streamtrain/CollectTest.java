package streamtrain;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectTest {

    public static void main(String[] args){

        //lambda expression for collect stream
        List<String> names = Person.persons()
                .stream()
                .map(n -> n.getName())
                .collect(() -> new ArrayList<>(), (list, name) -> list.add(name), (list1, list2) -> list1.addAll(list2));

        System.out.println("lambda list is " + names);

        //reference for collect stream
        List<String> nameList = Person.persons()
                .stream()
                .map(Person::getName)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println("reference list is " + nameList);

        //second Method for collect
        List<String> names2 = Person.persons().stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("name list is " + names2);

        //sorted collected
        SortedSet<String> uniqueSortedNames = Person.persons().stream().map(n -> n.getName()).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("name sorted list is " + uniqueSortedNames);

        //second way
        List<String> uniqueSortedNames2 = Person.persons().stream().map(n -> n.getName()).sorted().collect(Collectors.toList());
        System.out.println("name sorted list is " + uniqueSortedNames2);

        SortedSet<Integer> sortNumber = Stream.of(1,50,90,29,12,44,100,67).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("number sorted list is " + sortNumber);


        //counting
        long countName = Person.persons().stream().map(n -> n.getName()).collect(Collectors.counting());
        System.out.println("count of person " + countName);

        //second way
        long countName2 = Person.persons().stream().count();
        System.out.println("count of person " + countName2);

    }
}
