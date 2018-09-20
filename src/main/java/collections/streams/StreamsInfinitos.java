package collections.streams;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamsInfinitos {

	@Test
	public void TestaStreamInfinitoComOperacaoCurtoCircuito(){
		Random random = new Random(0);
		
		Supplier<Integer> supplier = () -> random.nextInt();
		//generate é lazy - são gerados a medida que forem necessários
		Stream<Integer> stream = Stream.generate(supplier);
		
		//evitando boxing
		IntStream streamInt = IntStream.generate(() -> random.nextInt());
		
		List<Integer> numeros = streamInt
									.limit(10)
									.boxed() 
									.collect(Collectors.toList());
		
		numeros.forEach(System.out::println);
		
	}
	
	@Test
	public void TestaStreamInfinitoComOperacaoCurtoCircuitoInterfaceFluente(){
		Random random = new Random(0);
		
		List<Integer> numeros = IntStream
									.generate(() -> random.nextInt())
									.limit(10)
									.boxed()
									.collect(Collectors.toList());
		
		numeros.forEach(System.out::println);
	}
	
}
