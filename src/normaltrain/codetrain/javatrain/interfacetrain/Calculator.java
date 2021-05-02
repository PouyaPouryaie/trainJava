package normaltrain.codetrain.javatrain.interfacetrain;

public class Calculator implements AdvancedArithmetic {

    @Override
    public int divisorSum(int n) {
        int sumResult = 0;
        for(int i = 1; i <=n; i++){
            if(n % i == 0)
                sumResult += i;
        }
        return sumResult;
    }
}
