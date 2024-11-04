package basictrain.codetrain.leetcode.algorithm1;

import java.util.HashMap;
import java.util.Map;

/**
 * Sliding Window
 * 567. Permutation in String
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 */
public class PermutationInString {

    public static void main(String[] args) {

    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> charsFrequency = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            charsFrequency.put(c, charsFrequency.getOrDefault(c, 0) + 1);
        }
        int counter = charsFrequency.size();
        int begin = 0;
        int end = 0;
        while (end < s2.length()) {
            char c = s2.charAt(end);
            if (charsFrequency.containsKey(c)) {
                charsFrequency.put(c, charsFrequency.get(c) - 1);
                if (charsFrequency.get(c) == 0) {
                    --counter;
                }
            }
            while (counter == 0) {
                c = s2.charAt(begin);
                if (charsFrequency.containsKey(c)) {
                    charsFrequency.put(c, charsFrequency.get(c) + 1);
                    if (charsFrequency.get(c) > 0) {
                        ++counter;
                    }
                }
                if (end + 1 - begin == s1.length()) {
                    return true;
                }
                ++begin;
            }
            ++end;
        }
        return false;
    }
}
