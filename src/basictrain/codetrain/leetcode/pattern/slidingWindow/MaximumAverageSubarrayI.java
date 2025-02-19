package basictrain.codetrain.leetcode.pattern.slidingWindow;

/*
 >>> Sliding Window pattern
     The Sliding Window pattern is used to find a subarray or substring that satisfies a specific condition,
     optimizing the time complexity by maintaining a window of elements.
     Use this pattern when dealing with problems involving contiguous subarray or substring.


You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
Any answer with a calculation error less than 10-5 will be accepted.

Example:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */


public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        int index = 0;
        double max = Double.NEGATIVE_INFINITY;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i >= k - 1) {
                double avg = (double) sum / k;
                max = Math.max(max, avg);
                sum -= nums[index];
                index++;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[] data = {1, 12, -5, -6, 50, 3};
        MaximumAverageSubarrayI obj = new MaximumAverageSubarrayI();
        double result = obj.findMaxAverage(data, 4);
        System.out.printf("Result is: %s", result);
    }
}
