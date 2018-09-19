package java8.lambda.functional.interfaces;

@FunctionalInterface
public interface Validador<T> {

	boolean valida(T t);
}
