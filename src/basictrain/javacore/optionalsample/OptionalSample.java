package basictrain.javacore.optionalsample;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class OptionalSample {
    public static void main(String[] args) {

        Map sample = new HashMap<String, Object>()
        {{
            put("one", 1);
            put("two", 2);
            put("three", 3);
        }};

        Object o = Optional.ofNullable(sample.get("four")).orElseGet(() -> {
            sample.put("four", 4);
            return sample.get("four");
        });
        System.out.println(o);

        Customer customer = new Customer("pouya", null);
        Order order = new Order(customer);
        processObject(order);
    }

    // Null Checking by using FailFast and Optional
    public static void processObject(Order order) {
        Objects.requireNonNull(order, "order is null");
        Optional.ofNullable(order.customer)
                .map(c -> c.email)
                .ifPresent(System.out::println);
    }

    public static class Order {

        public Customer customer;

        public Order(Customer customer) {
            this.customer = customer;
        }
    }

    public static class Customer {
        public String name;
        public String email;

        public Customer(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
}
