package br.com.alura.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TesteSequenciador {

	public static void main(String[] args) {

		Sequenciador seq = new Sequenciador();

		Consumer<String> after = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("2º Consumer: " + t);
				
			}
		};
		
		/**
		 *  consumer é uma referencia para (T t) -> { accept(t); after.accept(t); }
		 *  
		 *  Na chamada do consumer.accept(String.valueOf(i)), a JVM sabe que tem que executar o 
		 *  método abstrato da interface accept(), então executa primeiro:
		 *  	seq.accept() e depois o after.accept().
		 *  
		 *  Neste caso, há o conceito de polimorfismo e herança, pois executa o this.accept() e
		 *  o after.accept() que estão na memoria em tempo de execução.
		 */
		Consumer<String> consumer = seq.andThen(after);
		
		for (int i=0; i < 5; i++)
			consumer.accept(String.valueOf(i));
		
		consumer.accept("executando...");
	}

}
