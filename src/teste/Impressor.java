package teste;

public class Impressor implements Printable{

	private String[] palavras;

	public Impressor(String[] palavras) {
		this.palavras = palavras;
	}

	@Override
	public void print(String s) {

		System.out.println(s);
	}
}
