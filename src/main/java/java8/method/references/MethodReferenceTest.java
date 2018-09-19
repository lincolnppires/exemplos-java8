package java8.method.references;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import java8.lambda.consumer.Filme;

public class MethodReferenceTest {
	
	private List<Filme> filmes;

	@Before
	public void setup() {
		Filme filme1 = new Filme("A Clockwork Orange", 8);
		Filme filme2 = new Filme("2001: A Space Odyssey", 7);
		Filme filme3 = new Filme("Full Metal Jacket", 6);

		filmes = Arrays.asList(filme1, filme2, filme3);
	}
	
	@Test
	public void TestaUsoMethodReference(){
		filmes.forEach(Filme::imprimiNome);
	}


}
