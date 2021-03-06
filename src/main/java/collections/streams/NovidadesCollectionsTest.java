package collections.streams;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
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
		Filme filme6 = new Filme("2001: A Space Odyssey", 7);
		filmes = Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6);
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
	
	@Test
	public void TestaObtencaoList(){
		System.out.println("List");
		List<Filme> lista = new ArrayList<>(); 
		
		filmes.stream()
			.filter(f -> f.getNota() < 8)
			.forEach(f -> lista.add(f));
		
		//
		filmes.stream()
			.filter(f -> f.getNota() < 8)
			.forEach(lista::add);
		
		lista.forEach(System.out::println);		
	}

	@Test
	public void TestaObtencaoListComCollectors(){
		System.out.println("Collectors");
		List<Filme> lista = new ArrayList<>();
		
		lista = filmes.stream()
					.filter(f -> f.getNota() < 8)
					.collect(Collectors.toList());
		
		lista.forEach(System.out::println);		
	}
	

	@Test
	public void TestaObtencaoSetComCollectors(){
		System.out.println("Set");
		Set<Filme> set = filmes.stream()
							.filter(f -> f.getNota() < 8)
							.collect(Collectors.toSet());
		
		set.forEach(System.out::println);		
	}

	@Test
	public void TestaObtencaoSetComCollectorsEspecificandoImplementacao(){
		System.out.println("HashSet");
		Set<Filme> set = filmes.stream()
							.filter(f -> f.getNota() < 8)
							.collect(Collectors.toCollection(HashSet::new));
		
		System.out.println(set.getClass());
	}
	
	@Test
	public void TestaMapParaObtencaoNotas(){
		System.out.println("Map");
		List<Integer> listaNotas = 
				filmes.stream()
						.map(f -> f.getNota())
						.collect(Collectors.toList());
		
		assertEquals(6, listaNotas.size());
	}
	
	@Test
	public void TestaMapToIntParaObtencaoMediaNotasComIntStream(){
		System.out.println("Media");
		double mediaNotas = filmes.stream()
						.mapToInt(Filme::getNota)
						.average()
						.getAsDouble(); 
		assertEquals(7.5, mediaNotas, 00001);
	}
	
	@Test
	public void TestaOptimalParaObtencaoMedias(){
		System.out.println("Optimal");
		
		OptionalDouble mediaNotas = filmes.stream()
						.mapToInt(Filme::getNota)
						.average();
		
		assertEquals(7.5, mediaNotas.orElse(0.0), 00001);
		
		//
		double mediaNotasDouble = filmes.stream()
				.mapToInt(Filme::getNota)
				.average()
				.orElse(0.0);
	
		//
		mediaNotasDouble = filmes.stream()
				.mapToInt(Filme::getNota)
				.average()
				.orElseThrow(IllegalStateException::new);
		
		//
		filmes.stream()
			.mapToInt(Filme::getNota)
			.average()
			.ifPresent(System.out::println);
	}	
	
	@Test
	public void TestaMaiorNotaFilme(){
		System.out.println("Max");
		Optional<Filme> filme = filmes.stream()
									.max(Comparator.comparingInt(Filme::getNota));
		filme.ifPresent(System.out::println);
		
		Optional<String> nomeFilme = filmes.stream()
										.max(Comparator.comparingInt(Filme::getNota))
										.map(Filme::getNome);
		
		System.out.println(nomeFilme.orElse("Lista vazia"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
