package basictrain.codetrain.javatrain;

import java.util.Scanner;

public class NestedLogic {

    public static void compareDate(String actuallyDate, String expected){

        String[] actuallyArray = actuallyDate.split(" ");
        String[] expectedArray = expected.split(" ");

        if(Integer.parseInt(expectedArray[2]) > Integer.parseInt(actuallyArray[2])) {
            System.out.println(0);
        }else if(Integer.parseInt(expectedArray[2]) < Integer.parseInt(actuallyArray[2])){
            System.out.println(10000);
        }else {
            if(Integer.parseInt(expectedArray[1]) > Integer.parseInt(actuallyArray[1])) {
                System.out.println(0);
            }else if(Integer.parseInt(expectedArray[1]) < Integer.parseInt(actuallyArray[1])) {
                System.out.println(500 * (Integer.parseInt(actuallyArray[1]) - Integer.parseInt(expectedArray[1])));
            }else {
                if (Integer.parseInt(expectedArray[0]) > Integer.parseInt(actuallyArray[0])) {
                    System.out.println(0);
                } else if (Integer.parseInt(expectedArray[0]) < Integer.parseInt(actuallyArray[0])) {
                    System.out.println(15 * (Integer.parseInt(actuallyArray[0]) - Integer.parseInt(expectedArray[0])));
                } else {
                    System.out.println(0);
                }
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        String firstString =sc.nextLine();
        String secondString = sc.nextLine();

        compareDate(firstString, secondString);

        sc.close();
    }
}
