import java.util.Scanner;

public class Ejer5 {

    public static void main(String[] args){
        String nombre, apellido, iniciales;
        Scanner lector;
        lector = new Scanner(System.in);
        System.out.println("Ingresar nombre: ");
        nombre = lector.nextLine();
        System.out.println("Ingresar apellido: ");
        apellido = lector.nextLine();

        iniciales = buscarIniciales(nombre, apellido);
        System.out.println("Iniciales: " + iniciales);
    }

    public static String buscarIniciales(String nombre, String apellido){
        return "" + nombre.charAt(0) + apellido.charAt(0);
    }
}
