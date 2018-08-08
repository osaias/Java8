package futebol;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jogadores {
	
	public boolean verificarArquivoExistente(Path caminho) {
		
		Stream<Path> stream;
		try {
			stream = Files.list(caminho);
			Optional<Path> arq = stream.filter(f -> f.toString().endsWith("jogadores.txt")).findAny();
			return arq.isPresent();
		} catch (IOException e) {
			System.out.println("Não conseguiu encontrar o arquivo" + e.getMessage());
		}
			
		return false;
	}
	
	public List getListaDeJogadores(Path caminho) throws IOException {
		
		Stream<String> linhas = Files.lines(caminho, StandardCharsets.UTF_8);
		List<String> listaDeLinhas = linhas.collect(Collectors.toList());
		List<Jogador> listaDeJogadores = new ArrayList();
		Iterator it = listaDeLinhas.listIterator();
		
		//Jogador jogador;
		String str = null;
		
		while(it.hasNext()) {
			str = (String) it.next();
			
			String info[] = str.split(",");
			Jogador jogador = new Jogador();
			
			jogador.setNome(info[0]);
			jogador.setPosicao(info[1]);
			jogador.setIdade(Integer.parseInt(info[2]));
			jogador.setTimeAtual(info[3]);
			jogador.setGolsMarcados(Integer.parseInt(info[4]));
			
			listaDeJogadores.add(jogador);
			
		}
		return listaDeJogadores;
	}
	
	public void imprimirJogadores(List<Jogador> listaDeJogadores) {
		System.out.println("---------------------------------");
		System.out.println("QUADRO DE ATLETAS:");
		System.out.println("---------------------------------");
		listaDeJogadores.stream().forEach(System.out::println);
	}
	
	public void imprimirJogadoresDoTime(List<Jogador> listaDeJogadores, String time) {
		System.out.println("---------------------------------");
		System.out.println("QUADRO DE ATLETAS DO " + time + ":");
		System.out.println("---------------------------------");
		listaDeJogadores.stream().filter(j -> j.getTimeAtual().equals(time)).
		forEach(System.out::println);
	}
	
	public void imprimirJogadoresComGolsPorTime(List<Jogador> listaDeJogadores, String time) {
		System.out.println("-------------------------------------");
		System.out.println("ATLETAS COM GOLS DO " + time + ":");
		System.out.println("-------------------------------------");
		listaDeJogadores.stream().
		filter(j -> j.getTimeAtual().equals(time) && j.getGolsMarcados() > 0)
		.sorted(Comparator.comparingInt(Jogador::getGolsMarcados))
		.forEach(System.out::println);
	}
	
	public void listarJogadoresPorTime(List<Jogador> listaDeJogadores) {
		/*listaDeJogadores.stream().sorted(Comparator.comparing(Jogador::getTimeAtual))
		.forEach(System.out::println);*/
		System.out.println("-------------------------------------");
		System.out.println("ATLETAS X TIME:");
		System.out.println("-------------------------------------");
		listaDeJogadores.stream().collect(
			      Collectors.groupingBy(Jogador::getTimeAtual)).values()
		.forEach(j -> j.forEach(System.out::println));
	}
	
	public double calcularMediaIdade(List<Jogador> listaDeJogadores) {
		return listaDeJogadores.stream().mapToInt(Jogador::getIdade).average().getAsDouble();
	}
	
	public double calcularMediaIdadeTime(List<Jogador> listaDeJogadores, String time) {
		return listaDeJogadores.stream().filter(j -> j.getTimeAtual().equals(time)).mapToInt(Jogador::getIdade).average().getAsDouble();
	}
	
	public void imprimirJogadorMaisVelho(List<Jogador> listaDeJogadores) {
		System.out.println("-------------------------------------");
		System.out.println("ATLETAS MAIS VELHO:");
		System.out.println("-------------------------------------");
		System.out.println(listaDeJogadores.stream().max(Comparator.comparingInt(Jogador::getIdade)).get().getNome().toString());
	}
	
	public void imprimirJogadorMaisNovo(List<Jogador> listaDeJogadores) {
		System.out.println("-------------------------------------");
		System.out.println("ATLETAS MAIS NOVO:");
		System.out.println("-------------------------------------");
		System.out.println(listaDeJogadores.stream().min(Comparator.comparingInt(Jogador::getIdade)).get().getNome().toString());
	}
	
	public void imprimirArtilheiro(List<Jogador> listaDeJogadores) {
		System.out.println("-------------------------------------");
		System.out.println("ARTILHEIRO:");
		System.out.println("-------------------------------------");
		System.out.println(listaDeJogadores.stream().max(Comparator.comparingInt(Jogador::getGolsMarcados)).get().getNome().toString());
	}
	
	public int imprimirSomatorioGols(List<Jogador> listaDeJogadores) {
		System.out.println("-------------------------------------");
		System.out.println("TOTAL DE GOLS DE TODOS OS JOGADORES:");
		System.out.println("-------------------------------------");
		return listaDeJogadores.stream().mapToInt(Jogador::getGolsMarcados).sum();
	}
}
