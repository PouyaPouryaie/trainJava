package basictrain.codetrain.javatrain;

import java.util.Scanner;

class Calculator{

    private boolean validated(int number, int power){
        return number >= 0 && (power >= 0);
    }

    protected int power(int number, int power) throws Exception {
        if(validated(number, power)){
            return (int) Math.pow((double)number, (double)power);
        }
        else{
            throw new Exception("n and p should be non-negative");
        }
    }
}

public class MoreExceptionsTrain {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}
