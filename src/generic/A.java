package generic;

public class A {

    protected final int a;

    A(int a){
        this.a = a;
    }

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }
}
