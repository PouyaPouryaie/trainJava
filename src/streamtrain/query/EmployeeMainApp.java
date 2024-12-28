package streamtrain.query;

import java.util.*;
import java.util.stream.Collectors;

/**
 * this question come from this link:
 * https://medium.com/@dibasbehera/solving-real-time-queries-using-java-8-features-ea8a33771690
 *
 * Solving Real-Time Queries Using Java 8 Features
 */

public class EmployeeMainApp {

    public static List<Employee> employeeList = new ArrayList<>();

    public static void loadEmpRecords() {
        employeeList.add(new Employee(111, "Jennifer Flores", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Mr. Jacob Parker", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Tony Williams", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "David King", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Christina Baker", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "John Murphy", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Daniel Jackson", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "William Foster", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Linda Li", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Justin Ward", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Lisa Aguilar", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Daniel Morris", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Elizabeth Moody", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "William Williams", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Dr. John Obrien", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sara Farrell", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Eric Smith", 31, "Male", "Product Development", 2012, 35700.0));
    }

    public static void loadEmpDuplicateRecords() {
        employeeList.add(new Employee(111, "Jennifer Flores", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(111, "Jennifer Flores", 33, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Mr. Jacob Parker", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(122, "Mr. Jacob Parker", 20, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Tony Williams", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(133, "Tony Williams", 30, "Male", "Infrastructure", 2012, 18000.0));
    }

    public static void main(String[] args) {

        loadEmpDuplicateRecords();

        System.err.println("0. How to find maximum age for each duplicate records");

        Map<Integer, Optional<Employee>> maximumAgeForEachEmployeeId = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getId, Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));
        maximumAgeForEachEmployeeId.forEach((empId, employee) -> {
            System.out.printf("key: { %s }, value: { %s }%n", empId, employee);
        });

        try {
            employeeList.clear();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        loadEmpRecords();


        System.err.println("1. How many male and female employees are there in the organization?");
        employeeList.stream().collect(Collectors.groupingBy(employee -> employee.gender)).forEach((s, employees) -> System.out.printf("count of %s in list is %s%n", s, employees.size()));
        //or
        Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployees);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("2. Print the name of all departments in the organization?");
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("3. What is the average age of male and female employees?");
        Map<String, Double> averageAgeOfMaleAndFemaleEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingLong(Employee::getAge)));
        System.out.println(averageAgeOfMaleAndFemaleEmp);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("4. Get the details of highest paid employee in the organization?");
        Optional<Employee> maxSal = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(maxSal.get());
        //or
        Optional<Employee> maxSal2 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(maxSal2.get());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("5. Get the names of all employees who have joined after 2015?");
        employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("6. Count the number of employees in each department?");
        Map<String, Long> noEmployeesInDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        noEmployeesInDept.forEach((s, aLong) -> System.out.println(s + " : " + aLong));

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("7. What is the average salary of each department?");
        Map<String, Double> avgSalDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        avgSalDept.forEach((s, aLong) -> System.out.println(s + " : " + aLong));

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("8. Get the details of youngest male employee in the product development department?");
        Optional<Employee> youngestEmployee = employeeList.stream().filter(employee -> employee.gender.equals("Male") && employee.getDepartment().equals("Product Development")).min(Comparator.comparing(Employee::getAge));
        System.out.println(youngestEmployee.get());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("9. Who has the most working experience in the organization?");
        Optional<Employee> mostWorkingExpEmp = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
        System.out.println(mostWorkingExpEmp.get());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("10. How many male and female employees are there in the sales and marketing team?");
        Map<String, Long> maleAndFemaleInSaleMarketTeam = employeeList.stream().filter(employee -> employee.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(maleAndFemaleInSaleMarketTeam);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("11. What is the average salary of male and female employees?");
        Map<String, Double> avgSalaryOfMaleAndFemale = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryOfMaleAndFemale);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("12. List down the names of all employees in each department?");
        Map<String, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        collect.forEach((s, employees) -> {
            System.out.printf("Department of %s%n", s);
            System.out.printf("----------------------- %n");
            employees.forEach(employee -> System.out.printf(employee.getName() + " "));
            System.out.printf("%n ----- END DEP ---- %n");
        });

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("13. What is the average salary and total salary of the whole organization?");
        Double totalSalary = employeeList.stream().map(Employee::getSalary).reduce(Double::sum).get();
        System.out.printf("total salary is %s %n", totalSalary);

        //or
        //insight
        DoubleSummaryStatistics employeeLStats = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary : "+employeeLStats.getAverage());
        System.out.println("Total Salary : "+employeeLStats.getSum());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //insight
        System.err.println("14. Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.");
        Map<Boolean, List<Employee>> partitionEmployees = employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() <= 25));

        Set<Map.Entry<Boolean, List<Employee>>> entries = partitionEmployees.entrySet();
        for (Map.Entry<Boolean, List<Employee>> entry: entries)
        {
            if(entry.getKey())
            {
                System.out.println("Employee older than 25 years");
            }else {
                System.out.println("Employee younger than or equals to 25 years");
            }
            System.out.println("------------------------------------------------");
            for(Employee emp : entry.getValue())
            {
                System.out.println(emp.getName());
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.err.println("15. Who is the oldest employee in the organization? What is his age and which department he belongs to?");
        Optional<Employee> oldEmployee = employeeList.stream().max(Comparator.comparing(Employee::getAge));
        System.out.println("Name: " + oldEmployee.get().getName());
        System.out.println("Age: " + oldEmployee.get().getAge());
        System.out.println("Department: " + oldEmployee.get().getDepartment());

    }
}
