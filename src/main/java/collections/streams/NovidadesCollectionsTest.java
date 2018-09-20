package collections.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import lambda.consumer.Filme;

public class NovidadesCollectionsTest {
	
	private List<Filme> filmes;

	@Before
	public void setup() {
		Filme filme1 = new Filme("A Clockwork Orange", 9);
		Filme filme2 = new Filme("2001: A Space Odyssey", 7);
		Filme filme3 = new Filme("Full Metal Jacket", 6);
		Filme filme4 = new Filme("The Shining", 8);
		Filme filme5 = new Filme("Lolita", 8);
		filmes = Arrays.asList(filme1, filme2, filme3, filme4, filme5);
	}
	
	@Test
	public void TestaFiltroTop3(){
		System.out.println("Aplicando metodo em um grupo");
		filmes.sort(Comparator.comparing(Filme::getNota).reversed());
		
		filmes
			.subList(0, 3)
			.forEach(Filme::setTop3);
		
		filmes.forEach(System.out::println);
	}
	
	@Test
	public void TestaFiltroComStream(){
		System.out.println("Stream - Filter");
		Stream<Filme> stream = filmes.stream();
		Stream<Filme> filter = stream.filter(f -> f.getNota() < 7);
		filter.forEach(System.out::println);

		//
		filmes.stream()
			.filter(f -> !f.isTop3())
			.forEach(System.out::println);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
