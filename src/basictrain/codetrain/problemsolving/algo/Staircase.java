package basictrain.codetrain.problemsolving.algo;

import java.util.Scanner;

public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {
        for(int i = 0 ; i < n; i++){
            StringBuilder result = new StringBuilder();
            String hash = "#";
            String space = " ";
            for(int j = i; j < n-1; j++){
                result.append(space);
            }
            for(int j = n - ((n-1) - i); j > 0; j--){
                result.append(hash);
            }
            System.out.printf(result + "\n");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
