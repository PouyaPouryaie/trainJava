package effectivejava.ch5;

//GenericSingletonFactory
public class GenericImmutable<T> {

    private final T t;
    private final long number;
    private final String name;

    private GenericImmutable(T t,long number, String name) {
        this.t = t;
        this.number = number;
        this.name = name;
    }

    public static GenericImmutable instanceOf(Object t, long number, String name){

        return new GenericImmutable(t,number, name);
    }

    public T getT() {
        return t;
    }

    public long getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
