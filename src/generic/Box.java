package generic;

public class Box<T> {

    protected T value;

    void box(T t){
        value = t;
    }

    T unBox(){
        T t = value;
        value = null;
        return t;
    }
}
