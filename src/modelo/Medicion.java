package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Medicion {
    private LocalDate fecha;
    private float peso;

    public Medicion(LocalDate fecha, float peso) {
        this.fecha = fecha;
        this.peso = peso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public float getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " | Peso: " + peso + "kg";
    }
}