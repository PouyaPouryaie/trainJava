package basictrain.codetrain.leetcode.pattern.prefixsum;

public class RangeSumQuery {

    static class NumArray {
        private int[] prefixSum;

        public NumArray(int[] nums) {

            for (int i = 1; i < nums.length; i++) {
                nums[i] = nums[i-1] + nums[i];
            }
            this.prefixSum = nums;
        }

        public int sumRange(int left, int right) {

            if (left == 0) {
                return prefixSum[right];
            }
            else {
                return prefixSum[right] - prefixSum[left-1];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        int test1 = numArray.sumRange(0, 2);
        System.out.printf("Result is: %s %n", test1);
        int test2 = numArray.sumRange(2, 5);
        System.out.printf("Result is: %s %n", test2);
    }
}
