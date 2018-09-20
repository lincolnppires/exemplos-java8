package collections.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import lambda.consumer.Filme;

public class GeradorMapas {
	
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
	public void TestaMapNotaFilmeListaDeFilmesComMesmaNota(){
		
		Map<Integer, List<Filme>> mapaNotas = new HashMap<>();
		
		for (Filme filme : filmes){
			mapaNotas
				.computeIfAbsent(filme.getNota(), f -> new ArrayList<>())
				.add(filme);
		}		
		System.out.println(mapaNotas);
	}
	
	
	

}

