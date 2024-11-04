package basictrain.codetrain.javaproblem.string;

import java.util.Arrays;
import java.util.Scanner;

//He is a very very good boy, isn't he?
public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\\Z");
        String s = scan.next().trim();
        if (s.length() > 0) {
            String regex = "[ !,?._'@]+";
            String[] split = s.split(regex);
            System.out.println(split.length);
            Arrays.stream(split).forEach(System.out::println);

        } else {
            System.out.println(0);
        }
        scan.close();
    }
}
