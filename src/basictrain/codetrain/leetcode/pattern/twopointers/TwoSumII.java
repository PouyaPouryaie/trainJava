package basictrain.codetrain.leetcode.pattern.twopointers;

import java.util.Arrays;

/*
  >>> Two Pointers pattern
  The Two Pointers pattern involves using two pointers to iterate through an array or list, often used to find pairs
  or elements that meet specific criteria. Use this pattern when dealing with sorted arrays or lists where you need
  to find pairs that satisfy a specific condition.

    Initialize two pointers, one at the start (left) and one at the end (right) of the array.
    Check the sum of the elements at the two pointers.
    If the sum equals the target, return the indices.
    If the sum is less than the target, move the left pointer to the right.
    If the sum is greater than the target, move the right pointer to the left.


  Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
  find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and
  numbers[index2] where 1 <= index1 < index2 <= numbers.length.
  Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
  The tests are generated such that there is exactly one solution. You may not use the same element twice.
  Your solution must use only constant extra space.

  example:
  Input: numbers = [2,7,11,15], target = 9
  Output: [1,2]
  Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 */
public class TwoSumII {
    public static void main(String[] args) {
        var numbers = new int[]{2, 7, 12, 14};
        var target = 9;
        int[] ints = secondSolution(numbers, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int first = 0, second = 0;
        int[] num = new int[2];
        boolean find = false;
        for (int i = 0; i < numbers.length; i++) {
            first = numbers[i];
            if (first > target) {
                break;
            }
            for (int j = i + 1; j < numbers.length; j++) {
                second = numbers[j];
                if (first + second == target) {
                    num[0] = i + 1;
                    num[1] = j + 1;
                    find = true;
                    break;
                } else if (first + second > target) {
                    break;
                }
            }
            if (find || first > target) {
                break;
            }
        }
        return num;
    }

    public static int[] secondSolution(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int sum = 0;
        while (start < end) {
            sum = numbers[start] + numbers[end];
            if (sum == target) return new int[]{start + 1, end + 1};
            if(sum < target){
                start++;
            }else{
                end--;
            }
        }
        return new int[]{0, 0};
    }
}
