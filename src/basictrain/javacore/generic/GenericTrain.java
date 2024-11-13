package basictrain.javacore.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTrain {
    public static void main(String[] args) {

        // You can’t add elements, only read them.
        List<?> unknownList = new ArrayList<>();
        //unknownList.add(10);

        List<Object> objectList = new ArrayList<>();
        Person person = new Person("pouya", 10);
        objectList.add(10);
        objectList.add("book");
        objectList.add(person);

        objectList.forEach(System.out::println);

        List<String> stringList = new ArrayList<>();
        stringList.add("pouya");
        stringList.add("book");

        //java: incompatible types: java.util.List<java.lang.String> cannot be converted to java.util.List<java.lang.Object>
        //person.printListOfObject(stringList);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person() {
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void printListOfObject(List<Object> list) {
            list.forEach(System.out::println);
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
