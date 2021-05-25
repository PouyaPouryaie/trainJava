package lambdatrain;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {

    public static void main(String[] args){

        /** static method reference
         * first Using a lambda expression
         * second Using a method reference */
        Function<Integer, String> fun1 = x -> Integer.toBinaryString(x);
        System.out.println(fun1.apply(20));

        Function<Integer, String> fun2 = Integer::toBinaryString;
        System.out.println(fun2.apply(20));


        // Uses a lambda expression
        BiFunction<Integer, Integer, Integer> func1 = (x, y) -> Integer.sum(x, y);
        System.out.println(func1.apply(17, 15));

        // Uses a method reference
        BiFunction<Integer, Integer, Integer> func2 = Integer::sum;
        System.out.println(func2.apply(17, 15));

        //Uses a lambda expression
        Consumer<String> consumer1 = str -> System.out.println(str);
        consumer1.accept("hello");

        //Uses a Instance method references
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("hello");

        //superType Instance Method reference
        Item apple = new Item("Apple", 0.75);
        apple.test();

        //Uses a lambda expression
        Supplier<String> str1 = () -> new String();
        Function<String, String> str2 = str -> new String(str);

        //Uses a constructor reference
        Supplier<String> str3 = String::new;
        Function<String, String> str4 = String::new;

        //find best constructor based on context with lambda expression
        Supplier<Item> item1 = () -> new Item();
        Function<String, Item> item2 = name -> new Item(name);
        BiFunction<String, Double, Item> item3 = (name, price) -> new Item(name, price);

        System.out.println(item1.get());
        System.out.println(item2.apply("pouya"));
        System.out.println(item3.apply("pouya", 0.75));

        //find best constructor based on context with constructor reference
        Supplier<Item> item4 = Item::new;
        Function<String, Item> item5 = Item::new;
        BiFunction<String, Double, Item> item6 = Item::new;

        System.out.println(item4.get());
        System.out.println(item5.apply("atena"));
        System.out.println(item6.apply("atena", 1.75));

    }
}

interface Priced {
    default double getPrice() {
        return 1.0;
    }
}

class Item implements Priced{

    private String name = "Unknown";
    private double price = 0.0;

    public Item() {
        System.out.println("Constructor Item() called.");
    }
    public Item(String name) {
        this.name = name;
        System.out.println("Constructor Item(String) called.");
    }
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        System.out.println("Constructor Item(String, double) called.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "name = " + getName() + ", price = " + getPrice();
    }

    public void test(){

        // Uses the Item.toString() method
        Supplier<String> s1 = this::toString;

        // Uses Object.toString() method
        Supplier<String> s2 = Item.super::toString;

        // Uses Item.getPrice() method
        Supplier<Double> s3 = this::getPrice;

        // Uses Priced.getPrice() method
        Supplier<Double> s4 = Priced.super::getPrice;

        // Uses all method references and prints the results
        System.out.println("this::toString: " + s1.get());
        System.out.println("Item.super::toString: " + s2.get());
        System.out.println("this::getPrice: " + s3.get());
        System.out.println("Priced.super::getPrice: " + s4.get());

    }
}
