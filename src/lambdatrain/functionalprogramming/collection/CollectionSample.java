package lambdatrain.functionalprogramming.collection;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.function.UnaryOperator;

public class CollectionSample {

    public static void main(String[] args) {

        //remove
        ArrayList<String> list = new ArrayList<>();
        list.add("Super");
        list.add("Random");
        list.add("Silly");
        list.add("Strings");
        list.removeIf(x -> x.charAt(0) == 'S');
        list.forEach(x -> System.out.println(x));


        //setAll
        IntToDoubleFunction idf = x -> (new Random()).nextFloat();
        double[] dlist = new double[4];
        Arrays.setAll(dlist, idf);
        for(double d : dlist){
            System.out.println(d);
        }

        //replaceList
        System.out.println(" replace:");
        List<Integer> alist = Arrays.asList(10,12,14,18);
        UnaryOperator<Integer> div4 = x -> x /4;
        alist.replaceAll(div4);
        alist.forEach(System.out::println);

        //replaceMap
        System.out.println(" replace Map:");
        Map<String,String> map = new TreeMap<>();
        map.put("Smith", "Robert");
        map.put("Jones", "Alex");
        BiFunction<String,String,String> bi = (k, v) -> "Mr. " + v;
        map.replaceAll(bi);
        map.forEach( (x,y) -> System.out.println(y + " " + x));

        //parallelComputationOnArray
        System.out.println(" parallel computation:");
        int[] arr = {2,3,4,3};
        IntBinaryOperator op = (x, y) -> x * y;
        Arrays.parallelPrefix(arr, op);
        for (int i: arr)
            System.out.println(i);


    }
}
