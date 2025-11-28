package principal;

import clases.Numero;
import java.util.ArrayList;
import java.util.Collections;

public class ComparacionNumeros {

    public static void main(String[] args) {
        ArrayList<Numero> lista = new ArrayList<>();
        lista.add(new Numero(5));
        lista.add(new Numero(2));
        lista.add(new Numero(10));
        lista.add(new Numero(7));

        // Orden ascendente (compareTo)
        Collections.sort(lista);
        System.out.println("Ascendente: " + lista);
    }
}