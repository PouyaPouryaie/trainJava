package basictrain.codetrain.javaproblem.string;

import java.util.Scanner;

public class JavaStringsIntroduction {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        A = A.toLowerCase();
        B = B.toLowerCase();

        System.out.println(A.length() + B.length());


        //first solution for lexicographically (Dictionary)
/*        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();

        boolean isAbig = false;
        int shortWorld = 0;

        if(aChars.length < bChars.length){
            shortWorld = aChars.length;
            for(int i=0; i < shortWorld; i++){
                if(aChars[i] == bChars[i]){
                    continue;
                }
                else if(aChars[i] > bChars[i]){
                    isAbig = true;
                    break;
                }
                else if(aChars[i] < bChars[i]){
                    isAbig = false;
                    break;
                }
            }
        }
        else{
            shortWorld = bChars.length;
            for(int i=0; i < shortWorld; i++){
                if(bChars[i] == aChars[i]){
                    continue;
                }
                else if(bChars[i] > aChars[i]){
                    isAbig = false;
                    break;
                }
                else if(bChars[i] < aChars[i]){
                    isAbig = true;
                    break;
                }
            }
        }

        if(isAbig)
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.println(A.replace(A.charAt(0), A.toUpperCase().charAt(0)) + " "
                + B.replace(B.charAt(0), B.toUpperCase().charAt(0)));
            */

        //second solution for lexicographically (Dictionary)
        System.out.println(A.compareTo(B)> 0 ? "Yes" : "No");

        System.out.println(A.substring(0,1).toUpperCase() + A.substring(1) + " "
                + B.substring(0,1).toUpperCase() + B.substring(1));


        sc.close();
    }
}
