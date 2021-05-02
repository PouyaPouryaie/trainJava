package lambdatrain.functionalprogramming.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalSample {

    public static void main(String[] args) {

        //regular
        Function<Integer, String> f = (x) -> Integer.toString(x);
        System.out.println(f.apply(20));

        //definition
        Function<Integer, String> fis = x -> Integer.toString(x);
        Function<String, Integer> fsi = x -> Integer.parseInt(x);

        //function as argument in method
        System.out.println(transform(fis, 10));
        System.out.println(transform(fsi, "120"));

        //BiFunction
        BiFunction<Integer,Character,String> bi = (x, z) -> {
            if (Character.isUpperCase(z))
                return (x%2)==0? "EVEN" : "ODD";
            return (x%2)==0? "even" : "odd";
        };
        System.out.println(bi.apply(4,'U'));
    }

    protected static <T, R> R transform(Function<T,R> function, T t){
        return function.apply(t);
    }
}
