package normaltrain.codetrain.javaproblem;

import java.util.Scanner;

/**
 * Static initialization blocks are executed when the class is loaded,
 * and you can initialize static variables in those blocks.
 * It's time to test your knowledge of Static initialization blocks.
 */
public class JavaStaticInitializerBlock {

    static int B,H;
    static boolean flag;

    static{
        Scanner scan = new Scanner(System.in);
        B = scan.nextInt();
        scan.nextLine();
        H = scan.nextInt();
        scan.close();
        if(B>0 && H>0){
            flag = true;
        }
        else if((B<=0 && H>=0)||(B>=0 && H<=0))
        {
            flag=false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {
            flag=false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }

    }

    public static void main(String[] args){

        if(flag){
            int area=B*H;
            System.out.print(area);
        }
    }//end of main

}
