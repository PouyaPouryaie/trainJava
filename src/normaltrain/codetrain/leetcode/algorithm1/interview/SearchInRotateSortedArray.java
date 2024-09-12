package normaltrain.codetrain.leetcode.algorithm1.interview;

/* Modified Binary Search
The Modified Binary Search pattern adapts binary search to solve a wider range of problems, such as finding elements in rotated sorted arrays.
Use this pattern for problems involving sorted or rotated arrays where you need to find a specific element.
You must write an algorithm with O(log n) runtime complexity.

There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
or -1 if it is not in nums.

Explanation
1. Perform binary search with an additional check to determine which half of the array is sorted.
2. We then check if the target is within the range of the sorted half.
3. If it is, we search that half; otherwise, we search the other half.

Example
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

 */
public class SearchInRotateSortedArray {

    public static void main(String[] args) {
//        var nums1 = new int[]{4,5,6,7,0,1,2};
        var nums1 = new int[]{3, 5, 1};
        var target = 1;
        int result = search(nums1, target);
        System.out.println("result: " + result);
    }

    public static int search(int[] nums, int target) {

        int low = 0; int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target &&  target < nums[mid] ) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[high] ) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
