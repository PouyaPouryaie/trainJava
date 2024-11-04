package basictrain.codetrain.javatrain;

import java.util.Scanner;

public class Scope {

    static class Difference {
        private int[] elements;
        public int maximumDifference;

        // Add your code here
        Difference(int[] elements){
            this.elements = elements.clone();
        }

        void computeDifference(){
            sortElements();
            maximumDifference = Math.abs(elements[0] - elements[(elements.length)-1]);
        }

        void sortElements(){
            for(int i=0; i < (elements.length - 1); i++){
                for(int j=i+1;j < elements.length; j++){
                    int temp;
                    if(elements[i] < elements[j]){
                        temp = elements[i];
                        elements[i] = elements[j];
                        elements[j] = temp;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
