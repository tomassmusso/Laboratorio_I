import java.util.Scanner;

public class Ejer6 {

    public static void main(String[] args){
        int numero_original, numero_a_desencriptar;
        String numero_encriptado, numero_desencriptado;
        Scanner lector;
        lector = new Scanner(System.in);
        System.out.println("Ingresar numero entero de 4 digitos: ");
        numero_original = lector.nextInt();

        numero_encriptado = encriptar(numero_original);
        System.out.println("Numero encriptado: " + numero_encriptado);

        System.out.println("Ingresar numero encriptado para desencriptar: ");
        numero_a_desencriptar = lector.nextInt();

        numero_desencriptado = desencriptar(numero_a_desencriptar);
        System.out.println("Numero orginal: " + numero_desencriptado);
    }

    public static String encriptar(int numero_original){
        String numero_encriptado;
        int d1, d2, d3, d4;
        d1 = (numero_original / 1000 + 7) % 10;
        d2 = ((numero_original / 100) % 10 + 7) % 10;
        d3 = ((numero_original / 10) % 10 + 7) % 10;
        d4 = (numero_original % 10 + 7) % 10;

        numero_encriptado = "" + d3 + d4 + d1 + d2;
        return numero_encriptado;
    }

    public static String desencriptar(int numero_encriptado){
        String numero_desencriptado;
        int o1, o2, o3, o4, d1, d2, d3, d4;
        d1 = numero_encriptado / 1000;
        d2 = (numero_encriptado / 100) % 10;
        d3 = (numero_encriptado / 10) % 10;
        d4 = numero_encriptado % 10;

        o1 = (d3 + 3) % 10;
        o2 = (d4 + 3) % 10;
        o3 = (d1 + 3) % 10;
        o4 = (d2 + 3) % 10;
        numero_desencriptado = "" + o1 + o2 + o3 + o4;
        return numero_desencriptado;
    }

}
