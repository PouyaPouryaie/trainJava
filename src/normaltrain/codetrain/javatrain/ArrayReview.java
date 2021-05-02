package normaltrain.codetrain.javatrain;

import java.util.Scanner;

public class ArrayReview {

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

        ArrayReview.reverseArray(arr);

        scanner.close();
    }

    static void reverseArray(int[] storage){
        for(int i = (storage.length)-1; i >=0; i--){
            System.out.printf(String.valueOf(storage[i]) + " ");
        }
    }
}
