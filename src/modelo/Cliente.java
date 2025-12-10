package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private String codigo;
    private float altura;
    private List<Medicion> mediciones = new ArrayList<>();

    public Cliente(String nombre, LocalDate fechaNacimiento, float altura) {
        super(nombre, fechaNacimiento);
        this.altura = altura;
        generarCodigo();
    }

    private void generarCodigo() {
        String iniciales = getNombre().substring(0, 2).toUpperCase();
        String anio = String.valueOf(getFechaNacimiento().getYear());
        codigo = iniciales + "-" + anio.substring(anio.length() - 2);
    }

    public String getCodigo() {
        return codigo;
    }

    public float getAltura() {
        return altura;
    }

    public void agregarMedicion(Medicion m) {
        mediciones.add(m);
    }

    public float getUltimoPeso() {
        if (mediciones.isEmpty()) return 0;
        return mediciones.get(mediciones.size() - 1).getPeso();
    }

    public float calcularIMC() {
        if (altura <= 0) return 0;
        return getUltimoPeso() / (altura * altura);
    }

    public List<Medicion> getMediciones() {
        return mediciones;
    }

    @Override
    public String toString() {
        return super.toString() + " | Código: " + codigo + " | Altura: " + altura + " | IMC: " + String.format("%.2f", calcularIMC());
    }
}