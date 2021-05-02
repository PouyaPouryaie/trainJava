package normaltrain.javacore.factorial;

/**
 * normal factorial
 * recursive factorial
 * tail - recursive factorial
 */
public class AllFactorialType {

    public static void main(String[] args) {

        System.out.println(normalFacRev(5));
        System.out.println(normalFacDyn(5));
        System.out.println(tailFacRev(5));
    }

    static int normalFacRev(int n){
        return n==1 ? 1 : n * normalFacRev(n-1);
    }

    static int normalFacDyn(int n){

        int result = 1;

        for(int i=n; i >=1; i--){
            result = result * i;
        }

        return result;
    }

    static int tailFacRev(int n){
        return tailFacHelper(1, n);
    }

    static int tailFacHelper(int acc, int n){
        return n == 1 ? acc : tailFacHelper(acc * n, n-1);
    }
}
