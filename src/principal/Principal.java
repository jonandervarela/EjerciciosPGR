package principal;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import modelo.Cliente;
import modelo.Empleado;
import modelo.Medicion;
import modelo.Persona;
import util.Util;

public class Principal {

    public static void main(String[] args) {

        Map<String, Persona> personas = new HashMap<>();
        int opcion;

        do {
            opcion = menu();

            switch (opcion) {
                case 1:
                    altaPersona(personas);
                    break;
                case 2:
                    listadoClientes(personas);
                    break;
                case 3:
                    agregarMedicion(personas);
                    break;
                case 4:
                    estadisticaClientes(personas);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
    }

    private static int menu() {
        System.out.println("--- MENÚ ---");
        System.out.println("1. Alta Cliente / Empleado");
        System.out.println("2. Listado de Clientes");
        System.out.println("3. Añadir nueva medición a un Cliente y ver su evolución");
        System.out.println("4. Estadísticas de Clientes");
        System.out.println("5. Salir");
        return Util.leerInt("Elige una opción:");
    }

    private static void altaPersona(Map<String, Persona> personas) {
        int tipo = Util.leerInt("Introduce 1 para Cliente o 2 para Empleado:", 1, 2);
        String nombre = Util.introducirCadena("Nombre:");
        System.out.println("Introduce la fecha: ");
        LocalDate fn = Util.leerFechaDMA();

        if (tipo == 1) {
            float altura = Util.leerFloat("Altura en metros:");
            Cliente c = new Cliente(nombre, fn, altura);

            float peso = Util.leerFloat("Peso inicial (kg):");
            c.agregarMedicion(new Medicion(LocalDate.now(), peso));
            personas.put(nombre, c);
            System.out.println("Cliente añadido: " + c);
        } else {
            LocalDate fa = Util.leerFechaDMA();
            Empleado e = new Empleado(nombre, fn, fa);
            personas.put(nombre, e);
            System.out.println("Empleado añadido: " + e);
        }
    }

    private static void listadoClientes(Map<String, Persona> personas) {
        boolean hayClientes = false;
        for (Persona p : personas.values()) {
            if (p instanceof Cliente) {
                hayClientes = true;
                System.out.println(p);
            }
        }
        if (!hayClientes) System.out.println("No hay clientes registrados.");
    }

    private static void agregarMedicion(Map<String, Persona> personas) {
        String nombre = Util.introducirCadena("Nombre del cliente:");
        Persona p = personas.get(nombre);

        if (p == null || !(p instanceof Cliente)) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Cliente c = (Cliente) p;
        float peso = Util.leerFloat("Peso nuevo (kg):");
        c.agregarMedicion(new Medicion(LocalDate.now(), peso));

        System.out.println("Medición añadida. IMC actualizado: " + String.format("%.2f", c.calcularIMC()));
        System.out.println("Todas las mediciones:");
        for (Medicion m : c.getMediciones()) {
            System.out.println(m);
        }
    }

    private static void estadisticaClientes(Map<String, Persona> personas) {
        int[] conteo = new int[8];
        String[] categorias = {
                "Infrapeso: Delgadez Severa",
                "Infrapeso: Delgadez moderada",
                "Infrapeso: Delgadez aceptable",
                "Peso Normal",
                "Sobrepeso",
                "Obeso: Tipo I",
                "Obeso: Tipo II",
                "Obeso: Tipo III"
        };

        for (Persona p : personas.values()) {
            if (p instanceof Cliente) {
                float imc = ((Cliente) p).calcularIMC();

                if (imc < 16) {
                    conteo[0]++;
                } else {
                    if (imc < 17) {
                        conteo[1]++;
                    } else {
                        if (imc < 18.5) {
                            conteo[2]++;
                        } else {
                            if (imc < 25) {
                                conteo[3]++;
                            } else {
                                if (imc < 30) {
                                    conteo[4]++;
                                } else {
                                    if (imc < 35) {
                                        conteo[5]++;
                                    } else {
                                        if (imc <= 40) {
                                            conteo[6]++;
                                        } else {
                                            conteo[7]++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("--- Estadísticas de Clientes ---");
        for (int i = 0; i < categorias.length; i++) {
            System.out.println(categorias[i] + ": " + conteo[i]);
        }
    }
}