import entidades.Horario;

public class Main {
    public static void main(String[] args) {
        Horario h1 = new Horario(21, 15, 30);
        Horario h2 = new Horario(12, 25, 18);
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        int suma = h2.sumarMinutos(h1);
        System.out.println("Suma de minutos: " + suma);
        int intervalo = h2.intevaloTiempoEnMinutos(h1);
        System.out.println("El intervalo es de " + intervalo + " minutos");
        int res = h2.cuantoFalta(h1);
        System.out.println("Faltan " + res);
    }
}