package basictrain.codetrain.javaproblem.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * LinkList and any linked structures in java use doubleLinkedList concept.
 */
public class ListDs {

    public static void main(String[] args) {
        List<StackDs.Person> people = new ArrayList<>();

        people.add(new StackDs.Person("ali", 10));
        people.add(new StackDs.Person("pouya", 20));
        people.add(new StackDs.Person("alireza", 30));

        LinkedList<StackDs.Person> persons = new LinkedList<>(people);

        persons.add(new StackDs.Person("peter", 20));

        System.out.println(persons.getFirst());
        System.out.println(persons.getLast());
        System.out.println(persons.size());

        ListIterator<StackDs.Person> personListIterator = persons.listIterator();

        while (personListIterator.hasNext()){
            System.out.println(personListIterator.next());
        }

        System.out.println("reverse iteration");

        while (personListIterator.hasPrevious()){
            System.out.println(personListIterator.previous());
        }
    }
}
