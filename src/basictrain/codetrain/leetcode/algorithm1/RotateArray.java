package basictrain.codetrain.leetcode.algorithm1;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotateArray(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotateArray(int[] nums, int k){
        k %= nums.length;
        int n = nums.length;
        reverse(nums,0, n-1);
        reverse(nums,0, k-1);
        reverse(nums, k, n-1);
    }

    public static void reverse(int[] nums, int left, int right){
        int temp;
        while (left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
