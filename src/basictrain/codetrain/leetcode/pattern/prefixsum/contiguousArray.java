package basictrain.codetrain.leetcode.pattern.prefixsum;

import java.util.HashMap;
import java.util.Map;

/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class contiguousArray {

    static class Solution {
        public int findMaxLength(int[] nums) {

            for(int i=0; i < nums.length; i++) {
                if(nums[i] ==0) {
                    nums[i] = -1;
                }
            }

            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int sum = 0, max = 0;
            for(int i=0; i < nums.length; i++) {
                sum += nums[i];

                if(map.containsKey(sum)) {
                    max = Math.max(max, i - map.get(sum));
                }
                else {
                    map.put(sum, i);
                }
            }

            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 1};
        Solution solution = new Solution();
        int maxLength = solution.findMaxLength(nums);
        System.out.printf("Result is: %s %n", maxLength);
    }
}
