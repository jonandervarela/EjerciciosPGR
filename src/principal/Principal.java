package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import clases.Alumno;
import clases.Ciclo;
import clases.Util;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		char opc = 0;

		do {

			opc = menuPrincipal();

			if (alumnos.isEmpty() && opc != 'A' && opc != 'S') {
				System.out.println("Error: no hay alumnos introducidos.");
				continue;
			}

			switch (opc) {

			case 'A':
				matricularAlumno(alumnos);
				break;

			case 'B':
				listadoDeAlumnos(alumnos);
				break;

			case 'C':
				listadoDeUnAlumno(alumnos);
				break;

			case 'D':
				introducirNotas(alumnos);
				break;

			case 'E':
				modificarNotaModulo(alumnos);
				break;

			case 'F':
				bajaAlumno(alumnos);
				break;

			case 'G':
				bajaModuloAlumno(alumnos);
				break;

			case 'H':
				introducirNotasModulo(alumnos);
				break;

			case 'I':
				mediaPorCiclo(alumnos);
				break;

			case 'J':
				ordenarPorNif(alumnos);
				listadoDeAlumnos(alumnos);
				break;

			case 'K':
				alumnosSuspensosModulo(alumnos);
				break;

			case 'L':
				maxMinModulo(alumnos);
				break;

			case 'M':
				alumnosSinEvaluarModulo(alumnos);
				break;

			case 'N':
				repetidoresPorCiclo(alumnos);
				break;

			case 'O':
				suspensosPorCiclo(alumnos);
				break;

			case 'S':
				System.out.println("Saliendo del programa...");
				break;

			default:
				System.out.println("❌ Opción no válida.");
			}

		} while (opc != 'S');
	}

	private static void suspensosPorCiclo(ArrayList<Alumno> alumnos) {
		int suspDAM = 0;
		int suspDAW = 0;

		for (Alumno a : alumnos) {
			for (var m : a.getModulos()) {
				if (m.getNota() < 5) {
					if (a.getCiclo() == Ciclo.DAM)
						suspDAM++;
					else
						suspDAW++;
				}
			}
		}

		System.out.println("Suspensos DAM: " + suspDAM);
		System.out.println("Suspensos DAW: " + suspDAW);

	}

	private static void repetidoresPorCiclo(ArrayList<Alumno> alumnos) {

		int repDAW = 0;
		int repDAM = 0;
		for (Alumno a : alumnos) {
			if (a.isRepetidor()) {
				if (a.getCiclo() == Ciclo.DAM)
					repDAM++;
				else
					repDAW++;
			}
		}

		System.out.println("Repetidores DAM: " + repDAM);
		System.out.println("Repetidores DAW: " + repDAW);

	}

	private static void alumnosSinEvaluarModulo(ArrayList<Alumno> alumnos) {
		System.out.println("Nombre del módulo: ");
		String modulo = Util.introducirCadena();

		for (Alumno a : alumnos) {
			if (a.buscarModulo(modulo) == null) {
				System.out.println(a);
			}
		}

	}

	private static void maxMinModulo(ArrayList<Alumno> alumnos) {
		System.out.println("Nombre del módulo: ");
		String modulo = Util.introducirCadena();

		double max = -1;
		double min = 11;

		for (Alumno a : alumnos) {
			if (a.buscarModulo(modulo) != null) {
				double nota = a.buscarModulo(modulo).getNota();

				if (nota > max)
					max = nota;
				if (nota < min)
					min = nota;
			}
		}

		if (max == -1) {
			System.out.println("No hay notas en ese módulo.");
		} else {
			System.out.println("Nota máxima: " + max);
			System.out.println("Nota mínima: " + min);
		}
	}

	private static void alumnosSuspensosModulo(ArrayList<Alumno> alumnos) {
		System.out.println("Nombre del módulo: ");
		String modulo = Util.introducirCadena();

		for (Alumno a : alumnos) {
			if (a.buscarModulo(modulo) != null && a.buscarModulo(modulo).getNota() < 5) {
				System.out.println(a);
			}
		}

	}

	private static void ordenarPorNif(ArrayList<Alumno> alumnos) {
		// TODO Auto-generated method stub

	}

	private static void mediaPorCiclo(ArrayList<Alumno> alumnos) {
		float sumaDAM = 0, sumaDAW = 0;
		int contDAM = 0, contDAW = 0;

		for (Alumno a : alumnos) {
			float sumaNotas = 0;
			int contNotas = 0;

			for (var m : a.getModulos()) {
				sumaNotas += m.getNota();
				contNotas++;
			}

			if (contNotas > 0) {
				float media = sumaNotas / contNotas;

				if (a.getCiclo() == Ciclo.DAM) {
					sumaDAM += media;
					contDAM++;
				} else {
					sumaDAW += media;
					contDAW++;
				}
			}
		}

		System.out.println("Media DAM: " + (contDAM > 0 ? sumaDAM / contDAM : "Sin datos"));
		System.out.println("Media DAW: " + (contDAW > 0 ? sumaDAW / contDAW : "Sin datos"));

	}

	private static void introducirNotasModulo(ArrayList<Alumno> alumnos) {
		System.out.println("Nombre del módulo: ");
		String nombreModulo = Util.introducirCadena();

		for (Alumno a : alumnos) {
			System.out.println("Alumno: " + a.getNombre());

			System.out.println("Nota: ");
			double nota = Util.leerFloat();
			a.addModulo(nombreModulo, nota);
		}

	}

	private static void bajaModuloAlumno(ArrayList<Alumno> alumnos) {
		System.out.println("Introduce NIF: ");
		String nif = Util.introducirCadena();
		int pos = buscarNif(alumnos, nif);

		if (pos == -1) {
			System.out.println("Alumno no encontrado.");
			return;
		}

		Alumno a = alumnos.get(pos);

		System.out.println("Módulo a eliminar: ");
		String modulo = Util.introducirCadena();

		a.getModulos().removeIf(m -> m.getNombre().equalsIgnoreCase(modulo));

		System.out.println("Módulo eliminado.");

	}

	private static void modificarNotaModulo(ArrayList<Alumno> alumnos) {
		System.out.println("Introduce NIF: ");
		String nif = Util.introducirCadena();
		int pos = buscarNif(alumnos, nif);

		if (pos == -1) {
			System.out.println("Alumno no encontrado.");
			return;
		}

		Alumno a = alumnos.get(pos);
		
		System.out.println("Introduce módulo: ");
		String modulo = Util.introducirCadena();

		if (a.buscarModulo(modulo) != null) {
			System.out.println("Nueva nota: ");
			double nuevaNota = Util.leerFloat();
			a.buscarModulo(modulo).setNota(nuevaNota);
		} else {
			System.out.println("Módulo no encontrado.");
		}

	}

	private static void introducirNotas(ArrayList<Alumno> alumnos) {
		System.out.println("Introduce el NIF del alumno: ");
		String nif = Util.introducirCadena();
		int pos = buscarNif(alumnos, nif);

		if (pos == -1) {
			System.out.println("Alumno no encontrado.");
			return;
		}

		Alumno a = alumnos.get(pos);

		char continuar;
		do {
			System.out.println("Nombre del módulo: ");
			String nombreModulo = Util.introducirCadena();
			System.out.println("Introduce nota: ");
			double nota = Util.leerFloat();

			a.addModulo(nombreModulo, nota);

			System.out.println("¿Introducir otro módulo? (S/N): ");
			continuar = Util.leerChar();
		} while (continuar == 'S');

	}

	private static void bajaAlumno(ArrayList<Alumno> alumnos) {
		String nif;
		int posicion;

		System.out.println("Introducir el NIF de alumno que desea dar de baja");
		nif = Util.introducirCadena();
		posicion = buscarNif(alumnos, nif);

		if (posicion >= 0) {
			alumnos.remove(posicion);
		} else {
			System.out.println("No se encuentra alumnno con ese NIF");
		}

	}

	private static int buscarNif(ArrayList<Alumno> alumnos, String nif) {
		int encontrado = -1;

		for (int i = 0; i < alumnos.size() && encontrado == -1; i++) {
			if (alumnos.get(i).getNif().equalsIgnoreCase(nif)) {
				encontrado = i;
			}
		}

		return encontrado;
	}

	private static void modificarRepetidor(ArrayList<Alumno> alumnos) {
		System.out.println("Introduce la edad mínima: ");
		int edadLimite = Util.leerInt();

		LocalDate hoy = LocalDate.now();
		int contador = 0;

		for (Alumno alumno : alumnos) {

			if (alumno.getCiclo() == Ciclo.DAW) {

				int edad = hoy.getYear() - alumno.getFecha().getYear();

				if (edad >= edadLimite) {
					alumno.setRepetidor(true);
					contador++;
				}
			}
		}

		System.out.println("Se han actualizado " + contador + " alumnos de DAW como repetidores.");

	}

	private static void modificarAlumno(ArrayList<Alumno> alumnos) {
		System.out.println("Introduce el NIF del alumno a modificar: ");
		String nif = Util.introducirCadena();
		int pos = buscarNif(alumnos, nif);

		if (pos >= 0) {
			Alumno alumno = alumnos.get(pos);

			System.out.println("Nuevo nombre: ");
			String nuevoNombre = Util.introducirCadena();
			alumno.setNombre(nuevoNombre);

			System.out.print("Nueva fecha de nacimiento (AAAA-MM-DD): ");
			LocalDate nuevaFecha = LocalDate.parse(Util.introducirCadena());
			alumno.setFecha(nuevaFecha);

			System.out.println("Datos actualizados correctamente.");
		} else {
			System.out.println("No se encontró ningún alumno con ese NIF.");
		}

	}

	private static void listadoDeUnAlumno(ArrayList<Alumno> alumnos) {
		System.out.println("Introduce el NIF del alumno: ");
		String nif = Util.introducirCadena();
		int pos = buscarNif(alumnos, nif);

		if (pos >= 0) {
			System.out.println(alumnos.get(pos).toString());
		} else {
			System.out.println("No se ha encontrado ningún alumno con ese NIF.");
		}

	}

	private static void listadoDeAlumnos(ArrayList<Alumno> alumnos) {
		Collections.sort(alumnos);
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i).toString());
		}

	}

	private static void matricularAlumno(ArrayList<Alumno> alumnos) {
		char continuar, esRepetidor;
		boolean repetidor = false;

		do {
			System.out.println("Introduce NIF: ");
			String nif = Util.introducirCadena();

			boolean estaEnDAM = false;
			boolean estaEnDAW = false;

			for (Alumno a : alumnos) {
				if (a.getNif().equalsIgnoreCase(nif)) {
					if (a.getCiclo() == Ciclo.DAM)
						estaEnDAM = true;
					if (a.getCiclo() == Ciclo.DAW)
						estaEnDAW = true;
				}
			}

			if (estaEnDAM && estaEnDAW) {
				System.out.println("Alumno/a ya introducido en los dos ciclos.");
			} else {

				Ciclo ciclo;

				if (estaEnDAM) {
					System.out.println("Ya está matriculado en DAM, solo puedes matricularlo en DAW");
					ciclo = Ciclo.DAW;
				} else if (estaEnDAW) {
					System.out.println("Ya está matriculado en DAW, solo puedes matricularlo en DAM");
					ciclo = Ciclo.DAM;
				} else {
					System.out.println("Introduce ciclo (DAM/DAW): ");
					ciclo = Ciclo.valueOf(Util.introducirCadena().toUpperCase());
				}

				System.out.println("Introduce nombre: ");
				String nombre = Util.introducirCadena();
				System.out.println("Introduce el apellido: ");
				String apellido1 = Util.introducirCadena();
				System.out.println("Introduce el segundo apellido: ");
				String apellido2 = Util.introducirCadena();

				System.out.print("Fecha nacimiento (AAAA-MM-DD): ");
				LocalDate fechaNacimiento = LocalDate.parse(Util.introducirCadena());

				System.out.println("¿Es repetidor? (S/N): ");
				esRepetidor = Util.introducirCadena().toUpperCase().charAt(0);
				if (esRepetidor == 'S') {
					repetidor = true;
				} else if (esRepetidor == 'N') {
					repetidor = false;
				}

				Alumno nuevo = new Alumno(nif, nombre, apellido1, apellido2, fechaNacimiento, ciclo, repetidor);
				alumnos.add(nuevo);
				System.out.println("Alumno matriculado correctamente en " + ciclo);
			}

			System.out.println("¿Quieres introducir otro alumno? (S/N): ");
			continuar = Util.introducirCadena().toUpperCase().charAt(0);

		} while (continuar == 'S');

	}

	private static char menuPrincipal() {
		System.out.println("\n===== MENÚ PRINCIPAL =====");
		System.out.println("A. Matricular alumno/a");
		System.out.println("B. Listado de alumnos");
		System.out.println("C. Listado completo de un alumno");
		System.out.println("D. Introducir notas de un alumno");
		System.out.println("E. Modificar nota de un módulo");
		System.out.println("F. Dar de baja a un alumno");
		System.out.println("G. Dar de baja un módulo de un alumno");
		System.out.println("H. Introducir notas de un módulo");
		System.out.println("I. Nota media de los alumnos de un ciclo");
		System.out.println("J. Mostrar alumnos ordenados por NIF");
		System.out.println("K. Alumnos suspendidos en un módulo");
		System.out.println("L. Nota máxima y mínima de un módulo");
		System.out.println("M. Alumnos sin evaluar en un módulo");
		System.out.println("N. Listado de repetidores por ciclo");
		System.out.println("O. Número de suspensos por ciclo");
		System.out.println("S. Salir");

		System.out.println("Elige una opción: ");
		return Util.introducirCadena().toUpperCase().charAt(0);
	}

}