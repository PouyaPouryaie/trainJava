package normaltrain;

import java.util.Random;

public class NationalCodeGenerate {

    public static void main(String[] args) {

        Long sampleNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        char[] chars = sampleNumber.toString().trim().toCharArray();
        int[] ints = new int[10];
        int index = 0;
        for (char c: chars){
            int i = Integer.parseInt(String.valueOf(c));
            ints[index] = i;
            index++;
        }
        int sum = 0;
        for(int i: ints){
            sum += i * index;
            index--;
        }
        int result  = 0 ;
        int s = sum % 11;
        if(s < 2){
            result = s;
        }
        else {
            result = 11 - s;
        }

        StringBuffer buffer = new StringBuffer(sampleNumber.toString());
        StringBuffer sampleNationalCode = buffer.replace(9,10, String.valueOf(result));
        System.out.println(sampleNationalCode);
    }
}
