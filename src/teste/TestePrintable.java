package teste;


public class TestePrintable{

	public static void main(String[] args) {
		
		String[] p = {"Caelum", "A casa do código", "Alura cursos"};
		Printator impressao = new Printator(p) ;
		
		System.out.println("Com classe Anonima: ");
		impressao.imprimir(new Printable() {
			
			@Override
			public void print(String s) {
				System.out.println(s);
				
			}
		});
		
		System.out.println("\nCom Lambda: ");
		impressao.imprimir(s -> System.out.println(s));
		
		//======================================================//
		
		Impressor print = new Impressor(p);
		System.out.println("\nCom método sobreescrito: ");
		for (int i=0; i < p.length; i++)
			print.print(p[i]);

	}

}

