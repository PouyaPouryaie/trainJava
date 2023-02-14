package normaltrain.codetrain.leetcode.algorithm1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {


        int[] numbers = new int[]{5,7,2,1,8};

        Arrays.sort(numbers);

        System.out.println(numbers[numbers.length-2]);
    }
}
