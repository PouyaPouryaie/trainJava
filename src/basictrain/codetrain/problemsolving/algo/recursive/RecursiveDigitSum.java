package basictrain.codetrain.problemsolving.algo.recursive;

import java.io.IOException;
import java.util.Scanner;

public class RecursiveDigitSum {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        
        String[] a = n.split("");
        long result = 0;
        for(int i=0; i < a.length; i++){
            result += Integer.parseInt(a[i]);
        }

        result = result * k;

        if(result > 9){
            return digitSum(Long.toString(result));
        }
        else return (int)result;
    }

    static int digitSum(String n){
        String[] a = n.split("");
        long result = 0;
        for(int i=0; i < a.length; i++){
            result += Integer.parseInt(a[i]);
        }

        if(result > 9){
            return digitSum(Long.toString(result));
        }
        else return (int)result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        System.out.println(result);

        scanner.close();
    }
}
