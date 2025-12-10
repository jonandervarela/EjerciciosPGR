package principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Principal {

    public static void main(String[] args) {

        // ================== OF ==================
        System.out.println("----- of() -----");

        LocalDate fecha = LocalDate.of(2025, 3, 10);
        LocalTime hora = LocalTime.of(14, 30);
        LocalDateTime fechaHora = LocalDateTime.of(2025, 3, 10, 14, 30);

        System.out.println("LocalDate: " + fecha);
        System.out.println("LocalTime: " + hora);
        System.out.println("LocalDateTime: " + fechaHora);

        // ================== FROM ==================
        System.out.println("\n----- from() -----");

        LocalDateTime ahora = LocalDateTime.now();
        LocalDate fechaDesdeDateTime = LocalDate.from(ahora);
        LocalTime horaDesdeDateTime = LocalTime.from(ahora);

        System.out.println("DateTime actual: " + ahora);
        System.out.println("Fecha desde DateTime: " + fechaDesdeDateTime);
        System.out.println("Hora desde DateTime: " + horaDesdeDateTime);

        // ================== PARSE ==================
        System.out.println("\n----- parse() -----");

        LocalDate fechaParse = LocalDate.parse("2025-03-10");
        LocalTime horaParse = LocalTime.parse("14:30:00");
        LocalDateTime dateTimeParse = LocalDateTime.parse("2025-03-10T14:30:00");

        System.out.println("Fecha parseada: " + fechaParse);
        System.out.println("Hora parseada: " + horaParse);
        System.out.println("DateTime parseado: " + dateTimeParse);

        // Con formato personalizado
        DateTimeFormatter formatoPersonalizado = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime fechaHoraPersonalizada = LocalDateTime.parse("10/03/2025 14:30", formatoPersonalizado);

        System.out.println("DateTime con formato personalizado: " + fechaHoraPersonalizada);

        // ================== FORMAT ==================
        System.out.println("\n----- format() -----");

        DateTimeFormatter formatoSalida = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String resultadoFormateado = ahora.format(formatoSalida);

        System.out.println("Fecha formateada: " + resultadoFormateado);

        // ================== GET ==================
        System.out.println("\n----- get() -----");

        int dia = ahora.getDayOfMonth();
        int mes = ahora.getMonthValue();
        int año = ahora.getYear();
        int horaActual = ahora.getHour();
        int minutoActual = ahora.getMinute();

        System.out.println("Día: " + dia);
        System.out.println("Mes: " + mes);
        System.out.println("Año: " + año);
        System.out.println("Hora: " + horaActual);
        System.out.println("Minuto: " + minutoActual);

        // ================== IS ==================
        System.out.println("\n----- is() -----");

        LocalDate hoy = LocalDate.now();
        LocalDate futuro = LocalDate.of(2030, 1, 1);

        System.out.println("¿Hoy es antes que 2030?: " + hoy.isBefore(futuro));
        System.out.println("¿Hoy es después que 2030?: " + hoy.isAfter(futuro));
        System.out.println("¿Hoy es igual que 2030?: " + hoy.isEqual(futuro));

        // ================== WITH ==================
        System.out.println("\n----- with() -----");

        // Modificar LocalDate
        LocalDate fechaOriginal = LocalDate.of(2025, 3, 10);
        LocalDate cambiarDia = fechaOriginal.withDayOfMonth(20);
        LocalDate cambiarAño = fechaOriginal.withYear(2030);

        System.out.println("Fecha original: " + fechaOriginal);
        System.out.println("Cambiando día: " + cambiarDia);
        System.out.println("Cambiando año: " + cambiarAño);

        // Modificar LocalDateTime
        LocalDateTime ahoraModificado = LocalDateTime.now();
        LocalDateTime cambiarHora = ahoraModificado.withHour(8).withMinute(0).withSecond(0);

        System.out.println("DateTime original: " + ahoraModificado);
        System.out.println("DateTime con hora cambiada: " + cambiarHora);
    }
}