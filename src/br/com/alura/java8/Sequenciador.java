package br.com.alura.java8;

import java.util.function.Consumer;

public class Sequenciador implements Consumer<String>{

	@Override
	public void accept(String s) {
		System.out.println("1º Consumer: " + s);
		
	}

}
