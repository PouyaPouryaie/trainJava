package normaltrain.codetrain.leetcode.algorithm1;

import java.util.Arrays;

/**
 * 557. Reverse Words in a String III
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInStringIII {

    public static void main(String[] args) {
        String w = "Let's take LeetCode contest";
        String reverse = reverseWords(w);
        System.out.println(reverse);
    }

    public static String reverseWords(String s)
    {
        String[] words = s.split(" ");
        for(int i=0;i<words.length;i++)
        {
            words[i]=reverseString(words[i]);
        }
        String reversedString = String.join(" ",words);
        System.gc();
        return reversedString;
    }

    public static String reverseString(String str)
    {
        char[] s = str.toCharArray();
        int i=0;
        int j=s.length-1;
        char temp;
        while(i<j)
        {
            temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
        String string = new String(s);
        return string;
    }
}
