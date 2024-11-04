package basictrain.codetrain.javatrain.complexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunningTimeAndComplexityPrimeNumber
 {

    public static void isPrime(int number){

        List<Integer> rangeNumber = Stream.iterate(2, i -> i+1).limit(number/2).collect(Collectors.toList());

        boolean result = number == 1 ||
                (number != 2 && number != 3
                        && rangeNumber.stream().anyMatch(n -> number % n == 0));

        if(!result){
            System.out.println("Prime");
        }
        else {
            System.out.println("Not prime");
        }

/*      boolean isPrime = true;
        if(number == 1){
            isPrime = false;
        }
        else if(number == 2 || number == 3){
            isPrime = true;
        }
        else{
            for(int i=2;i <= number/2;i++){
                if(number % i == 0){
                    isPrime = false;
                    break;
                }
                else{
                    isPrime = true;
                }
            }
        }

        if(isPrime){
            System.out.println("Prime");
        }
        else {
            System.out.println("Not prime");
        }*/
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        List<Integer> numberList = new ArrayList<>();
        while(T-->0){
            int number=sc.nextInt();
            numberList.add(number);
        }

        numberList.forEach(RunningTimeAndComplexityPrimeNumber::isPrime);

        sc.close();
    }
}
