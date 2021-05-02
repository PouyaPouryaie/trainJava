package normaltrain.codetrain.javatrain;

import java.util.Scanner;

/**
 * print its even-indexed and odd-indexed characters as 2 space-separated strings on a single line
 */
public class LetsReview {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfWord = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for(int i = 0; i < numberOfWord; i++){
            String value = scanner.nextLine();
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();
            char[] arrOfValue = value.toCharArray();
            for(int j = 0;j < arrOfValue.length; j++){
                if(j % 2 == 0){
                    even.append(arrOfValue[j]);
                }
                else{
                    odd.append(arrOfValue[j]);
                }
            }
            System.out.println(even + " " + odd);
        }

        scanner.close();
    }

}
