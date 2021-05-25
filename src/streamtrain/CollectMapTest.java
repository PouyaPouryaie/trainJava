package streamtrain;

import java.time.Month;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectMapTest {


    public static void main(String[] args){

        Map<Long,String> idToNameMap =Person.persons()
                .stream()
                .collect(Collectors.toMap(Person::getId, Person::getName));

        System.out.println(idToNameMap);


        //MapWithThreeParameters
        Map<String, Person> topHits = Person.persons().stream().collect(
                Collectors.toMap(Person::getName, person -> person, BinaryOperator.maxBy(Comparator.comparing(Person::getIncome))));

        // collect base on gender
        Map<Person.Gender, String> genderToNameMap = Person.persons()
                .stream()
                .collect(Collectors.toMap(Person::getGender, Person::getName,
                        (oldValue, newValue) -> String.join(",", oldValue, newValue)));

        System.out.println(genderToNameMap);

        // find highest income with gender grouping
        // function.identity == person -> person
        Map<Person.Gender, Person> genderPersonMap = Person.persons()
                .stream()
                .collect(Collectors.toMap(Person::getGender, Function.identity(),
                        (oldPerson, newPerson) -> newPerson.getIncome() > oldPerson.getIncome() ? newPerson: oldPerson));

        System.out.println(genderPersonMap);


        //Grouping Data

        Map<Person.Gender, List<Person>> personsByGender = Person.persons()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender));
        System.out.println(personsByGender);


        //count of person with grouping
        Map<Person.Gender, Long> countByGender = Person.persons()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
        System.out.println(countByGender);


        //collects the names for a group in a comma-separated
        Map<Person.Gender, String> namesByGender = Person.persons()
                .stream()
                .collect(Collectors.groupingBy(
                        Person::getGender, Collectors.mapping(Person::getName, Collectors.joining(","))));

        System.out.println(namesByGender);

        //collects the names for a group in list
        Map<Person.Gender, List<String>> namesByGenderList = Person.persons()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(namesByGenderList);


        //Using Nested Groupings
        Map<Person.Gender, Map<Month, String>> personsByGenderAndDobMonth = Person.persons()
                .stream()
                .collect(Collectors.groupingBy(
                        Person::getGender, Collectors.groupingBy(
                                p -> p.getDob().getMonth(), Collectors.mapping(Person::getName, Collectors.joining(", ")))));

        System.out.println(personsByGenderAndDobMonth);

        //statistic grouping
        Map<Person.Gender, DoubleSummaryStatistics> incomeStatsByGender = Person.persons()
                .stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.summarizingDouble(Person::getIncome)));

        System.out.println(incomeStatsByGender);

        //Partition collector without collector
        Map<Boolean, List<Person>> partionedByMaleGender = Person.persons()
                .stream()
                .collect(Collectors.partitioningBy(p -> p.isMale())); // Person::isMale

        System.out.println(partionedByMaleGender);

        //Partition collectors with collector
        Map<Boolean, String> partionedByMale = Person.persons()
                .stream()
                .collect(Collectors.partitioningBy(Person::isMale, Collectors.mapping(Person::getName, Collectors.joining(", "))));
        System.out.println(partionedByMale);
    }
}
