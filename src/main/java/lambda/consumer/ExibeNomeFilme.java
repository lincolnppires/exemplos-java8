package lambda.consumer;

import java.util.function.Consumer;

public class ExibeNomeFilme implements Consumer<Filme> {

	@Override
	public void accept(Filme filme) {
		System.out.println(filme.getNome());
	}

}
