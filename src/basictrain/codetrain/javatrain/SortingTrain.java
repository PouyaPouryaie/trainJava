package basictrain.codetrain.javatrain;

import java.util.Scanner;

public class SortingTrain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // Write Your Code Here -- bubbleSort
        int numSwaps = 0;
        for(int i=0; i < a.length - 1; i++){
            for(int j = i+1; j <= a.length - 1; j++){
                if(a[i] > a[j]){
                    numSwaps++;
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        System.out.println("Array is sorted in " + numSwaps +" swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);

    }
}
