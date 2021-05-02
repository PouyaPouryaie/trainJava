package normaltrain.codetrain.problemsolving.algo;

import java.util.Scanner;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        /*List<Long> intList = new ArrayList<>();
        for(int i =0; i < arr.length; i++){
            intList.add((long) arr[i]);
        }
        intList.sort(Long::compareTo);
        int maxResult = 0;
        int minResult = 0;
        for(int i=0; i < 4; i++){
            minResult += intList.get(i);
            maxResult += intList.get(i+1);
        }

        System.out.println(minResult + " " + maxResult);*/

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long minResult = 0;
        long maxResult = 0;

        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }


        if(min == max){
            for(int i = 0; i < arr.length -1; i++) {
                maxResult += arr[i];
                minResult += arr[i];
            }
        }
        else{
            for(int i = 0; i < arr.length; i++) {
                if (arr[i] != min) {
                    maxResult += arr[i];
                }
                if (arr[i] != max) {
                    minResult += arr[i];
                }
            }
        }

        System.out.println(minResult + " " + maxResult);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
