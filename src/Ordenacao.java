import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class OrdemServico{

	public static final String ATIVACAO = "Ativo";
	private String tipo;
	private int id;
	private double valor;

	public OrdemServico(String tipo, int id, double valor) {
		this.id =id;
		this.tipo = tipo;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public double getValue() {
		return valor;
	}

	public String getType() {
		return tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		OrdemServico other = (OrdemServico) obj;
		if (id != other.id)
			return false;
		return true;
	}



}

public class Ordenacao {

	static List<OrdemServico> ordensParaAtivacao = new ArrayList<OrdemServico>();

	public static void main(String[] args) {

		List<OrdemServico> ordens = Arrays.asList(
				new OrdemServico("Ativo",2,5.60),
				new OrdemServico("Não tivo",3,15.60),
				new OrdemServico("Ativada",4,52.60),
				new OrdemServico("Ativo",0,58.60),
				new OrdemServico("Ativo",5,59.60),
				new OrdemServico("Ativo",6,577.60),
				new OrdemServico("Desativada",10,525.60),
				new OrdemServico("Ativo",8,578.60),
				new OrdemServico("Ativo",7,58.60));

		ordenaListaDeServicosNoJava7(ordens);
		ordensParaAtivacao = ordenaListaDeServicosNoJava8(ordens);
		System.out.println(ordensParaAtivacao);
	}

	public static void ordenaListaDeServicosNoJava7(List<OrdemServico> lista) {
		//Monta uma lista de serviços à ser ativada
		for(OrdemServico o: lista) {    
			if(o.getType() == OrdemServico.ATIVACAO) {  
				ordensParaAtivacao.add(o); 
			} 
		}

		//Ordena a lista pelo id
		Collections.sort(ordensParaAtivacao, new Comparator<OrdemServico>(){ 
			public int compare(OrdemServico t1, OrdemServico t2) {
				return t1.getId().compareTo(t2.getId());
			}
		});

		//Imprime a lista
		for(OrdemServico print: ordensParaAtivacao){      
			System.out.println(print.getId());
		}
	}

	public static List ordenaListaDeServicosNoJava8(List<OrdemServico> lista) {

		return lista.stream()
				.filter(o -> o.getType() == OrdemServico.ATIVACAO)
				.sorted(Comparator.comparing(OrdemServico::getId))
				.map(OrdemServico::getId)
				.collect(Collectors.toList());
	}
}
