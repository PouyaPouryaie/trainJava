package normaltrain.codetrain.javatrain;

import java.util.Scanner;

/**
 * The hourglass with the maximum sum
 */
public class TwoDimentionArrays {

    static void largestHourglassFound(int[][] value){

        int windowValue;
        int result = Integer.MIN_VALUE;
        for(int i = 0 ; i < 4; i++){
            for(int j = 0; j < 4; j++){
                windowValue = 0;
                windowValue = value[i][j] + value[i][j+1] + value[i][j+2]
                        + value[i+1][j+1] + value[i+2][j] + value[i+2][j+1] + value[i+2][j+2];

                if(result < windowValue){
                    result = windowValue;
                }
            }
        }

        System.out.println(result);
    }

    /**
     * 0 -4 -6 0 -7 -6
     * -1 -2 -6 -8 -3 -1
     * -8 -4 -2 -8 -8 -6
     * -3 -1 -2 -5 -7 -4
     * -3 -5 -3 -6 -6 -6
     * -3 -6 0 -8 -6 -7
     *
     */

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        largestHourglassFound(arr);

        scanner.close();
    }
}
