package principal;

import java.util.Scanner;

import utilidades.Util;

public class Ejercicio1 {
    public static void main(String[] args) {

        System.out.print("Introduce un número entero (en formato String): ");
        String strEntero = Util.introducirCadena();

        System.out.print("Introduce un número decimal (en formato String): ");
        String strDecimal = Util.introducirCadena();

        // Conversión de String a tipos numéricos
        int numeroEntero = Integer.parseInt(strEntero);
        double numeroDecimal = Double.parseDouble(strDecimal);

        // Operaciones
        double suma = numeroEntero + numeroDecimal;
        double resta = numeroEntero - numeroDecimal;
        double producto = numeroEntero * numeroDecimal;
        double cociente = numeroEntero / numeroDecimal;

        // Mostrar resultados con formato
        System.out.printf("Suma: %.2f%n", suma);
        System.out.printf("Resta: %.2f%n", resta);
        System.out.printf("Producto: %.2f%n", producto);
        System.out.printf("Cociente: %.2f%n", cociente);
    }
}
