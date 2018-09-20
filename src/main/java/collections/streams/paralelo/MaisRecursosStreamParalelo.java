package collections.streams.paralelo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import lambda.consumer.Filme;

public class MaisRecursosStreamParalelo {
	
	private List<Filme> filmes;

	@Before
	public void setup() {
		Filme filme1 = new Filme("A Clockwork Orange", 9);
		Filme filme2 = new Filme("2001: A Space Odyssey", 7);
		Filme filme3 = new Filme("Full Metal Jacket", 6);
		Filme filme4 = new Filme("The Shining", 8);
		Filme filme5 = new Filme("Lolita", 8);
		Filme filme6 = new Filme("2001: A Space Odyssey", 7);
		filmes = Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6);
	}
	
	@Test
	public void TestaFiltroOrdenadoStream(){
		System.out.println("Filtro ordenado Paralelo");
		List<Filme> lista = filmes.parallelStream()
			.filter(f -> f.getNota() > 7)
			.sorted(Comparator.comparing(Filme::getNome))
			.collect(Collectors.toList());
		
		lista.forEach(System.out::println);
	}
	
	@Test
	public void TestaPeekParaExecucaoTodaVezQueProcessarUmElemento(){
		System.out.println("Peek - Paralelo");
		filmes.parallelStream()
			.filter(f -> f.getNota() > 7)
			.peek(System.out::println)
			.findAny();
	}
	
	@Test
	public void TestaOperacaoReduce(){
		System.out.println("Reduce - Paralelo");
		int somaNotas1 = filmes.parallelStream()
							.mapToInt(f -> f.getNota())
							.reduce(0, (a,b) -> a + b);
		//
		int somaNotas2 = filmes.parallelStream()
				.mapToInt(f -> f.getNota())
				.reduce(0, Integer::sum);
		
		//
		int somaNotas3 = filmes.parallelStream()
							.mapToInt(f -> f.getNota())
							.sum();
		//
		int somaNotas4 = filmes.parallelStream()
					.reduce(0, (nota, f) -> nota + f.getNota(), Integer::sum);
		assertTrue(somaNotas1 == somaNotas2 
				&& somaNotas2 == somaNotas3
				&& somaNotas3 == somaNotas4);
	}


















}

