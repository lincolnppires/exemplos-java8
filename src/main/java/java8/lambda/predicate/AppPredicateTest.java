package java8.lambda.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import java8.lambda.consumer.Filme;

public class AppPredicateTest {

	private List<Filme> filmes;

	@Before
	public void setup() {
		Filme filme1 = new Filme("A Clockwork Orange", 8);
		Filme filme2 = new Filme("2001: A Space Odyssey", 7);
		Filme filme3 = new Filme("Full Metal Jacket", 6);

		filmes = new ArrayList<>();
		filmes.add(filme1);
		filmes.add(filme2);
		filmes.add(filme3);
	}
	
	@Test
	public void testeInterfacePredicate(){
		
		Predicate<Filme> predicado = new Predicate<Filme>() {
			@Override
			public boolean test(Filme filme) {
				return filme.getNota() > 7;
			}
		};
		
		filmes.removeIf(predicado);
		filmes.forEach(f -> System.out.println(f.getNome()));
	}

}
