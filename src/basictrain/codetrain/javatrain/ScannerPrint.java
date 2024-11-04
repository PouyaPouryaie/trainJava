package basictrain.codetrain.javatrain;

import java.util.Scanner;

public class ScannerPrint {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        scanner.close();

        System.out.println("hello " + inputString);
    }
}
