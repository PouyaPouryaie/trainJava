package basictrain.codetrain.leetcode.algorithm1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Sliding Window
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcad";
        int i = secondSolution(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int max = 0;
        if (s.equals("")) {
            return 0;
        }
        Map<String, String> memory = new HashMap<>();
        String[] split = s.split("");
        int start = 0;
        int round = 0;
        boolean breakDown = false;
        while (round != split.length - 1) {
            for (int index = start; index < split.length - 1; index++) {
                if (memory.get(split[index]) != null) {
                    memory.clear();
                    if (max < i) {
                        max = i;
                    }
                    i = 0;
                    start++;
                    break;
                } else if (memory.get(split[index + 1]) != null) {
                    memory.clear();
                    i++;
                    if (max < i) {
                        max = i;
                    }
                    i = 0;
                    start++;
                    break;
                } else {
                    memory.put(split[index], split[index]);
                    i++;
                    if (max < i) {
                        max = i;
                    }
                    if (index + 1 == split.length - 1) {
                        breakDown = true;
                    }
                }
            }
            if (breakDown) {
                break;
            }
            round++;
        }
        if (memory.get(split[split.length - 1]) == null) {
            i++;
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public static int secondSolution(String s) {
        int longest = 0;
        if (s == null || s.length() == 0) {
            return longest;
        }

        Set<Character> unique = new HashSet<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (unique.contains(c)) {
                while (left < i) {
                    char lc = s.charAt(left);
                    unique.remove(lc);
                    left++;
                    if (lc == c) break;
                }
            }

            unique.add(c);
            longest = Math.max(longest, unique.size());
        }

        return longest;
    }
}
