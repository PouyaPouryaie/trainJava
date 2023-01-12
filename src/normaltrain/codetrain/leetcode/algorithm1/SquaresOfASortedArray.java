package normaltrain.codetrain.leetcode.algorithm1;

import normaltrain.interfacetrain.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-7,-3,2,3,11};
        int[] ints = sortedSquares2(nums);
        System.out.println(Arrays.toString(ints));
    }

    //O(n) = n*log(n)
    public static int[] sortedSquares(int[] nums){
        int[] values = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            values[i] = (int) Math.pow(nums[i],2);
        }
        Arrays.sort(values);
        return values;
    }

    //O(n) = n -> use two pointer for check and sort
    public static int[] sortedSquares2(int[] nums){
        int index = nums.length-1;
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;

        while (left <= right){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
                result[index--] = nums[right] * nums[right];
                right--;
            }else{
                result[index--] = nums[left] * nums[left];
                left++;
            }
        }

        return result;
    }
}
