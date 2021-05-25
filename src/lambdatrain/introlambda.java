package lambdatrain;

public class introlambda {

    public static void main(String[] args){

        //intro
        StringToIntMapper mapper = (String str) -> str.length();
        String name = "pouya";
        int mapValue = mapper.map(name);
        System.out.println("name is " + name + " ,length is " + mapValue);

        /**
         * use anonymous class instance of lambda expression
         *
         *  StringToIntMapper mapper = new StringToIntMapper(){
         *  @Override
         *  public int map(String str){
         *          return str.length();
         *      }
         *  }
         *
         */


        //Target Typing
        // T t = <lambda expression>;
        // Adder adder = (x,y) -> x+y;
        //the compiler treats the statement as shown:
        // Adder adder = (double x, double y) -> x + y;

        //Examples
        // Creates an Adder using a lambda expression
        Adder adder = (x, y) -> x + y;

        // Creates a Joiner using a lambda expression
        Joiner joiner = (x, y) -> x + y;

        // Adds two doubles
        double sum1 = adder.add(10.34, 89.11);

        // Adds two ints
        double sum2 = adder.add(10, 89);

        // Joins two strings
        String str = joiner.join("Hello", " lambda");

        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);
        System.out.println("str = " + str);

        //A LambdaUtil Class That Uses Functional Interfaces as an Argument in Methods
        LambdaUtils util = new LambdaUtils();

        // Call the testAdder() method
        util.testAdder((x, y) -> x + y, 200,10);

        // Call the testJoiner() method
        util.testJoiner((x, y) -> x + y);

        // Call the testJoiner() method. The Joiner will
        // add a space between the two strings
        util.testJoiner((x, y) -> x + " " + y);

        // Call the testJoiner() method. The Joiner will
        // reverse the strings and join resulting strings in
        // reverse order adding a comma in between
        util.testJoiner((x, y)->{
            StringBuilder sbx = new StringBuilder(x);
            StringBuilder sby = new StringBuilder(y);
            sby.reverse().append(",").append(sbx.reverse());
            return sby.toString();
        });


    }
}


@FunctionalInterface
interface StringToIntMapper{
    int map(String str);
}

@FunctionalInterface
interface Adder {
    double add(double n1, double n2);
}


@FunctionalInterface
interface Joiner {
    String join(String s1, String s2);
}