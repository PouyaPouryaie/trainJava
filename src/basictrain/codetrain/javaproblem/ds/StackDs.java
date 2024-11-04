package basictrain.codetrain.javaproblem.ds;

import java.util.ListIterator;
import java.util.Stack;

public class StackDs {

    public static void main(String[] args) {
        Stack<Person> stack = new Stack<>();
        stack.push(new Person("ali", 10));
        stack.push(new Person("pouya", 20));
        stack.push(new Person("atena", 30));

        System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.forEach(System.out::println);
        stack.stream().forEach(person -> System.out.println(person.getName()));
        ListIterator<Person> personListIterator = stack.listIterator();
        while (personListIterator.hasNext()){
            System.out.println(personListIterator.next());
        }
        System.out.println(stack.pop());
        System.out.println(stack.size());

    }

    static class Person{
        private final String name;
        private final Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
