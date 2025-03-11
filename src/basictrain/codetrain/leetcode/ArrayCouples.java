package basictrain.codetrain.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Array Couples

Have the function ArrayCouples (arr) take the arr parameter being passed which
will be an array of an even number of positive integers, and determine if each pair
of integers, [k, k+1], [k+2, k+3], etc. in the array has a corresponding reversed pair
somewhere else in the array.
For example: if arr is [4, 5, 1, 4, 5, 4, 4, 1]
then your program should output the string yes because the first pair 4, 5 has the reversed
pair 5, 4 in the array, and the next pair, 1, 4 has the reversed pair 4, 1 in the array as
well. But if the array doesn't contain all pairs with their reversed pairs,
then your program should output a string of the integer pairs that are incorrect,
in the order that they appear in the array.
For example: if arr is [6, 2, 2, 6, 5, 14, 14, 1] then your program should output the string
5,14,14,1 with only a comma separating the integers.
 */
public class ArrayCouples {

    public static String arrayCouples(int[] arr) {
        if (arr == null || arr.length % 2 != 0) {
            return "Invalid input"; // Or handle as needed
        }

        List<String> incorrectPairs = new ArrayList<>();
        boolean allPairsMatch = true;

        for (int i = 0; i < arr.length; i += 2) {
            int num1 = arr[i];
            int num2 = arr[i + 1];
            boolean foundMatch = false;

            for (int j = 0; j < arr.length; j += 2) {
                if (i != j && arr[j] == num2 && arr[j + 1] == num1) {
                    foundMatch = true;
                    break;
                }
            }

            if (!foundMatch) {
                allPairsMatch = false;
                incorrectPairs.add(num1 + "," + num2);
            }
        }

        if (allPairsMatch) {
            return "yes";
        } else {
            return String.join(",", incorrectPairs);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 1, 1, 2, 3, 3};
        System.out.println(arrayCouples(arr1)); // Output: 3,3

        int[] arr2 = {5, 4, 6, 7, 7, 6, 4, 5};
        System.out.println(arrayCouples(arr2)); // Output: yes

        int[] arr3 = {4, 5, 1, 4, 5, 4, 4, 1};
        System.out.println(arrayCouples(arr3)); // Output: yes

        int[] arr4 = {6, 2, 2, 6, 5, 14, 14, 1};
        System.out.println(arrayCouples(arr4)); // Output: 5,14,14,1

        int[] arr5 = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(arrayCouples(arr5)); // Output: yes
    }
}
