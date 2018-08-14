package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Quando usamos streams, geralmente trabalhamos com três elementos: 

	fonte de dados (p. ex., uma coleção) sobre a qual vai se fazer uma consulta;
	cadeia de operações intermediárias, que formam um processo;
	operação terminal, que executa o processo da stream e produz um resultado.
 * @author osaias.saraiva
 *
 */
public class TesteStreams {

	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<Curso>();

		Curso java1 = new Curso("Java", 150);
		Curso java2 = new Curso("Java", 300);
		Curso php = new Curso("PHP", 50);
		Curso html = new Curso("HTML", 180);
		Curso css = new Curso("CSS", 80);
		Curso spring = new Curso("Spring", 100);
		Curso nodeJs = new Curso("NodeJs", 10);
		Curso angular = new Curso("Angular", 5);

		Collections.addAll(cursos, java1, java2, php, html, css, spring, nodeJs, angular);

		cursos.stream().
		filter(c -> c.getAlunos() >= 100)
		.map(Curso::getNome)
		.distinct()
		.limit(10)
		.sorted(Comparator.comparing(String::toString))
		.forEach(c -> System.out.println(c));

	}

}
