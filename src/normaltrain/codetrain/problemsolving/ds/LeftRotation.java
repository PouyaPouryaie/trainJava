package normaltrain.codetrain.problemsolving.ds;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class LeftRotation {

    /**
     * first create queue
     * then get dRotate number from numbersArray and add to queue
     * left number remind in numbersArray transfer to new Array from 0 index
     * then read and pull number from queue and added to new Array
     * @param numbers
     * @param dRotate
     */
    static void leftRotationWithDTime(int[] numbers, int dRotate){

        Queue<Integer> q = new ArrayDeque<>();
        int i = 0;
        int j = dRotate;
        while (j-->0){
            q.add(numbers[i]);
            i++;
        }
        int[] rotateArray = new int[numbers.length];
        int index = 0;
        for(int k = dRotate; k < rotateArray.length; k++){
            rotateArray[k - dRotate] = numbers[k];
            index++;
        }
        while (!q.isEmpty()){
            rotateArray[index] = q.remove();
            index++;
        }

        for(int k = 0; k < rotateArray.length; k++){
            System.out.print(rotateArray[k] + " ");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        leftRotationWithDTime(a, d);

        scanner.close();
    }
}
