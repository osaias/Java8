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
				System.out.println("2� Consumer: " + t);
				
			}
		};
		
		/**
		 *  consumer � uma referencia para (T t) -> { accept(t); after.accept(t); }
		 *  
		 *  Na chamada do consumer.accept(String.valueOf(i)), a JVM sabe que tem que executar o 
		 *  m�todo abstrato da interface accept(), ent�o executa primeiro:
		 *  	seq.accept() e depois o after.accept().
		 *  
		 *  Neste caso, h� o conceito de polimorfismo e heran�a, pois executa o this.accept() e
		 *  o after.accept() que est�o na memoria em tempo de execu��o.
		 */
		Consumer<String> consumer = seq.andThen(after);
		
		for (int i=0; i < 5; i++)
			consumer.accept(String.valueOf(i));
		
		consumer.accept("executando...");
	}

}
