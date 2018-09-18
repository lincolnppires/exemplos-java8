package exemplos.java8.lambda;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
	
	private List<Filme> filmes;

	@Before
	public void setup(){
		Filme filme1 = new Filme("A Clockwork Orange", 8);
		Filme filme2 = new Filme("2001: A Space Odyssey", 7);
		Filme filme3 = new Filme("Full Metal Jacket", 6);
		
		filmes = Arrays.asList(filme1,filme2, filme3); 
	}
	
	@Test
	public void testInterfaceConsumerComForEach(){
		ExibeNomeFilme consumidor = new ExibeNomeFilme();
		filmes.forEach(consumidor);
	}
	


}
