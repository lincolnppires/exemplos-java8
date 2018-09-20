package lambda.consumer;

public class Filme {
	
	private String nome;
	private Integer nota;
	private boolean censurado;
	private boolean top3;
	
	public Filme() {
		this.nome = "null";
		this.nota = -1;
		this.censurado = false;
	}
	
	public Filme(String nome) {
		this.nome = nome;
		this.nota = -1;
		this.censurado = false;
	}
	
	
	public Filme(String nome, Integer nota) {
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
	
	public void setTop3(){
		this.top3 = true;
	}
	
	public boolean isTop3(){
		return this.top3;
	}
	
	public void imprimiNome(){
		System.out.println(nome);
	}

	@Override
	public String toString() {
		return "Filme [nome=" + nome + ", nota=" + nota + ", censurado=" + censurado + ", top3=" + top3 + "]";
	}

	
	
	
	
	
	
	
}
