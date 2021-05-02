package normaltrain.codetrain.javaproblem;

import java.util.Scanner;

public class javaOutputFormatting {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            //Complete this line
            int stringLength =  s1.length();
            System.out.printf(s1);
            for(int j = 0; j < 15 - stringLength; j++){
                System.out.printf(" ");
            }
            if(x >= 100){
                System.out.printf(String.valueOf(x));
            }
            else if(x < 10){
                System.out.printf("00" + x);
            }
            else {
                System.out.printf("0" + x);
            }
            System.out.println();
        }
        System.out.println("================================");

    }
}
