package basictrain.codetrain.leetcode.algorithm1.interview;

/*
Monotonic Stack Pattern
The Monotonic Stack pattern uses a stack to maintain a sequence of elements in a specific order (increasing or decreasing).
Use this pattern for problems that require finding the next greater or smaller element.
Resource:
https://www.youtube.com/watch?v=Dq_ObZwTY_Q
https://medium.com/@keshavrathinavel/leetcodes-monotonic-stack-problems-and-how-to-solve-them-made-easy-1c73c2d6d437


The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine
the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
Return an array of length nums1.length such that ans[i] is the next greater element as described above.

Example
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    public static void main(String[] args) {
        var nums1 = new int[]{4,1,2};
        var nums2 = new int[]{1,3,4,2};
        int[] ints = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    // Monotonic Stack Solution
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = nums2.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                map.put(nums2[i], -1);
            }
            else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for(int i = nums1.length - 1; i >= 0; i--) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public static int[] nextGreaterElementOne(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        for(int i = 0 ; i < nums1.length; i++) {
            int index=nums1[i];
            boolean findIndex = false;

            for(int j = 0; j < nums2.length; j++) {

                if(findIndex) {
                    int temp = nums2[j];

                    if(temp > index) {
                        result[i] = temp;
                        break;
                    }else {
                        if(j == nums2.length - 1){
                            result[i] = -1;
                            break;
                        }
                    }
                }

                if(!findIndex && nums2[j] == index) {

                    if(j == nums2.length - 1) {
                        result[i] = -1;
                        break;
                    }

                    findIndex = true;
                    continue;
                }
            }
        }

        return result;
    }
}
