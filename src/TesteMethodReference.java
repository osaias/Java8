import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class TesteMethodReference {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("Caelum");
		palavras.add("Alura Online");
		palavras.add("A casa do código");

		Function<String	, Integer> referenciaFuncao = s -> s.length();
		Comparator<String> comparador = Comparator.comparing(referenciaFuncao);
		palavras.sort(comparador);
				
		//method reference é igual um lambda, ou seja, uma referencia a uma operação.
		//usa um Consumer.accept(T t)
		palavras.forEach(System.out::println);
		//usa um Function.apply()
		palavras.sort(Comparator.comparing(String::length));
	}

}
