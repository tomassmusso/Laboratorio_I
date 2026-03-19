import entidades.Fecha;

public class Main {
    public static void main(String[] args) {
        Fecha fecha1, fecha2;
        int diferencia;
        fecha1 = new Fecha(14, 6, 2024);
        fecha2 = new Fecha(11, 3, 2026);
        System.out.println(fecha1.toString());
        // fecha1.setAnio(2026); // aca cambio el año
        System.out.println(fecha1.toString());
        System.out.println("Dia: " + fecha1.getDia());

        diferencia = fecha2.diferenciaAnios(fecha1);
        System.out.println("Diferencia: " + diferencia);
    }
}