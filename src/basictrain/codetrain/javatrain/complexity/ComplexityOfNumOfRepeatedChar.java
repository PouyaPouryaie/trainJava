package basictrain.codetrain.javatrain.complexity;

import java.util.HashMap;

public class ComplexityOfNumOfRepeatedChar {

    static int[] findNumOfRepetitionV1(String s, char[] c){

        int[] sums = new int[c.length];
        for(int i=0; i < s.length(); i++){
            for(int j = 0; j < c.length; j++){
                if(s.charAt(i) == c[j]){
                    sums[j] += 1;
                }
            }
        }

        return sums;
    }

    static int[] findNumOfRepetitionV2(String s, char[] c){

        int[] sums = new int[c.length];
        HashMap<Character, Integer> mapCharacter = new HashMap<>();
        for(int i=0; i < s.length(); i++){
            if(!mapCharacter.containsKey(s.charAt(i))){
                mapCharacter.put(s.charAt(i), 1);
            }else{
                mapCharacter.put(s.charAt(i), mapCharacter.get(s.charAt(i)) + 1);
            }
        }

        for(int i = 0 ; i < c.length; i++){
            sums[i] = mapCharacter.getOrDefault(c[i], 0);
        }

        return sums;
    }

    public static void main(String[] args) {

        char[] charArray = {'a','b'};

        String sample = "hello my friend my name is pouya and i like to join me in next generation of people, I hope future is a better world";

        long startTime = System.currentTimeMillis();
        int[] v1 = findNumOfRepetitionV1(sample, charArray);
        long endTime = System.currentTimeMillis();
        long period = endTime - startTime;
        System.out.println("RunningTime v1 is " + period + "ms");

        startTime = System.currentTimeMillis();
        int[] v2 = findNumOfRepetitionV2(sample, charArray);
        endTime = System.currentTimeMillis();
        period = endTime - startTime;
        System.out.println("RunningTime v2 is " + period + "ms");


    }
}
