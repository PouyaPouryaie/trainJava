package normaltrain.codetrain.problemsolving.algo.recursive;

import java.io.IOException;
import java.util.Scanner;

/**
ex : X=13, N=2 -> result=1 (3^2 + 2^2 = 13)
X=100, N=2 -> result=3 (10^2 = 6^2 + 8^2 = 1^2 + 3^2 + 4^2 + 5^2 + 7^2 = 100)
 **/
public class ThePowerSum {

    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
        int index = 1;

        return sumProcess(X,N, index);
    }

    static int sumProcess(int X, int N, int index){

        if(Math.pow(index, N) == X){
            return 1;
        }
        else if(Math.pow(index, N) < X){
            return sumProcess(X, N, index+1)
                    + sumProcess(X - (int)Math.pow(index,N), N, index+1);
        }
        else {
            return 0;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        System.out.println(result);

        scanner.close();
    }
}
