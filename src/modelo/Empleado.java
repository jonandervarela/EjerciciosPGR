package modelo;

import java.time.LocalDate;

public class Empleado extends Persona {
    private LocalDate fechaAlta;

    public Empleado(String nombre, LocalDate fechaNacimiento, LocalDate fechaAlta) {
        super(nombre, fechaNacimiento);
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    @Override
    public String toString() {
        return super.toString() + " | Fecha alta: " + fechaAlta.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}