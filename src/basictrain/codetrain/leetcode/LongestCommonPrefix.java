package basictrain.codetrain.leetcode;

import java.util.*;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] data = s.split(",");
        Arrays.asList(data).sort(Comparator.comparingInt(String::length));
        String candidateValue = data[0];
        StringBuilder prepairedRsult = new StringBuilder("");
        for (int i = 0; i < candidateValue.length(); i++) {
            boolean failed = false;
            for (int j = 1; j < data.length; j++) {
                if (data[j].charAt(i) != candidateValue.charAt(i)) {
                    failed = true;
                    break;
                }
            }
            if (!failed) {
                prepairedRsult.append(candidateValue.charAt(i));
            } else {
                break;
            }
        }
        System.out.println(prepairedRsult);
    }
}
