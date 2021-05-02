package streamtrain;

public class ReduceTest {

    public static void main(String[] args){

        //Reduce intro
        double sum = Person.persons()
                .stream()
                .map(Person::getIncome)
                .reduce(0.0, Double::sum);

        System.out.println("basic reduce result is " + sum);


        System.out.println("big problem");
        //Reduce with combiner in parallel programming
        // note: if you are not use parallel, then combiner part is not called
        // in this example double::sum is not called
        double sump = Person.persons()
                .stream()
                .reduce(0.0, (partialSum, person) -> partialSum + person.getIncome(), Double::sum);
        System.out.println("without use parallel is " + sump);




        // parallel used combiner
        double sumc = Person.persons()
                .parallelStream()
                .reduce(0.0,
                        (Double partialSum,Person p) -> {
                            double accumulated = partialSum + p.getIncome();
                            System.out.println(Thread.currentThread().getName() +
                                    " - Accumulator: partialSum = " +
                                    partialSum + ", person = " + p +
                                    ", accumulated = " + accumulated);
                            return accumulated;
                        },
                        (a, b) -> {
                            double combined = a + b;
                            System.out.println(Thread.currentThread().getName() +
                                    " - Combiner: a = " + a + ", b = " + b +
                                    ", combined = " + combined);
                            return combined;
                        });

        System.out.println("parallel result is " + sum);
    }

}
