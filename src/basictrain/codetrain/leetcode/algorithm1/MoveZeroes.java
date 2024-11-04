package basictrain.codetrain.leetcode.algorithm1;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * example:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */

public class MoveZeroes {

    public static void main(String[] args) {
        int[] numbers = new int[]{0, 1, 0, 3 ,12};
        secondSolution(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    static void moveZeroes(int[] nums) {
        int j;
        for(j = 0; j < nums.length; j++){
            if(nums[j] == 0){
                int temp = nums[j];
                for(int i = j+1; i < nums.length; i++){
                    if(nums[i] != 0){
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
    }

    static void secondSolution(int[] nums){
        int snowBallSize = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                snowBallSize++;
            }
            else if (snowBallSize > 0) {
                int t = nums[i];
                nums[i]=0;
                nums[i-snowBallSize]=t;
            }
        }
    }
}
