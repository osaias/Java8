package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TesteDefaultMethods {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("Caelum");
		palavras.add("Alura Online");
		palavras.add("A casa do código");

		//Este método chama o default method list.sort()
		Collections.sort(palavras,(s1,s2) -> Integer.compare(s1.length(), s2.length()));
		
		String[] p = {"Caelum", "A casa do código", "Alura cursos"};
		int qtdElementos = new Impressor(p).count(p);
		System.out.println(qtdElementos);

	}
	
}
