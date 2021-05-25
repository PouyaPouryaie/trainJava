package lambdatrain.functionalprogramming.traverse;

import java.util.*;

public class SimpleIterate {

    public static void main(String[] args) {

        //List
        List<Car> cars = Arrays.asList(
                new Car("Nissan" , "Sentra" ),
                new Car("Chevrolet", "Vega" ),
                new Car("Hyundai " , "Elantra"),
                new Car("Buick" , "Regal")
        );

        System.out.println("first solution:");
        Iterator<Car> it = cars.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("\nsecond solution:");
        cars.iterator().forEachRemaining(c -> c.setModel(c.getModel().concat(" new Brand")));
        cars.forEach(System.out::println);


        //spliterator and use trySplit() for partition collection
        System.out.println("\nspliterator solution:");
        Spliterator<Car> spliterator = cars.spliterator();
        Spliterator<Car> halfList = spliterator.trySplit();

        halfList.forEachRemaining(System.out::println);

        //Set
        System.out.println("\nset solution:");
        Set<String> colors = new TreeSet<>();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.iterator().forEachRemaining(x -> System.out.println(x));

        //Map Iterate
        System.out.println("\nmap solution:");
        TreeMap<String, Double> employeeSalaries = new TreeMap<>();
        employeeSalaries.put("Joe Smith", 100000.0);
        employeeSalaries.put("Maggie Jones", 110000.0);
        employeeSalaries.put("Larry Rodriguez", 105000.0);

        employeeSalaries.forEach( (x,y) ->
                System.out.println(x + " makes $" + y + " annually."));
    }
}

class Car {
    private String make;
    private String model;
    public Car(String ma, String mo)
    {
        make = ma;
        model = mo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {return make + " " + model; }
}
