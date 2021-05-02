package normaltrain.codetrain.javatrain;

import java.util.Scanner;

/**
 * Given a base-10 integer, n, convert it to binary (base-2).
 * Then find and print the base-10 integer denoting the maximum number of consecutive 1's
 * in n's binary representation.
 */
public class BinaryNumbers {


    static void maximumNumberOfConsecutive(int number){
        String result = Integer.toBinaryString(number);
        String[] zeroDivided = result.split("0");
        int maxConsecutive = 0;
        for(String value: zeroDivided){
            if(value.length() > maxConsecutive){
                maxConsecutive = value.length();
            }
        }
        System.out.println(maxConsecutive);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        maximumNumberOfConsecutive(n);
        scanner.close();
    }
}
