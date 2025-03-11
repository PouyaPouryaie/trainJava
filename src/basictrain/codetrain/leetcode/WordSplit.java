package basictrain.codetrain.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
your goal is to determine if the first element in the input can be split into two words,
 where two words exist in the dictionary that is provided in the second element of input.
   Input String[] str = {"hellocat", "apple,bat,cat,goodbye,hello,yellow,why"};
   output = hello, cat
 */
public class WordSplit {

    public static String wordSplit(String[] strArr) {
        String inputStr = strArr[0];
        String[] dictArr = strArr[1].split(",");
        Set<String> dictionary = new HashSet<>(Arrays.asList(dictArr));

        for (int i = 1; i < inputStr.length(); i++) {
            String word1 = inputStr.substring(0, i);
            String word2 = inputStr.substring(i);

            if (dictionary.contains(word1) && dictionary.contains(word2)) {
                return word1 + "," + word2;
            }
        }

        return "not possible";
    }

    public static void main(String[] args) {
        String[] strArr1 = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
        System.out.println(wordSplit(strArr1)); // Output: base,ball

        String[] strArr2 = {"abcgefd", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"};
        System.out.println(wordSplit(strArr2)); // Output: abcg,efd

        String[] strArr3 = {"hellocat", "apple,bat,cat,goodbye,hello,yellow,why"};
        System.out.println(wordSplit(strArr3)); // Output: hello,cat

        String[] strArr4 = {"programming", "program,ming,ram,pro,g,m"};
        System.out.println(wordSplit(strArr4)); // Output: program,ming

        String[] strArr5 = {"coderbyte", "code,byte,coder,by,te"};
        System.out.println(wordSplit(strArr5)); // Output: coder,byte

        String[] strArr6 = {"somethingelse", "some,thing,else,s,o,m,e"};
        System.out.println(wordSplit(strArr6)); // Output: some,thing

        String[] strArr7 = {"noproblem", "no,problem,pro,b,lem"};
        System.out.println(wordSplit(strArr7)); // Output: no,problem

        String[] strArr8 = {"impossible", "im,possible,pos,si,ble"};
        System.out.println(wordSplit(strArr8)); // Output: im,possible

        String[] strArr9 = {"notpossible", "not,possible,pos,si,ble,no"};
        System.out.println(wordSplit(strArr9)); // Output: not,possible

        String[] strArr10 = {"noanswer", "no,an,swer,a,ns"};
        System.out.println(wordSplit(strArr10)); // Output: no,answer

        String[] strArr11 = {"nothing", "not,hin,g,thi,ng"};
        System.out.println(wordSplit(strArr11)); // Output: not possible
    }
}
