package normaltrain.codetrain.javaproblem.ds;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sometimes it's better to use dynamic size arrays.
 * Java's ArrayList can provide you this feature.
 */
public class JavaArrayList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList[] arrayList = new ArrayList[n];
        int d,q,x,y;
        for(int i = 0; i< n; i++){
            d = scanner.nextInt();
            arrayList[i] = new ArrayList();
            for(int j = 0 ; j < d; j++){
                arrayList[i].add(scanner.nextInt());
            }
        }
        q=scanner.nextInt();
        for(int i=0;i<q;i++){
            x=scanner.nextInt();
            y=scanner.nextInt();
            try{
                System.out.println(arrayList[x-1].get(y-1));
            } catch(Exception e){
                System.out.println("ERROR!");
            }
        }
    }
}
