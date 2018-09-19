package java8.lambda.comparators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import java8.lambda.consumer.Filme;

public class ComparatorTest {

	private List<Filme> filmes;

	@Before
	public void setup() {
		Filme filme1 = new Filme("A Clockwork Orange", 8);
		Filme filme2 = new Filme("2001: A Space Odyssey", 7);
		Filme filme3 = new Filme("Full Metal Jacket", 6);

		filmes = Arrays.asList(filme1, filme2, filme3);
	}
	
	@Test
	public void TestaComparatorFilmes(){
		
		Comparator<Filme> comparator = new Comparator<Filme>() {
			
			@Override
			public int compare(Filme o1, Filme o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		};
		
		Collections.sort(filmes, comparator);
		filmes.forEach(f -> System.out.println(f.getNome()));
		
		System.out.println("###");
		
		Comparator<Filme> comparatorNota = (f1, f2) -> f1.getNota().compareTo(f2.getNota());
		Collections.sort(filmes, comparatorNota);
		filmes.forEach(f -> System.out.println(f.getNome()));
		
		System.out.println("###");
		Collections.sort(filmes, (f1,f2) ->  f1.getNome().compareTo(f2.getNome()));
		filmes.forEach(f -> System.out.println(f.getNome()));
	}
	
	@Test
	public void TestaComparatorString(){
		System.out.println("---");
		Collections.sort(filmes, (f1, f2) -> String.CASE_INSENSITIVE_ORDER.compare(f1.getNome(), f2.getNome()));
		filmes.forEach(f -> System.out.println(f.getNome()));
	}
	
	@Test
	public void TestaMetodoSortList(){
		System.out.println("***");
		filmes.sort((f1,f2) -> f1.getNota().compareTo(f2.getNota()));
		filmes.forEach(f -> System.out.println(f.getNome()));
	}
	
	@Test
	public void TestaFabricaDeComparators(){
		System.out.println("Fabrica de comparators");
		Comparator<Filme> comparator = Comparator.comparing(f -> f.getNome());
		filmes.sort(comparator);
		filmes.forEach(f -> System.out.println(f.getNome()));
	}
	
	@Test
	public void TestaOrdemNatural(){
		System.out.println("Natural Order");
		List<String> filmes = Arrays.asList("Full Metal Jacket", "A Clockwork Orange", "2001: A Space Odyssey");
		filmes.sort(Comparator.naturalOrder());
		filmes.forEach(f -> System.out.println(f));
		
		System.out.println("Reverse Order");
		filmes.sort(Comparator.reverseOrder());
		filmes.forEach(f -> System.out.println(f));
		
	}
}
