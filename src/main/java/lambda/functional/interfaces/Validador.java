package lambda.functional.interfaces;

@FunctionalInterface
public interface Validador<T> {

	boolean valida(T t);
}
