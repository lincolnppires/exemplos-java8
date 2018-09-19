package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;



public class AppTest {

	private List<Filme> filmes;

	@Before
	public void setup() {
		Filme filme1 = new Filme("A Clockwork Orange", 8);
		Filme filme2 = new Filme("2001: A Space Odyssey", 7);
		Filme filme3 = new Filme("Full Metal Jacket", 6);

		filmes = Arrays.asList(filme1, filme2, filme3);
	}

	@Test
	public void testInterfaceConsumerComForEach() {
		ExibeNomeFilme consumidor = new ExibeNomeFilme();
		filmes.forEach(consumidor);
	}

	@Test
	public void TestClasseAnonimaComForEach() {
		Consumer<Filme> exibeNomeFilme = new Consumer<Filme>() {

			@Override
			public void accept(Filme filme) {
				System.out.println(filme.getNome());
			}
		};
		
		filmes.forEach(exibeNomeFilme);
	}
	
	@Test
	public void TestLambdaImpressaoComForEach(){
		filmes.forEach(f -> System.out.println(f.getNome()));
	}
	
	@Test
	public void TestLambdaSetarValorCensura(){
		filmes.forEach(f -> f.setCensurado(true));
		filmes.forEach(f -> assertTrue( f.isCensurado()));
	}
	
	@Test
	public void TestaComposicaoConsumer(){
		//bom exemplo do pattern decorator/proxy
		Consumer<Filme> msg = u -> System.out.println("Nome filme:");
		Consumer<Filme> exibe = u -> System.out.println(u.getNome());
		
		filmes.forEach(msg.andThen(exibe));
		
	}
		
	
	

}
