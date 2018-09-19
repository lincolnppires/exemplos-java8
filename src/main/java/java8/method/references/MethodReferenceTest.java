package java8.method.references;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

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

}
