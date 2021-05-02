package normaltrain.codetrain.problemsolving.ds;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ArraySimple {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        int[] reverseArray = new int[a.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < a.length; i++){
            stack.push(a[i]);
        }
        int i = 0;
        while (!stack.isEmpty()){
            reverseArray[i] = stack.pop();
            i++;
        }
        return reverseArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arrCount=scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[arrCount];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);

        for(int i = 0 ; i < res.length; i++){
            System.out.print(res[i] + " ");
        }

/*        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
