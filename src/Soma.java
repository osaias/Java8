import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Soma {


	//Antes do java 5
	static Integer somaParNoJava1ao4(List list) {
		Iterator<Integer> it = list.iterator();
		int soma = 0;

		while(it.hasNext()) {
			int num = it.next();
			if (num % 2 == 0 ) {
				soma += num;
			}
		}
		return soma;
	}

	//No java 5
	static Integer somaParNoJava5(List<Integer> lista) {
		Iterator<Integer> it = lista.iterator();
		int soma = 0;

		for(int num : lista) {
			if (num % 2 == 0 ) {
				soma += num;
			}
		}
		return soma;
	}

	public static void main(String[] args) {

		int[] num = {1,2,3,4,5,6,7,8,9,10};
		List<Integer> lista = new ArrayList();

		for (int i=0; i < num.length; i++) {
			lista.add(num[i]);
		}
		
		System.out.println(Soma.somaParNoJava1ao4(lista));
		System.out.println(Soma.somaParNoJava5(lista));
	}
}
