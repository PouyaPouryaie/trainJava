package normaltrain.hirarchytrain;

public abstract class AClass {

    private int aM(int x){
        return x * 2;
    }

    public int bM(int x){
        return aM(x) * 2;
    }

    abstract int aAbstract(int x);
}
