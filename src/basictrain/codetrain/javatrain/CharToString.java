package basictrain.codetrain.javatrain;

import java.util.Arrays;
import java.util.List;

public class CharToString {

    public static void main(String[] args) {

        String str = "This is my area";

        // split to array
        String[] arraysOfStr = str.split("");
        System.out.println(Arrays.toString(arraysOfStr));

        char[] chars = str.toCharArray();
        System.out.println(chars.length);

        for (char c : chars) {
            byte b = (byte) c;
            System.out.println(c + " : " + b);
        }
        System.out.println();

        byte[] strBytes = str.getBytes();
        for (byte b : strBytes) {
            char c = (char) b;
            System.out.println(c + " : " + b);
        }
        System.out.println();

        System.out.println(Arrays.toString(chars));

        // convert array of char to string
        // 1. string builder
        StringBuilder strBuilder = new StringBuilder();
        List.of(chars).forEach(strBuilder::append);
        System.out.println(strBuilder);

        //2. string valueOf
        var strValue =  String.valueOf(chars);
        System.out.println(strValue);

        System.out.println(compareTo("booa", "book"));

    }

    public static int compareTo(String sourceOne, String sourceTwo) {
        char[] charsOne = sourceOne.toCharArray();
        char[] charsTwo = sourceTwo.toCharArray();

        int i = 0;
        while (i < charsOne.length && i < charsTwo.length) {
            if(charsOne[i] < charsTwo[i]) {
                return  1;
            } else if (charsOne[i] > charsTwo[i]) {
                return -1;
            }
            i++;
        }

        return Integer.compare(charsOne.length, charsTwo.length);
    }
}
