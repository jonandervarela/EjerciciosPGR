package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int calcularEdad() {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + calcularEdad() + " | Fecha nacimiento: " + 
               fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}