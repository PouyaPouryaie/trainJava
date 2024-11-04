package basictrain.codetrain.javatrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExPatternsAndIntroToDatabases {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        /**
         * pattern for email
         * ^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$
         */
        //String pattern = ".+@gmail\\.com";
        //Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Pattern pattern = Pattern.compile(".+@gmail\\.com");

        List<String> sortName = new ArrayList<>();
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");
            String firstName = firstNameEmailID[0];
            String emailID = firstNameEmailID[1];
            Matcher matcher = pattern.matcher(emailID);
            if(matcher.find()){
                sortName.add(firstName);
            }
        }

        sortName.sort(String::compareTo);
        sortName.forEach(System.out::println);

        scanner.close();
    }
}
