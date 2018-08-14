package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TesteClasseAnonima {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("Caelum");
		palavras.add("Alura Online");
		palavras.add("A casa do código");
		
		palavras.sort(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return Integer.compare(s1.length(), s2.length());
			}
		});
		
		palavras.forEach(new Consumer<String>() {

			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});

	}

}
