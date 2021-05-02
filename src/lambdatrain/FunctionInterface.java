package lambdatrain;

import java.util.function.BiFunction;

public class FunctionInterface {

    //sample 1
    interface integerMath{
        int operation(int a, int b);

        default integerMath swap(){
            return (a,b) -> operation(b,a);
        }
    }

    private static int apply(int a, int b, integerMath op){
        return op.operation(a,b);
    }
    //end sample

    //sample 2 static method reference
    interface Sayable{
        void say(String s);
    }

    public static void saySomthing(String s){
        System.out.println("hello " + s);
    }
    //end sample


    //sample 3 static method reference
    static int add(int a, int b){
        return a + b;
    }

    static float add(float a, float b){
        return a + b;
    }
    //end sample


    //sample 4 instance method reference
    void saySometingInstance(String s){
        System.out.println(" my firend instance is " + s);
    }
    //end sample

    public static void main(String[] args){

        //1
        integerMath addition = (a,b) -> a + b;
        integerMath subtraction = (a,b) -> a - b;
        System.out.println(" 40 + 2 = " + apply(40,2, addition));
        System.out.println(" 10 - 5 = " + apply(10, 5, subtraction));
        System.out.println(" 10 - 20 = " + apply(20, 10, subtraction.swap()));

        //2
        Sayable sayable = FunctionInterface::saySomthing;
        sayable.say("pouya");

        //3
        BiFunction<Integer, Integer, Integer> add1 = FunctionInterface::add;
        BiFunction<Float, Float, Float> add2 = FunctionInterface::add;
        System.out.println("integer add is " + add1.apply(10,20));
        System.out.println("float add is " + add2.apply(2.2f, 4.2f));

        //4
        Sayable sayableInstance = new FunctionInterface()::saySometingInstance;
        sayableInstance.say("hossein");
    }
}
