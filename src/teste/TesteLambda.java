package teste;

import java.util.ArrayList;
import java.util.List;

public class TesteLambda {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("Caelum");
		palavras.add("Alura Online");
		palavras.add("A casa do código");
		
		palavras.sort((s1,s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.forEach(s -> System.out.println(s));
		

	}

}
