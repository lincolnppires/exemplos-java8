package collections.streams.paralelo;

import java.util.stream.LongStream;

import org.junit.Test;

public class GerarNumeros {
	
	@Test
	public void TestaGeracaoNumeroParalelo(){
		
		long time = System.nanoTime();
		long sum =
				LongStream.range(0, 1_000_000_000)
					.parallel()
					.filter(x -> x % 2 == 0)
					.sum();
		System.out.println(sum);
		System.out.println("Custo Paralelo: " + (System.nanoTime() - time));
	}
	
	@Test
	public void TestaGeracaoNumero(){
		
		long time = System.nanoTime();
		long sum =
				LongStream.range(0, 1_000_000_000)
					.filter(x -> x % 2 == 0)
					.sum();
		System.out.println(sum);
		System.out.println("Custo: " + (System.nanoTime() - time));
	}

}
