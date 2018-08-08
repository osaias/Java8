import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Pessoa{

	private String id;
	private String nome;
	private String nacionalidade;
	private int idade;
	List<Teste> list = new ArrayList<Teste>(); 
	
	public Pessoa(String id, String nome, String nacionalidade, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.idade = idade;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public int getIdade() {
		return idade;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}

public class Teste {
	
	public static void main(String[] args) {
		
		List<Pessoa> pessoas = Arrays.asList(
				new Pessoa("1","Osaias","Brasil",35),
				new Pessoa("2","Renata","EUA",10),
				new Pessoa("3","Jose","Argentina",11),
				new Pessoa("5","Maria","Alemanha",44),
				new Pessoa("4","Joana","Brasil",50),
				new Pessoa("7","Osaias","Brasil",32),
				new Pessoa("8","Matheus","Alemanha",25),
				new Pessoa("9","Lazaro","Brasil",02),
				new Pessoa("6","Tia","Portugal",80),
				new Pessoa("10","Osaias","Brasil",85),
				new Pessoa("12","Rose","Brasil",16),
				new Pessoa("11","Patricia","Brasil",10));
		
		//retorna um Stream de pessoas do Brasil
		System.out.println("--------------------------");
		System.out.println("DO BRASIL: ");
		System.out.println("--------------------------");
		Stream<Pessoa> stream = pessoas.stream().
				filter(p -> p.getNacionalidade().equals("Brasil"));
		stream.forEach(p -> System.out.println(p.getNome()));
		
		//retorna um stream de Pessoas do Brasil ordenando pela idade
		System.out.println("----------------------------------------------");
		System.out.println("DO BRASIL E OREDENADO PELA IDADE: ");
		System.out.println("----------------------------------------------");
		Stream<Integer> stream1 = pessoas.stream().
				filter(pessoa -> pessoa.getNacionalidade().equals("Brasil")).
				map(Pessoa::getIdade).sorted();
		stream1.forEach(p -> System.out.println(p.toString()));
		
		//retorna um stream de pessoas nÃ£o repetidas DE ACORDO COM MÃ‰TODO EQUALS().
		System.out.println("----------------------------------------------");
		System.out.println("LISTA DE PESSOAS NÃO REPETIDAS: ");
		System.out.println("----------------------------------------------");
		Stream<Pessoa> stream2 = pessoas.stream().distinct();
		stream2.forEach(p -> System.out.println(p.toString()));
		
		//retorna um stream de 3 pessoas
		System.out.println("----------------------------------------------");
		System.out.println("LISTA DE 3 PESSOAS: ");
		System.out.println("----------------------------------------------");
		Stream<Pessoa> stream3 = pessoas.stream().limit(3);
		stream3.forEach(p -> System.out.println(p.toString()));
		
		System.out.println("----------------------------------------------");
		double media = pessoas.stream().
				filter(p -> p.getNacionalidade().equals("Brasil")).
				mapToInt(Pessoa::getIdade).average().
				getAsDouble();
		System.out.println("Média das Idades:  " + media + " anos.");
		System.out.println("----------------------------------------------");
		
		System.out.println("----------------------------------------------");
		int qtd = (int) pessoas.stream().filter(p -> p.getNome().startsWith("O")).count();
		System.out.println("Qtd de nomes incia com a lestra O:  " + qtd);
		System.out.println("----------------------------------------------");
	}
}



