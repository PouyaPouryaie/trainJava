package normaltrain.codetrain.javaproblem.string;

import java.util.Scanner;

/**
 * find palindrome string
 */
public class JavaStringReverse {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        //first solution
        int n = A.length();
        for (int i = 0; i < n / 2; i++) {
            if (A.charAt(i) != A.charAt(n-i-1)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        return;

        //second solution
        /*boolean isSame = false;
        if(A.length()%2==1){
            if(A.length()==1){
                System.out.println("Yes");
                return;
            }
            int middle = (A.length()-1)/2;
            int counter = 1;
            for(int i = middle; i < A.length(); i++){
                if(i+counter < A.length()){
                    if(A.charAt(i+ counter)== A.charAt(i-counter)){
                        isSame = true;
                    }
                    else{
                        isSame = false;
                        break;
                    }
                }
                counter +=1;
            }

            if(isSame){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }else if(A.length() % 2 == 0){
            int middle = (A.length())/2;
            if(A.charAt(middle)== A.charAt(middle-1)){
                int counter = 1;
                int i = middle;
                while(i+counter < A.length()){
                    if(A.charAt(i + counter)== A.charAt((i-counter)-1)){
                        isSame = true;
                    }
                    else{
                        isSame = false;
                        break;
                    }
                    counter +=1;
                }

                if(isSame){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }else{
                System.out.println("No");
            }
        }
        else{
            System.out.println("No");
        }*/
    }
}
