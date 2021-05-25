package lambdatrain.factorypattern.basic;

import java.util.HashMap;
import java.util.Map;

public class TestTriFunction {

    public static void main(String[] args){


        TriFunction<Integer,String, String, Apple> appleCreator = Apple::new;
        Apple apple = appleCreator.apply(10,"mina","Red");
        System.out.println(apple.toString());

        final Map<String, TriFunction<Integer,String, String, Product>> map1 = new HashMap<>();

        map1.put("Apple", Apple::new);
        map1.put("Benana", Benana::new);


        Apple a1 = (Apple) map1.get("Apple").apply(20,"damavand", "Green");
        Apple a2 = (Apple) map1.get("Apple").apply(10,"yazd", "Red");
        Benana b1 = (Benana) map1.get("Benana").apply(120,"Moraco", "Yellow");
        Benana b2 = (Benana) map1.get("Benana").apply(120,"Khozestan", "Yellow");


        System.out.println("first :" + a1 + "\n second :" +b1);
    }
}
