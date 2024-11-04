package basictrain.codetrain.javatrain;

import java.io.IOException;
import java.util.Scanner;

public class RecursionThree {

    // Complete the factorial function below.
    static int factorial(int n) {

/*        if(n==1){
            return 1;
        }
        else{
            return n * factorial(n-1);
        }*/
        return factorialTail(n, n);
    }

    static int factorialTail(int n, int r){

        System.out.println(n + " " + r);
        if(r == 1){
            return n;
        }
        else{
            return factorialTail(n * (r - 1), r-1);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
/*        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");*/

        int result = factorial(5);

        System.out.println(result);

/*        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}
