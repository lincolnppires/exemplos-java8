package collections.streams;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;

public class ManipulacaoArquivosComStream {

	@Test
	public void TestaListaDeArquivos() throws IOException{
		
		Files.list(Paths.get("."))
				.forEach(System.out::println);
		
		Files.list(Paths.get("./src/main/java/collections/streams"))
			.filter(file -> file.toString().endsWith(".java"))
			.forEach(System.out::println);
		
	}
	
	static Stream<String> lines(Path p){
		try{
			return Files.lines(p);			
		} catch(IOException e){
			throw new UncheckedIOException(e);
		}
	}
	
	@Test
	public void TestaObtencaoDoConteudoDosArquivos() throws IOException{
		System.out.println("Conteudo");
		Files.list(Paths.get("./src/main/java/collections/streams"))
			.filter(file -> file.toString().endsWith(".java"))
			.flatMap(file -> lines(file))
			.forEach(System.out::println);
	}
}
