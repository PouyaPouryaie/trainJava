package lambdatrain.functionalprogramming.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateSample {

    public static void main(String[] args) {

        Predicate<Integer> checkNum = number -> number > 7;

        if(checkNum.test(4)){
            System.out.println("number greater than 7");
            return;
        }
        System.out.println("number is samll");


        //use function as argument in method
        result(x -> x >= 7, 9);
        result(x -> x % 2 ==0, 7);
        result(x -> x.equals("pouya"), "pouya");

        // regular define
        Predicate<Integer> p1 = x -> x > 7;
        Predicate<Integer> p2 = x -> x % 2 == 0;

        //static method in predicate
        Predicate<Integer> p3 = Predicate.isEqual(10);
        Predicate<Integer> p4 = Predicate.not(x -> x % 2 == 1);

        //Predicate Chain
        result(p1.and(p2), 12);
        result(p1.or(p2), 11);
        result(p1.negate().and(p2), 4);
        result(p1.and(p2).and(p3), 10);
        result(p1.and(p2).and(p3).and(p4), 10);


        //BiPredicate
        BiPredicate<Integer, String> biPredicate = (x, y) -> x > 7 && y.charAt(0) == 'H';

        if(biPredicate.test(10, "Hello")){
            System.out.println("all things is good");
        }
    }

    protected static <X> void result(Predicate<X> predicate, X argument){
        if (predicate.test(argument)) {
            System.out.println("result is true");
        } else {
            System.out.println("result is false");
        }
    }
}
