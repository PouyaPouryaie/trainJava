package basictrain.codetrain.leetcode.pattern.fastandslowPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FindDuplicateNumber {

    static class Solution {
        public int findDuplicateWithSort(int[] nums) {
            List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
            list.sort(Integer::compare);

            for(int i=1; i < list.size(); i++) {
                if(Objects.equals(list.get(i), list.get(i - 1))) {
                    return list.get(i);
                }
            }
            return -1;
        }

        public int findDuplicateWithFastAndSlowPointers(int[] nums) {
            int fast = nums[0], slow = nums[0];

            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (fast != slow);

            slow = nums[0];

            while (fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,4,2};
        Solution test = new Solution();
        int duplicate = test.findDuplicateWithFastAndSlowPointers(nums);
        System.out.printf("Result is: %s %n", duplicate);
    }
}
