package futebol;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jogadores atletas = new Jogadores();
		
		Partida jogo = new Partida(new Time("São Paulo"),new Time("Palmeiras"));
		String path = "C:\\Users\\osaias.saraiva\\eclipse-workspace\\Java8\\src";
		String arquivo = "jogadores.txt";
		
		try {
			if (atletas.verificarArquivoExistente(Paths.get(path))) {
				List<Jogador> listaDeJogadores = atletas.getListaDeJogadores(Paths.get(path + "\\" + arquivo));
				
				atletas.imprimirJogadores(listaDeJogadores);
				System.out.println("Média de Idade: " + atletas.calcularMediaIdade(listaDeJogadores));
				System.out.println("Média de Idade do atletas do " + jogo.getTime1() + ": " + atletas.calcularMediaIdadeTime(listaDeJogadores, jogo.getTime1()));
				atletas.imprimirArtilheiro(listaDeJogadores);
				atletas.imprimirJogadoresComGolsPorTime(listaDeJogadores, jogo.getTime1());
				atletas.imprimirJogadoresDoTime(listaDeJogadores, jogo.getTime1());
				atletas.imprimirJogadorMaisNovo(listaDeJogadores);
				atletas.imprimirJogadorMaisVelho(listaDeJogadores);
				System.out.println(atletas.imprimirSomatorioGols(listaDeJogadores));
				atletas.listarJogadoresPorTime(listaDeJogadores);
				
			}
			
		} catch (IOException e) {
			System.out.println("Não conseguiu encontrar o arquivo: " + e.getMessage());
		}
	}

}
