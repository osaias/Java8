package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TesteOptional {

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
		
		/*List<Curso> cursosOrdenados = cursos.stream()
				.sorted(Comparator.comparing(c -> c.getNome()))
				.collect(Collectors.toList());
		
		cursosOrdenados.forEach(c -> System.out.println(c));
		
		Optional<Curso> primeiroCurso  = cursosOrdenados.stream().findFirst();*/
		
		Optional<Curso> primeiroCurso = cursos.stream()
			.sorted(Comparator.comparing(c -> c.getNome())).findFirst();

		
		if (primeiroCurso.isPresent()) {
			Curso curso = primeiroCurso.orElse(new Curso("Lógica de Programação", 0));
			primeiroCurso.ifPresent(c -> System.out.println("Primeiro Curso: " + c));
		}
		
		System.out.println("Soma de Alunos: " + cursos.stream().mapToInt(Curso::getAlunos).sum());
		System.out.println("Média de Alunos: " + cursos.stream().mapToInt(Curso::getAlunos).average());
		System.out.println("Total de Alunos: " + cursos.stream().mapToInt(Curso::getAlunos).count());
		System.out.println("Total de Alunos: " + cursos.stream().mapToInt(Curso::getAlunos).reduce(0, new IntBinaryOperator() {
			
			@Override
			public int applyAsInt(int left, int right) {
				// TODO Auto-generated method stub
				return right + left;
			}
		}));
		
		System.out.println("Total de Alunos: " + cursos.stream().mapToInt(Curso::getAlunos).reduce((x,y) -> y+x));
		
		IntSummaryStatistics statistics = cursos.stream().mapToInt(Curso::getAlunos).summaryStatistics();
		System.out.println("Curso com mais Alunos: " + statistics.getMax());
		System.out.println("Curso com menos Alunos: " + statistics.getMin());
		System.out.println("Alunos matriculados: " + statistics.getSum());
	}

}
