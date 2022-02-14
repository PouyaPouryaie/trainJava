package normaltrain.codetrain.javaproblem.string;

import java.util.Scanner;
import java.util.regex.*;

/**
 * sample:
 * 3
 * ([A-Z])(.+)
 * [AZ[a-z](a-z)
 * batcatpat(nat
 */
public class JavaRegex {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            try {
                if(pattern.length()>0){
                    Pattern compile = Pattern.compile(pattern);
                    System.out.println("Valid");
                }
                else{
                    System.out.println("Invalid");
                }
            }catch (PatternSyntaxException e){
                System.out.println("Invalid");
            }
            testCases--;
        }
    }
}
