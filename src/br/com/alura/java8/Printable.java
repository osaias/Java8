package br.com.alura.java8;

public interface Printable {

	void print(String s);
	
	default int count(String[] s) {
		return s.length;
		
	}
}
