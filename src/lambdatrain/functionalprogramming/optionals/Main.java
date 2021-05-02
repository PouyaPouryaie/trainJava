package lambdatrain.functionalprogramming.optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        //
        Optional<Object> empty = Optional.empty();

        System.out.println(empty.isPresent());
        System.out.println(empty.isEmpty());

        //
        Optional<String> hello = Optional.of("hello");

        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        //
        Object value = Optional.ofNullable(null).orElseGet(() -> "default");

        System.out.println(value);

        //
        Optional.ofNullable("pouya@gmail.com")
                .ifPresentOrElse(System.out::println,
                        ()-> System.out.println("cannot read email"));

        //
        Optional<String> optional = Optional.ofNullable("pouya");

        String defaultValue = optional.map(String::toUpperCase)
                .orElse("default value");

        System.out.println(defaultValue);

        Person person = new Person("pouya", null);

        System.out.println(person.getEmail().map(String::toUpperCase).orElse("email not set"));

        if(person.getEmail().isPresent()){
            System.out.println(person.getEmail().get().toUpperCase());
        }else{
            System.out.println("email not set");
        }

    }
}

class Person{
    private final String name;
    private final String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}