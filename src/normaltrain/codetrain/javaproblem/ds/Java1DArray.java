package normaltrain.codetrain.javaproblem.ds;

import java.util.Scanner;

public class Java1DArray {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }

        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
