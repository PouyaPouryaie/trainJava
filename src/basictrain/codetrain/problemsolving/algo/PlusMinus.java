package basictrain.codetrain.problemsolving.algo;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * how use decimal format for show in UI
 */
public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        String pattern = "0.######";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        int size = arr.length;
        double[] plusCount = new double[]{0.0,0.0,0.0};
        for(int i = 0; i < size; i++){
            if(arr[i] > 0){
                plusCount[0] += 1;
            }else if(arr[i] < 0){
                plusCount[2] += 1;
            }else{
                plusCount[1] += 1;
            }
        }

        System.out.println(decimalFormat.format(plusCount[0] / size));
        System.out.println(decimalFormat.format(plusCount[2] / size));
        System.out.println(decimalFormat.format(plusCount[1] / size));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
