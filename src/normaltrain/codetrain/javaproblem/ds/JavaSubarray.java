package normaltrain.codetrain.javaproblem.ds;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaSubarray {

    public static void countSubArray(int[] arr){


        /**
         * Subarray: Count number of negative subArrays.
         */
        // first solution
        int count = 0;
        for(int i = 0 ; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                int sumArray = 0;
                for(int k = i; k <= j; k++){
                    sumArray += arr[k];
                }
                if(sumArray < 0){
                    count++;
                }
            }
        }

        System.out.println(count);

        //second solution
        int size = arr.length;
        int[][] arrM = new int[size][size];
        int countNegative = 0;
        for(int i=0;i<size;i++){
            if(arr[i] < 0) countNegative++;
            arrM[i][i] = arr[i];
            for(int j=0;j<i;j++){
                arrM[j][i] = arrM[j][i-1]+arr[i];
                if(arrM[j][i] < 0) countNegative++;
            }
        }
        System.out.println(countNegative);


        /**
         * Subsequence Array
         * A subsequence is a sequence that can be derived from another sequence by zero or more elements,
         * without changing the order of the remaining elements. For the same example, there are 15 sub-sequences.
         * They are (1), (2), (3), (4), (1,2), (1,3),(1,4), (2,3), (2,4), (3,4), (1,2,3), (1,2,4), (1,3,4), (2,3,4), (1,2,3,4).
         * More generally, we can say that for a sequence of size n, we can have (2n-1) non-empty sub-sequences in total
         */
        int optimum = (int)Math.pow(2, arr.length);

        for(int counter = 1; counter < optimum; counter++){
            for(int j = 0 ; j < arr.length; j++){
                if(BigInteger.valueOf(counter).testBit(j)){
                    System.out.printf(arr[j]+ " ");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for(int i = 0 ; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        countSubArray(arr);
    }
}
