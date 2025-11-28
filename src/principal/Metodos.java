package principal;

import java.util.ArrayList;

public class Metodos {

	public static void main(String[] args) {
		
		// Crear ArrayList
        ArrayList<String> fruta = new ArrayList<>();

        // add: añade elemento al final
        fruta.add("Manzana");
        fruta.add("Pera");
        fruta.add("Banana");
        System.out.println("Después de add(): " + fruta);

        // addAll: añade todos los elementos de otra colección
        ArrayList<String> otrasFrutas = new ArrayList<>();
        otrasFrutas.add("Uva");
        otrasFrutas.add("Melón");
        fruta.addAll(otrasFrutas);
        System.out.println("Después de addAll(): " + fruta);

        // contains: comprueba si un elemento está en la lista
        System.out.println("¿La lista contiene 'Pera'? " + fruta.contains("Pera"));

        // get: obtiene elemento por índice
        System.out.println("Elemento en la posición 2: " + fruta.get(2));

        // isEmpty: verifica si la lista está vacía
        System.out.println("¿Está vacía la lista? " + fruta.isEmpty());

        // remove: elimina un elemento específico
        fruta.remove("Melón");
        System.out.println("Después de remove(): " + fruta);

        // size: número de elementos
        System.out.println("Tamaño de la lista: " + fruta.size());

        // toArray: convertir la lista en un array
        String[] frutas = fruta.toArray(new String[0]);
        System.out.print("Array convertido: ");
        for (String elemento : frutas) {
            System.out.print(elemento + " ");
        }
        System.out.println();

        // clear: elimina todos los elementos
        fruta.clear();
        System.out.println("Después de clear(): " + fruta);

        // isEmpty de nuevo
        System.out.println("¿Está vacía ahora? " + fruta.isEmpty());

	}

}
