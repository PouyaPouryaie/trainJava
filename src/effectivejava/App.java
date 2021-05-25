package effectivejava;

import effectivejava.ch2.ConstructorWithManyParameter;
import effectivejava.ch2.samplebuilderhierarchy.Calzone;
import effectivejava.ch2.samplebuilderhierarchy.NyPizza;
import effectivejava.ch2.samplebuilderhierarchy.Pizza;
import effectivejava.ch3.BasicClass;
import effectivejava.ch4.CalculatorStaticMember;
import effectivejava.ch5.GenericImmutable;
import effectivejava.ch5.SwapGenericClazz;

import java.util.*;

public class App {

    public static void main(String[] args) {

        //ch2
        ConstructorWithManyParameter cocaCola = new ConstructorWithManyParameter.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();

        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSAGE).build();
        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).souceInside().build();

        //ch3
        BasicClass basicClass = new BasicClass("pouya", 23,1471,14000.0);

        BasicClass basicClassOne = basicClass.clone();

        System.out.println(basicClass.equals(basicClassOne));

        System.out.println(basicClass.getClass() == basicClassOne.getClass());

        System.out.println(basicClass.clone() == basicClass);


        BasicClass aClass = new BasicClass("pouya", 27,1471,14000.0);
        BasicClass bClass = new BasicClass("ali", 27,1471,14000.0);
        BasicClass cClass = new BasicClass("alireza", 27,1471,15000.0);
        BasicClass dClass = new BasicClass("sina", 32,3271,14000.0);

        System.out.println(aClass.compareTo(bClass));

        Set<BasicClass> sets = new TreeSet<>();
        sets.add(aClass);
        sets.add(bClass);
        sets.add(dClass);
        sets.add(cClass);

        for (BasicClass re: sets) {
            System.out.println(re);
        }

        //ch4
        CalculatorStaticMember calculatorStaticMember = new CalculatorStaticMember();
        calculatorStaticMember.new PublicOperation();


        //ch5
        GenericImmutable<BasicClass> genericImmutableBasicClass = GenericImmutable.instanceOf(basicClass,20, "BasicClass Type");
        System.out.println(genericImmutableBasicClass.getName());
        System.out.println(genericImmutableBasicClass.getT().getAge());

        List<String> ss = new ArrayList<>();
        ss.add("a");ss.add("b");ss.add("c");ss.add("d");ss.add("e");
        SwapGenericClazz.swap(ss, 2,3);
        System.out.println(ss.get(2));

    }
}
