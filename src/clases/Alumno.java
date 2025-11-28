package clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno implements  Comparable<Alumno> {

	private String nif;
	private String nombre;
	private String apellido;
	private String apellido2;
	private LocalDate fecha;
	private Ciclo ciclo; // DAM o DAW
	private boolean repetidor;
	private ArrayList<Modulo> modulos = new ArrayList<>();
	
	public Alumno(String nif, String nombre, String apellido1, String apellido2, LocalDate fecha, Ciclo ciclo, boolean repetidor) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellido = apellido1;
		this.apellido2 = apellido2;
		this.fecha = fecha;
		this.ciclo = ciclo;	
		this.repetidor = repetidor;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public void setModulos(ArrayList<Modulo> modulos) {
		this.modulos = modulos;
	}

	// GETTERS Y SETTERS
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	// MÓDULOS SIMPLIFICADOS CON FOR NORMAL
	public ArrayList<Modulo> getModulos() {
		return modulos;
	}

	public void addModulo(String nombre, double nota) {
		modulos.add(new Modulo(nombre, nota));
	}

	public Modulo buscarModulo(String nombre) {
		for (int i = 0; i < modulos.size(); i++) {
			if (modulos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				return modulos.get(i);
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", nombre=" + nombre + ", apellido=" + apellido + ", apellido2=" + apellido2
				+ ", fecha=" + fecha + ", ciclo=" + ciclo + ", repetidor=" + repetidor + ", modulos=" + modulos + "]";
	}

	@Override
	public int compareTo(Alumno otro) {
		int resultado = this.apellido.compareToIgnoreCase(otro.apellido);

	    if (resultado == 0) {
	        resultado = this.apellido2.compareToIgnoreCase(otro.apellido2);
	    }

	    if (resultado == 0) {
	        resultado = this.nombre.compareToIgnoreCase(otro.nombre);
	    }

	    return resultado;
	}
	
	/*public int compareTo(Alumno otro) {
	    int resultado = this.ciclo.compareTo(otro.ciclo);

	    if (resultado == 0) {
	        resultado = this.apellido.compareToIgnoreCase(otro.apellido);
	    }

	    return resultado;
	}*/

	
	
}