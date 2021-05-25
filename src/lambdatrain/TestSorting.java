package lambdatrain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestSorting {

    public static void main(String[] args){

        List<Developer> developers = getDeveloper();

        System.out.println("before sort");
        developers.forEach(System.out::println);

        System.out.println("sort by Age");
        developers.sort(Comparator.comparingInt(Developer::getAge));
        developers.forEach((developer -> System.out.println(developer)));

        System.out.println("sort with salary");
        Comparator<Developer> salaryComprator = Comparator.comparing(Developer::getSalary);
        developers.sort(salaryComprator);
        developers.forEach(System.out::println);

        System.out.println("sort with multi field");
        Comparator<Developer> comparatorMultiField = Comparator.comparing(Developer::getSalary).thenComparing(Developer::getAge);
        developers.sort(comparatorMultiField);
        developers.forEach(System.out::println);
    }

    public static List<Developer> getDeveloper(){
        List<Developer> result = new ArrayList<>();

        result.add(new Developer("pouya", 33,new BigDecimal("70000")));
        result.add(new Developer("ramin", 20,new BigDecimal("80000")));
        result.add(new Developer("reza", 20,new BigDecimal("70000")));
        result.add(new Developer("ali", 10,new BigDecimal("100000")));
        result.add(new Developer("sina", 55,new BigDecimal("170000")));
        result.add(new Developer("riaz", 22,new BigDecimal("170000")));
        return result;
    }

}


class Developer{
    String name;
    int age;
    BigDecimal salary;

    public Developer(String name, int age, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}