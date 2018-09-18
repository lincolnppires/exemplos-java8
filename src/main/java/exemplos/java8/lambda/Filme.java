package exemplos.java8.lambda;

public class Filme {
	
	private String nome;
	private int nota;
	private boolean censurado;
	
	
	public Filme(String nome, int nota) {
		this.nome = nome;
		this.nota = nota;
		this.censurado = false;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getNota() {
		return nota;
	}
	
	
	public void setCensurado(boolean censurado) {
		this.censurado = censurado;
	}

	public boolean isCensurado() {
		return censurado;
	}
	
	
}
