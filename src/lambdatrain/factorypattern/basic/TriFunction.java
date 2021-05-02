package lambdatrain.factorypattern.basic;

public interface TriFunction<T,R,U,K> {

    K apply(T t,R r, U u);
}
