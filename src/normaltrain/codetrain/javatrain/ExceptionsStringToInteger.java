package normaltrain.codetrain.javatrain;

import java.util.Scanner;

public class ExceptionsStringToInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();

        try{
            System.out.println(Integer.parseInt(S));
        }catch (Exception e){
            System.out.println("Bad String");
        }
    }
}
