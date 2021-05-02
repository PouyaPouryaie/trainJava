package normaltrain.codetrain.javatrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * day 29
 * Given set s={1,2,3,..,n}. Find two integers,A and  B(where A < B),
 * from set S such that the value of A&B is the maximum possible and also less than a given integer, K
 * . In this case, & represents the bitwise AND operator.
 */
public class BitwiseAND {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<Integer> result = new ArrayList<>();
        for (int tItr = 0; tItr < t; tItr++) {
            int max = 0;
            String[] nk = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            for (int a = 1; a < n-1; a++) {
                for (int b = a+1; b <= n; b++) {
                    int val = a&b;
                    if (val > max && val < k)
                        max = val;
                }
            }

            result.add(max);

        }

        result.forEach(System.out::println);

        scanner.close();
    }
}
