package streamtrain;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

public class StatisticTest {

    public static void main(String[] args){

        DoubleSummaryStatistics dss = new DoubleSummaryStatistics();
        dss.accept(100);
        dss.accept(200);
        dss.accept(400);

        System.out.println(dss.getCount());
        System.out.println(dss.getMax());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMin());
        System.out.println(dss.getSum());

        long count = dss.getCount();
        double sum = dss.getSum();
        double min = dss.getMin();
        double avg = dss.getAverage();
        double max = dss.getMax();

        System.out.printf("count=%d, sum=%.2f, min=%.2f, average=%.2f, max=%.2f%n",
                count, sum, min, max, avg);


        //summery statistic
        DoubleSummaryStatistics incomeStats =
                Person.persons()
                        .stream()
                        .map(Person::getIncome)
                        .collect(DoubleSummaryStatistics::new,
                                DoubleSummaryStatistics::accept,
                                DoubleSummaryStatistics::combine);
        System.out.println("first way " + incomeStats);

        //second way
        DoubleSummaryStatistics incomeStats2 = Person.persons()
                .stream()
                .collect(Collectors.summarizingDouble(Person::getIncome));

        System.out.println("second way " + incomeStats);
    }
}
