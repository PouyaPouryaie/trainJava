package basictrain.codetrain.leetcode.pattern;

public class TempTest {

    public static int secondSolution(String s) {

        if (s == null || s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        int max = 0;
        int length = 0;
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if(!result.contains(String.valueOf(chars[i]))){
                result += String.valueOf(chars[i]);
            } else {
                while (result.contains(String.valueOf(chars[i]))){
                    result = result.substring(1);
                    length--;
                }
                result += String.valueOf(chars[i]);
            }
            length++;
            max = Math.max(max, length);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcad";
        int i = secondSolution(s);
        System.out.println(i);
    }
}
