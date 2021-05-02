package normaltrain.codetrain.javaproblem.string;

import java.util.*;

public class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        //first solution
/*        List<String> strings = new ArrayList<>();

        for(int i=0; i <= s.length()-k; i++){
            strings.add(s.substring(i, i+k));
        }

        List<String> collect = strings.stream().sorted().collect(Collectors.toList());

        smallest = collect.get(0);
        largest = collect.get(collect.size()-1);*/

        //second solution
/*        String string = "";
        for(int i = 0; i <= s.length()-k; i++){
            string = string +"," + s.substring(i, i+k);
        }

        String[] split = string.substring(1).split(",");

        for(int i = 0 ; i < split.length - 1; i++){
            for(int j = i+1; j < split.length; j++){
                if(split[i].compareTo(split[j]) > 0){
                    String temp = split[i];
                    split[i] = split[j];
                    split[j] = temp;
                }
            }
        }

        smallest = split[0];
        largest = split[split.length - 1];*/

        //third solution
        smallest = s.substring(0,k);
        largest = s.substring(0,k);

        for(int i=0; i <= s.length()-k; i++){
            String selectSubstring = s.substring(i, i + k);

            if(selectSubstring.compareTo(smallest) < 0){
                smallest = selectSubstring;
            }
            if(selectSubstring.compareTo(largest) > 0){
                largest = selectSubstring;
            }
        }

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
