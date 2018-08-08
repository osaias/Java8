package futebol;

public class Time {

	private String nome;
	private Jogadores integrantes;
	
	public Time(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Jogadores getIntegrantes() {
		return this.integrantes;
	}
}
