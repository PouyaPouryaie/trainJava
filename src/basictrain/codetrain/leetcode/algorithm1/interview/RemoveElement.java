package basictrain.codetrain.leetcode.algorithm1.interview;

/*

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
    The remaining elements of nums are not important as well as the size of nums.
    Return k.

Example:
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).

 */

import java.util.Arrays;

public class RemoveElement {

    // simple solution
    public int removeElement(int[] nums, int val) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;

    }

    // my solution
    public int removeElement2(int[] nums, int val) {

        int forwardIndex = 0;
        if(nums != null && nums.length > 0){

            if(nums.length < 2) {
                if(nums[forwardIndex] != val) {
                    return forwardIndex+1;
                }
                else {
                    return forwardIndex;
                }
            }

            if(nums.length < 3) {
                if(nums[forwardIndex] != val) {
                    if(nums[forwardIndex+1] != val){
                        return forwardIndex+2;
                    }
                    else {
                        return forwardIndex+1;
                    }
                }else {
                    if(nums[forwardIndex+1] != val){
                        nums[forwardIndex] = nums[forwardIndex+1];
                        return forwardIndex+1;
                    }
                    else {
                        return forwardIndex;
                    }
                }
            }

            int backwardIndex = nums.length - 1;

            while (forwardIndex <= backwardIndex) {
                var temp = nums[forwardIndex];
                if(temp != val){
                    forwardIndex = forwardIndex + 1;
                }
                else {
                    if(nums[backwardIndex] != val){
                        nums[forwardIndex] = nums[backwardIndex];
                        nums[backwardIndex] = temp;
                        backwardIndex--;
                    }
                    else {
                        while (backwardIndex > forwardIndex && nums[backwardIndex] == val) {
                            backwardIndex--;
                        }
                        if(backwardIndex <= forwardIndex){
                            return forwardIndex++;
                        }
                        nums[forwardIndex] = nums[backwardIndex];
                        nums[backwardIndex] = temp;
                        backwardIndex--;
                    }
                    forwardIndex++;
                }

            }
        }

        return forwardIndex;
    }

    public static void main(String args[]) {
        int[] data = {0,1,2,2,3,0,4,2};
        int val = 2;
        RemoveElement re = new RemoveElement();
        int result = re.removeElement(data, val);
        System.out.printf("Result is: %s%n", result);
        Arrays.stream(data).forEach(System.out::print);
    }
}
