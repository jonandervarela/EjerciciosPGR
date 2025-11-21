package principal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Principal2 {

	public static void main(String[] args) {

		ArrayList<String> alumnos = new ArrayList<>();

		alumnos.add("Ana");
		alumnos.add("Luis");
		alumnos.add("Marta");
		alumnos.add("Juan");
		alumnos.add("Pedro");

		Iterator<String> it = alumnos.iterator();

		System.out.println("Recorrer elementos:");
		while (it.hasNext()) {
			String valor = it.next();
			System.out.println(valor);

			if (valor.length() < 4) {
				it.remove();

			}

		}
		System.out.println("Lista actualizada: " + alumnos);

		ListIterator<String> listIt = alumnos.listIterator();

		System.out.println("Recorrer y modificar:");
		while (listIt.hasNext()) {
			String valor = listIt.next();
			System.out.println(valor);

			if (valor.startsWith("P")) {
				listIt.set(valor.toUpperCase());
			}

			if (valor.startsWith("M")) {
				listIt.add("Marcos");
			}

		}
		System.out.println(listIt.nextIndex());
		System.out.println("Segunda lista actualizada: " + alumnos);
		

		System.out.println("Recorrer hacia atrás:");
		while (listIt.hasPrevious()) {
			System.out.println(listIt.previousIndex());
			System.out.println(listIt.previous());
			
		}
		
		

	}
}