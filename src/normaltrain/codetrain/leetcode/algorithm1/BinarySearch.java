package normaltrain.codetrain.leetcode.algorithm1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Binary Search Algorithm: The basic steps to perform Binary Search are:
 *
 *     Begin with the mid element of the whole array as a search key.
 *     If the value of the search key is equal to the item then return an index of the search key.
 *     Or if the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half.
 *     Otherwise, narrow it to the upper half.
 *     Repeatedly check from the second point until the value is found or the interval is empty.
 */
public class BinarySearch {
    public static void main(String[] args) {
//        int[] numbers = new int[]{-1,0,3,5,9,12};
        int[] numbers = new int[]{5};
        int target = 5;
        int result = foundNumber(numbers, target);
        System.out.printf("result is " + result);
    }

    public static int foundNumber(int[] numbers, int target) {
        int lowNumber = 0;
        int maxNumber = numbers.length - 1;
        int result = -1;
        while (lowNumber <= maxNumber) {
            int min = (lowNumber + maxNumber) / 2;

            if (numbers[min] == target) {
                result = min;
                break;
            } else {
                if(numbers[min] < target){
                    lowNumber = min + 1;
                }else{
                    maxNumber = min - 1;
                }
            }
        }
        return result;
    }
}