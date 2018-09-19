package java8.method.references;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

import org.junit.Before;
import org.junit.Test;

import java8.lambda.consumer.Filme;

public class MethodReferenceTest {
	
	private List<Filme> filmes;

	@Before
	public void setup() {
		Filme filme1 = new Filme("A Clockwork Orange", 6);
		Filme filme2 = new Filme("2001: A Space Odyssey", 7);
		Filme filme3 = new Filme("Full Metal Jacket", 6);

		filmes = Arrays.asList(filme1, filme2, filme3);
	}
	
	@Test
	public void TestaUsoMethodReference(){
		
		filmes.sort(Comparator.comparing(Filme::getNome));
		filmes.forEach(Filme::imprimiNome);
		
		Function<Filme, Integer> nota = Filme::getNota;
		filmes.sort(Comparator.comparing(nota));
		filmes.forEach(Filme::imprimiNome);
	}
	
	@Test
	public void TestaComposicaoComparator(){
		System.out.println("###");
		filmes.sort(Comparator.comparingInt(Filme::getNota)
				.thenComparing(Filme::getNome));
		filmes.forEach(Filme::imprimiNome);
	}

	@Test
	public void TestaReferenciaMetodosComArgumentos(){
		//equivale: f -> System.out.println(f)
		filmes.forEach(System.out::println);
	}
	
	@Test
	public void TestaReferenciaConstrutor(){
		
		Supplier<Filme> fabricaFilme = Filme::new;
		
		Filme filme = fabricaFilme.get();
		System.out.println(filme);
		
		Function<String, Filme> fabricaFilme1Argumento = Filme::new;
		Filme filme2 = fabricaFilme1Argumento.apply("The Shining");
		System.out.println(filme2);
		
		BiFunction<String, Integer, Filme> fabricaFilme2Argumentos = Filme::new;
		Filme filme3 = fabricaFilme2Argumentos.apply("Lolita", 8);
		System.out.println(filme3);
		
	}
	
	@Test
	public void TestaOutrosTiposDeReferencia(){
		BiFunction<Integer, Integer, Integer> max = Math::max;
		ToIntBiFunction<Integer, Integer> max2 = Math::max;
		IntBinaryOperator max3 = Math::max;
	
		System.out.println(	
				"max: " + max.apply(10, 12) + 
				"\nmax2: " + max2.applyAsInt(10, 12) +
				"\nmax3: " + max3.applyAsInt(10, 12)
		
				);
		
	}

}
