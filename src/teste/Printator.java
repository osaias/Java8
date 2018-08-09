package teste;

public class Printator {

	private String[] palavras;

	public Printator(String[] palavras) {
		this.palavras = palavras;
	}


	public void imprimir(Printable print) {

		for (int i=0; i < this.palavras.length; i++)
			print.print(this.palavras[i]);
	}
}
