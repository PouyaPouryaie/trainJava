package normaltrain.codetrain.javaproblem.oop;

import java.util.Scanner;
import java.util.stream.IntStream;

public class JavaInterface {

    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
        sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}

interface AdvancedArithmetic{
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic{
    @Override
    public int divisor_sum(int n) {

        if(n == 1){
            return 1;
        }else{
            IntStream range = IntStream.range(2, (n / 2)+1);
            int sum = range.filter(s -> n % s == 0).sum();
            sum = sum + n + 1;
            System.out.println(String.format("result is %s ", sum));
            return sum;
        }

/*
        boolean continues = true;
        int i = 2;
        int res = 0;
        if(n == 1){
            return 1;
        }
        while (continues){
            if(n % i == 0){
                res += i;
            }
            if(n / 2 <= i){
                continues = false;
            }
            i++;
        }
        res = res + 1 + n;
        return res;*/
    }
}
