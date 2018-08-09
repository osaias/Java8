package teste;

public interface Printable {

	void print(String s);
	
	default int count(String[] s) {
		return s.length;
		
	}
}
