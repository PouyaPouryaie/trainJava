package streamtrain.exception;

@FunctionalInterface
public interface CheckedExceptionHandlerConsumer<Target, ExObj extends Exception> {

    void accept(Target target) throws ExObj;
}
