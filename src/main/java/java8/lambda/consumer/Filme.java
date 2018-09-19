package java8.lambda.consumer;

public class Filme {
	
	private String nome;
	private Integer nota;
	private boolean censurado;
	
	
	public Filme(String nome, int nota) {
		this.nome = nome;
		this.nota = nota;
		this.censurado = false;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getNota() {
		return nota;
	}
	
	
	public void setCensurado(boolean censurado) {
		this.censurado = censurado;
	}

	public boolean isCensurado() {
		return censurado;
	}
	
	
}
