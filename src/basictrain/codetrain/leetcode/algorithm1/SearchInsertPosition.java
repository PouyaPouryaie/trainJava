package basictrain.codetrain.leetcode.algorithm1;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * example:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;
        int result = searchIndex(nums, target);
        System.out.printf("index " + result);
    }

    public static int searchIndex(int[] nums, int target){
        int low = 0;
        int max = nums.length - 1;
        while (low <= max){
            int mid = (max + low) / 2;
            if(target == nums[mid]){
                low = mid;
                break;
            }else{
                if(target > nums[mid]){
                    low = mid + 1;
                }else{
                    max = mid - 1;
                }
            }
        }
        return low;
    }
}
