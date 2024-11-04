package basictrain.codetrain.javatrain;

import java.util.Scanner;

public class DataTypesRead {

    public static void main(String[] args){
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        String intResult = scan.nextLine();

        i += Integer.parseInt(intResult);

        String doubleResult = scan.nextLine();

        d += Double.parseDouble(doubleResult);

        String stringResult = scan.nextLine();

        s += stringResult;

        System.out.println(i);
        System.out.println(d);
        System.out.println(s);

        scan.close();
    }
}
