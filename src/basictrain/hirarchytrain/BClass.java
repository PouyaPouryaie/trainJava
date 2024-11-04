package basictrain.hirarchytrain;

public class BClass extends AClass {

    @Override
    int aAbstract(int x) {
        return x * 5;
    }

    public int cM(int x){
        return bM(x) * 2;
    }
}
