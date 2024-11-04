package basictrain.codetrain.javaproblem.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Two strings, a and b, are called anagrams if they contain all the same characters in the same frequencies.
 * For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.
 */
public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        // Complete the function

        //second solution
        if(a.length() != b.length()){
            return false;
        }

        char[] aArray = a.toLowerCase().toCharArray();
        char[] bArray = b.toLowerCase().toCharArray();

        Arrays.sort(aArray);
        Arrays.sort(bArray);

        if(String.valueOf(aArray).equals(String.valueOf(bArray))){
            return true;
        }
        else{
            return false;
        }

        //first solution
        /*a = a.toLowerCase();
        b = b.toLowerCase();

        boolean isNotEnd = true;
        boolean isAnagram = false;
        if(a.length() == b.length()){
            String aIndex = "";
            String aRemain = "";

            while (isNotEnd){
                aIndex = a.substring(0,1);
                if(a.length() > 1){
                    aRemain = a.substring(1);
                }
                else{
                    isNotEnd = false;
                }


                if(b.contains(aIndex)){
                    a = aRemain;
                    isAnagram = true;
                    for(int i=0; i< b.length(); i++){
                        if(b.charAt(i) == aIndex.charAt(0)){
                            b = b.substring(0,i) + b.substring(i+1);
                            break;
                        }
                    }
                }
                else{
                    isAnagram = false;
                    isNotEnd = false;
                }

            }

            if(b.length()!=0)
                isAnagram = false;


            return isAnagram;
        }else{
            return false;
        }*/
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
