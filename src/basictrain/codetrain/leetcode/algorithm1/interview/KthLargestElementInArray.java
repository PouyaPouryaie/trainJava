package basictrain.codetrain.leetcode.algorithm1.interview;

import java.util.PriorityQueue;

/* Top ‘K’ Elements - heap Pattern
Kth Largest Element in an Array
The Top ‘K’ Elements pattern finds the top k largest or smallest elements in an array or stream of data using heaps or sorting.

Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Explanation
1. Use a min-heap of size k to keep track of the k largest elements.
2. Iterate through the array, adding elements to the heap.
3. If the heap size exceeds k, remove the smallest element from the heap.
4. The root of the heap will be the k-th largest element.

example:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Resource
https://leetcode.com/problems/kth-largest-element-in-an-array/solutions/3906260/100-3-approaches-video-heap-quickselect-sorting
 */

public class KthLargestElementInArray {

    public static void main(String[] args) {
        var nums1 = new int[]{3,2,3,1,2,4,5,5,6};
        var k = 4;
        int result = findKthLargest(nums1, k);
        System.out.println("kth largest: " + result);
    }

    // define max-heap with priority Queue
    public static int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>((Integer v1, Integer v2) -> - Integer.compare(v1, v2));
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int i =0 ; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(maxHeap.peek() != null && maxHeap.peek() < nums[i]){
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        return maxHeap.peek();
    }
}
