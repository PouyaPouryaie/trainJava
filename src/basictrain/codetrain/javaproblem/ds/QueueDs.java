package basictrain.codetrain.javaproblem.ds;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDs {

    public static void main(String[] args) {
        Queue<StackDs.Person> queue = new LinkedList<>();
        queue.add(new StackDs.Person("pouya", 10));
        queue.add(new StackDs.Person("sina", 20));
        queue.add(new StackDs.Person("atena", 30));
        queue.add(new StackDs.Person("ali", 30));

        Queue<String> stringQueue = new ArrayDeque<>();

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        queue.stream().forEach(System.out::println);
        queue.forEach(System.out::println);

    }
}
