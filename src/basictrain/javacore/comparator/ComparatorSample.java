package basictrain.javacore.comparator;

import java.util.ArrayList;
import java.util.List;

public class ComparatorSample {

    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>(){{
            add(new Human("alex", 40));
            add(new Human("pouya", 20));
            add(new Human("ali", 20));
            add(new Human("mehdi", 40));
        }};

        AgeCompare ageCompare = new AgeCompare();
        NameCompare nameCompare = new NameCompare();

        humans.sort(ageCompare.thenComparing(nameCompare));

        humans.forEach(System.out::println);

    }
}
