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
    record QueryInfo(String description, Runnable runnable) {}
    private static final Map<String, QueryInfo> queries = new LinkedHashMap<>();

    public static void loadStandardEmpRecords() {
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

    public static void loadDuplicateEmpRecords() {
        employeeList.add(new Employee(111, "Jennifer Flores", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(111, "Jennifer Flores", 33, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Mr. Jacob Parker", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(122, "Mr. Jacob Parker", 20, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Tony Williams", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(133, "Tony Williams", 30, "Male", "Infrastructure", 2012, 18000.0));
    }

    // Helper to clear and load mixed records (for query 18)
    public static void loadMixedEmpRecords() {
        employeeList.clear();
        loadStandardEmpRecords(); // Add standard records first
        loadDuplicateEmpRecords();// Add duplicate records without clearing again
    }

    // Static initializer block to populate the queries map
    static {
        loadStandardEmpRecords();
        loadDuplicateEmpRecords();

        // Query 0: How to find maximum age for each duplicate records
        queries.put("0", new QueryInfo("Max age for each duplicate record", () -> {
            Map<Integer, Optional<Employee>> maximumAgeForEachEmployeeId = employeeList.stream()
                    .collect(Collectors.groupingBy(Employee::getId, Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));
            maximumAgeForEachEmployeeId.forEach((empId, employee) -> {
                System.out.printf("key: { %s }, value: { %s }%n", empId, employee);
            });
        }));

        // Query 1: How many male and female employees are there in the organization?
        queries.put("1", new QueryInfo("Male and Female employee count", () -> {
            employeeList.stream().collect(Collectors.groupingBy(employee -> employee.gender)).forEach((s, employees) -> System.out.printf("count of %s in list is %s%n", s, employees.size()));
            Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
            System.out.println(noOfMaleAndFemaleEmployees);
        }));

        // Query 2: Print the name of all departments in the organization?
        queries.put("2", new QueryInfo("Print names of all departments", () -> {
            employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
        }));

        // Query 3: What is the average age of male and female employees?
        queries.put("3", new QueryInfo("Average age of male and female employees", () -> {
            Map<String, Double> averageAgeOfMaleAndFemaleEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingLong(Employee::getAge)));
            System.out.println(averageAgeOfMaleAndFemaleEmp);
        }));

        // Query 4: Get the details of highest paid employee in the organization?
        queries.put("4", new QueryInfo("Details of highest paid employee", () -> {
            Optional<Employee> maxSal = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
            maxSal.ifPresent(System.out::println);
            Optional<Employee> maxSal2 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
            maxSal2.ifPresent(System.out::println);
        }));

        // Query 5: Get the names of all employees who have joined after 2015?
        queries.put("5", new QueryInfo("Names of employees who joined after 2015", () -> {
            employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
        }));

        // Query 6: Count the number of employees in each department?
        queries.put("6", new QueryInfo("Employee count per department", () -> {
            Map<String, Long> noEmployeesInDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
            noEmployeesInDept.forEach((s, aLong) -> System.out.println(s + " : " + aLong));
        }));

        // Query 7: What is the average salary of each department?
        queries.put("7", new QueryInfo("Average salary of each department", () -> {
            Map<String, Double> avgSalDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
            avgSalDept.forEach((s, aLong) -> System.out.println(s + " : " + aLong));
        }));

        // Query 8: Get the details of the youngest male employee in the product development department?
        queries.put("8", new QueryInfo("Youngest male employee in Product Development", () -> {
            Optional<Employee> youngestEmployee = employeeList.stream().filter(employee -> employee.gender.equals("Male") && employee.getDepartment().equals("Product Development")).min(Comparator.comparing(Employee::getAge));
            youngestEmployee.ifPresent(System.out::println);
        }));

        // Query 9: Who has the most working experience in the organization?
        queries.put("9", new QueryInfo("Employee with most working experience", () -> {
            Optional<Employee> mostWorkingExpEmp = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
            mostWorkingExpEmp.ifPresent(System.out::println);
        }));

        // Query 10: How many male and female employees are there in the sales and marketing team?
        queries.put("10", new QueryInfo("Male/Female count in Sales and Marketing", () -> {
            Map<String, Long> maleAndFemaleInSaleMarketTeam = employeeList.stream().filter(employee -> employee.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
            System.out.println(maleAndFemaleInSaleMarketTeam);
        }));

        // Query 11: What is the average salary of male and female employees?
        queries.put("11", new QueryInfo("Average salary of male and female employees", () -> {
            Map<String, Double> avgSalaryOfMaleAndFemale = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
            System.out.println(avgSalaryOfMaleAndFemale);
        }));

        // Query 12: List down the names of all employees in each department?
        queries.put("12", new QueryInfo("Names of all employees in each department", () -> {
            Map<String, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
            collect.forEach((s, employees) -> {
                System.out.printf("Department of %s%n", s);
                System.out.printf("----------------------- %n");
                employees.forEach(employee -> System.out.printf(employee.getName() + " "));
                System.out.printf("%n ----- END DEP ---- %n");
            });
        }));

        // Query 13: What is the average salary and total salary of the whole organization?
        queries.put("13", new QueryInfo("Average and total salary of organization", () -> {
            Double totalSalary = employeeList.stream().mapToDouble(Employee::getSalary).sum(); // Use mapToDouble and sum directly
            System.out.printf("total salary is %s %n", totalSalary);

            DoubleSummaryStatistics employeeLStats = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
            System.out.println("Average Salary : " + employeeLStats.getAverage());
            System.out.println("Total Salary : " + employeeLStats.getSum());
        }));

        // Query 14: Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
        queries.put("14", new QueryInfo("Partition employees by age (<=25 vs >25)", () -> {
            Map<Boolean, List<Employee>> partitionEmployees = employeeList.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() <= 25));

            Set<Map.Entry<Boolean, List<Employee>>> entries = partitionEmployees.entrySet();
            for (Map.Entry<Boolean, List<Employee>> entry : entries) {
                if (entry.getKey()) { // True means age <= 25
                    System.out.println("Employees 25 years or younger");
                } else { // False means age > 25
                    System.out.println("Employees older than 25 years");
                }
                System.out.println("------------------------------------------------");
                for (Employee emp : entry.getValue()) {
                    System.out.println(emp.getName());
                }
            }
        }));
            System.err.println("15. Who is the oldest employee in the organization? What is his age and which department he belongs to?");

        // Query 15: Who is the oldest employee in the organization? What is his age and which department he belongs to?
        queries.put("15", new QueryInfo("Oldest employee details", () -> {
            Optional<Employee> oldEmployee = employeeList.stream().max(Comparator.comparing(Employee::getAge));
            oldEmployee.ifPresent(emp -> {
                System.out.println("Name: " + emp.getName());
                System.out.println("Age: " + emp.getAge());
                System.out.println("Department: " + emp.getDepartment());
            });
        }));

        // Query 16: Print the numbers along with their frequencies (extra example)
        queries.put("16", new QueryInfo("Print numbers along with their frequencies", () -> {
            List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4); // Data specific to this query
            Map<Integer, Long> frequencyMap = numbers.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()));
            frequencyMap.forEach((k, v) -> System.out.println(k + " -> " + v));
        }));

        // Query 17: Find the duplicate numbers in the given list (extra example)
        queries.put("17", new QueryInfo("Find duplicate numbers in a list", () -> {
            List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4); // Data specific to this query
            Set<Integer> duplicates = numbers.stream().filter(num -> Collections.frequency(numbers, num) > 1)
                    .collect(Collectors.toSet());
            System.out.println("Duplicate Numbers: " + duplicates);
        }));

        // Query 18: Merge the duplicate Ids from the given list (Merge Function)
        queries.put("18", new QueryInfo("Merge duplicate IDs (Merge Function)", () -> {
            loadMixedEmpRecords(); // Load combined standard and duplicate records
            System.out.println("Before merging duplicate, size of list: " + employeeList.size());
            Map<Integer, Employee> uniqueEmployeeMap = employeeList.stream()
                    .collect(Collectors.toMap(Employee::getId, employee -> employee, (existingEmp, newEmp) -> newEmp));
            System.out.println("After merging duplicate, size of map: " + uniqueEmployeeMap.size());
            uniqueEmployeeMap.forEach((k, v) -> System.out.println(k + " -> " + v));
        }));
    }

    // --- Utility method to pause execution ---
    private static void pauseExecution(Scanner scanner) {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine(); // Consume the newline and wait for user input
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Initialize scanner once

        if(args.length > 0) {
            // Non-interactive mode (runs if command-line arguments are provided)
            System.out.println("Running selected queries from command-line arguments: " + Arrays.toString(args) + "\n");
            System.out.println("-----------------------------------------\n");

            for (String arg : args) {
                QueryInfo queryInfo = queries.get(arg);
                if (queryInfo != null) {
                    System.out.println("Executing Query " + arg + ": " + queryInfo.description() + "...");
                    queryInfo.runnable().run();
                    System.out.println("\n-----------------------------------------\n");
                    pauseExecution(scanner);
                } else {
                    System.err.println("Error: Query '" + arg + "' not found. Please provide valid query numbers (0-18).");
                }
            }
        } else {
            // Interactive mode (runs if no command-line arguments are provided)
            System.out.println("Welcome to Employee Query App (Interactive Mode)!");
            System.out.println("-----------------------------------------\n");

            while (true) {
                System.out.println("Available Queries:");
                queries.forEach((key, info) -> System.out.printf("%s. %s%n", key, info.description()));
                System.out.println("\nEnter query numbers (e.g., '1 3 5' or '0,18').");
                System.out.println("Type 'all' to run all queries, or 'exit' to quit.");
                System.out.print("> ");

                String inputLine = scanner.nextLine().trim();

                if (inputLine.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting application. Goodbye!");
                    break; // Exit the loop and terminate the program
                } else if (inputLine.equalsIgnoreCase("all")) {
                    System.out.println("\nRunning ALL queries in default order.\n");
                    System.out.println("-----------------------------------------\n");
                    for (Map.Entry<String, QueryInfo> entry : queries.entrySet()) {
                        System.out.println("Executing Query " + entry.getKey() + ": " + entry.getValue().description() + "...");
                        entry.getValue().runnable().run();
                        System.out.println("\n-----------------------------------------\n");
                        pauseExecution(scanner);
                    }
                } else {
                    Set<String> selectedQueryKeys = new LinkedHashSet<>(); // Use LinkedHashSet to preserve user input order
                    // Split by comma or space
                    String[] parts = inputLine.split("[,\\s]+");
                    for (String part : parts) {
                        if (!part.isEmpty()) { // Avoid empty strings from multiple delimiters
                            selectedQueryKeys.add(part);
                        }
                    }

                    if (selectedQueryKeys.isEmpty()) {
                        System.out.println("No valid queries entered. Please try again.\n");
                        continue;
                    }

                    System.out.println("\nRunning selected queries: " + selectedQueryKeys + "\n");
                    System.out.println("-----------------------------------------\n");

                    boolean foundAll = true;
                    for (String key : selectedQueryKeys) {
                        QueryInfo queryInfo = queries.get(key);
                        if (queryInfo != null) {
                            System.out.println("Executing Query " + key + ": " + queryInfo.description() + "...");
                            queryInfo.runnable().run();
                            System.out.println("\n-----------------------------------------\n");
                            pauseExecution(scanner);
                        } else {
                            System.err.println("Warning: Query '" + key + "' not found. Skipping.");
                            foundAll = false;
                        }
                    }
                    if (!foundAll) {
                        System.out.println("Some entered queries were invalid. Please check your input.\n");
                    }
                }
            }
            scanner.close(); // Close the scanner to release resources

        }
    }
}
