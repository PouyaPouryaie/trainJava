package normaltrain.codetrain.leetcode.algorithm1;

import java.util.Arrays;

/**
 * 344. Reverse String
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] arrays = new char[]{'h','e','l','l','o'};
        reverseString(arrays);
        System.out.println(Arrays.toString(arrays));
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while (start < end){
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            start++;
            end--;
        }
    }
}
