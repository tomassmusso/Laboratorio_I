package ejercicio_horario;

public class Main{
    public static void main(String[] args){
        Horario hora1, hora2;
        hora1 = new Horario(22, 15, 35);
        hora2 = new Horario(19, 48, 12);
        //estado inicial
        System.out.println(hora1);
        System.out.println(hora2);
        hora2.sumarMinutos();
        System.out.println(hora2);

    }
}