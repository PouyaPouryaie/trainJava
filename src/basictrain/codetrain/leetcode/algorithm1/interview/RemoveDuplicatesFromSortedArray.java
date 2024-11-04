package basictrain.codetrain.leetcode.algorithm1.interview;

import java.util.Arrays;
/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
     The remaining elements of nums are not important as well as the size of nums.
    Return k.
Example:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

 */


public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int index = 0;

        for (int i = 1 ; i < nums.length; i++) {
            if(nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

    // my solution
    public int removeDuplicates2(int[] nums) {
        int index = 1;
        int value = nums[0];


        for (int i = 1 ; i < nums.length; i++) {
            if(nums[i] != value) {
                value = nums[i];
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    public static void main(String args[]) {
        int[] data = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray re = new RemoveDuplicatesFromSortedArray();
        int result = re.removeDuplicates(data);
        System.out.printf("Result is: %s%n", result);
        Arrays.stream(data).forEach(System.out::print);
    }
}
