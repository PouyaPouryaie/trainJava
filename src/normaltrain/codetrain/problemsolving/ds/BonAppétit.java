package normaltrain.codetrain.problemsolving.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Anna and Brian are sharing a meal at a resturant and they agree to split the bill equally.
 Brian wants to order something that Anna is allergic to though,
  and they agree that Anna won't pay for that item. Brian gets the check and calculates Anna's portion.
   You must determine if his calculation is correct.
 */
public class BonAppétit {

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {

        int sumShare = 0;
        for(int i : bill){
            sumShare += i;
        }

        sumShare -= bill.get(k);

        sumShare = sumShare / 2;

        if(b - sumShare != 0)
            System.out.println(b - sumShare);
        else
            System.out.println("Bon Appetit");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
